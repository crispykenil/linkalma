<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Curriculum
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="search" name="searchForm">
<input type="text" name ="schoolName" />
<input type="text" name ="schoolAddress1" />
<input type="text" name ="schoolAddress2" />
<input type="text" name ="branch" />
<input type="text" name ="websiteAddress" />
<input type="submit" value="Submit" />
</form>
</body>
</html>
