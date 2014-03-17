<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:forEach items="${schoolList}" var="i">
<c:out value="Name: ${i.schoolName}"/>
<c:out value="Name: ${i.branch}"/>
<c:out value="Name: ${i.schoolAddress1}"/>
<c:out value="Name: ${i.schoolAddress2}"/>

<br>

</c:forEach>
</body>
</html>
