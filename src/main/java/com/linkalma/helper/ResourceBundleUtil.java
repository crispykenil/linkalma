package com.linkalma.helper;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ResourceBundleUtil {

	private static ResourceBundleUtil resourceBundleUtil;
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"locale.xml","linkalma-beans.xml"});

	public String getProperty(String propName, Object valueArr[], Locale locale)
	{
		return context.getMessage(propName,  valueArr, locale);
	}
	

	public Object getBean(String beanID)
	{
		return context.getBean(beanID);
	}
	
	public static ResourceBundleUtil getInstance()
	{
		if(resourceBundleUtil == null)
			return resourceBundleUtil = new ResourceBundleUtil();
		else
			return resourceBundleUtil;
				
	}
	
	private ResourceBundleUtil()
	{
		
	}
	
	
}
