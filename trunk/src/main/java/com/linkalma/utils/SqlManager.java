package com.linkalma.utils;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public final class SqlManager {

    /**
     * Constant for Name Space Separator.
     */
    private static final char NAME_SPACE_SEPARATOR = '.';

    /**
     * Map of SQLs loaded from xml files keyed by SQL name.
     */
    private volatile HashMap<String, HashMap<String, String>> sqlMap;


    /**
     * Default Constructor
     */
    public SqlManager() {
        sqlMap = new HashMap<String, HashMap<String, String>>();
    }


    /**
     * Parameterized Constructor
     * @param configs -
     *            List of SQL namespaces which will have List of files from
     *            where SQLs have to be loaded.
     */
    public SqlManager(List<List> configs) {
        this();
        initialize(configs);
    }


    /**
     * Initializing SQLMap
     * @param configs -
     *            List of query files grouped by SQL namespaces which will have
     *            List of files from where SQLs have to be loaded.
     */
    public void initialize(List<List> configs) {
        for (Iterator iter = configs.iterator(); iter.hasNext();) {
            List element = (List) iter.next();
            for (Iterator iterator = element.iterator(); iterator.hasNext();) {
                String xmlfile = (String) iterator.next();
                load(xmlfile.replace('\t', ' ').replace('\r', ' ')
                        .replace('\n', ' ').replace(" ", "").trim());
            }
        }
    }


    /**
     * Loading SQLs from xml files & populating XMLSQLMap.
     * @param filename -
     *            String filename value.
     */
    public void load(String filename) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // File inputFile = new File(filename);
            InputStream is = getClass().getClassLoader()
                    .getResourceAsStream(filename);
            Document doc = db.parse(is);
            Element rootElem = doc.getDocumentElement();

            if (rootElem != null && rootElem.getNodeName().equals("sql")) {
                HashMap<String, String> xmlSqlMap = null;
                String namespace = getAttribute(rootElem, "namespace");
                if (namespace != null) {
                    xmlSqlMap = sqlMap.get(namespace);
                    if (xmlSqlMap == null) {
                        xmlSqlMap = new HashMap<String, String>();
                    }
                } else {
                    throw new RuntimeException(
                            "Attribute \"namespace\" missing for file: "
                                    + filename);
                }
                NodeList nodelist = rootElem.getChildNodes();
                String sqlText = null;
                String cleanSqlText = null;
                Node statement = null;
                String nodeName = null;
                for (int j = 0; j < nodelist.getLength(); j++) {
                    statement = nodelist.item(j);
                    nodeName = getAttribute(statement, "name");
                    if (nodeName != null) {
                        sqlText = statement.getTextContent();
                        cleanSqlText = scrubSql(sqlText);
                        xmlSqlMap.put(nodeName, cleanSqlText);
                    }
                }
                sqlMap.put(namespace, xmlSqlMap);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    /**
     * Get SQL attributes including name.
     * @param n -
     *            nth node.
     * @param attrName -
     *            attribute to be retrieved.
     * @return String - String
     */
    public String getAttribute(Node n, String attrName) {
        if (n != null) {
            NamedNodeMap map = n.getAttributes();
            if (map != null) {
                Node node = map.getNamedItem(attrName);
                if (node != null) {
                    return node.getNodeValue();
                }
            }
        }
        return null;
    }


    /**
     * This method retrieves SQL Query from sqlMap populated by loading SQLs
     * from xml files using sqlName.
     * @param sqlName -
     *            String for SQLName with NO Namespace.
     * @return String - SQL Query
     */
    public String getSql(String sqlName) {
        if (sqlName != null && sqlName.length() > 0) {
            if (sqlName.indexOf(NAME_SPACE_SEPARATOR) != -1
                    && sqlName.indexOf(NAME_SPACE_SEPARATOR) < 20) {
                return getSqlNS(sqlName);
            }
            for (Iterator<HashMap<String, String>> iter = sqlMap.values()
                    .iterator(); iter.hasNext();) {
                HashMap<String, String> tempMap = iter.next();
                if (tempMap.containsKey(sqlName)) {
                    return tempMap.get(sqlName);
                }
            }
        }
        return sqlName;
    }


    /**
     * This method retrieves SQL Query from sqlMap populated by loading SQLs
     * from xml files using SQLName & Namespace.
     * @param sqlNameNS -
     *            String for SQL NameSpace alongwith Query Name
     * @return String - SQL Query
     */
    public String getSqlNS(String sqlNameNS) {
        if (sqlNameNS != null && sqlNameNS.length() > 0) {
            int index = sqlNameNS.indexOf(NAME_SPACE_SEPARATOR);
            if (index >= 0) {
                String namespace = sqlNameNS.substring(0, index);
                if (sqlNameNS.length() > index) {
                    String sqlName = sqlNameNS.substring(index + 1);
                    return getSqlNS(namespace, sqlName);
                }
            }
        }
        return sqlNameNS;
    }


    /**
     * This method fetches SQL Query from SQlMap using SQL namespace & SQL query
     * Name.
     * @param namespace -
     *            SQL Namespace
     * @param sqlName -
     *            SQL Query Name
     * @return String - SQL Query
     */
    public String getSqlNS(String namespace, String sqlName) {
        Map<String, String> tempMap = getNSMap(namespace);
        if (tempMap != null) {
            return tempMap.get(sqlName);
        } else {
            return "";
        }
    }


    /**
     * This method retrieves all queries associated with a SQL Namespace.
     * @param namespace -
     *            SQL Namespace
     * @return String - SQL Query
     */
    public Map<String, String> getNSMap(String namespace) {
        return sqlMap.get(namespace);
    }


    /**
     * This method is utilized to iron out whitespaces from queries loaded from
     * xml files.
     * @param dirty -
     *            dirty SQL Query String.
     * @return String - Clean SQL Query String.
     */
    private String scrubSql(String dirty) {
        if (dirty != null && dirty.length() > 0) {
            return dirty.replace('\t', ' ').replace('\r', ' ')
                    .replace('\n', ' ').replace("  ", " ");
        } else {
            return null;
        }
    }

}
