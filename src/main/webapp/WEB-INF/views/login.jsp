<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	LinkAlma - Login...
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="/j_security_check" name="loginForm">
<input type="text" name ="j_username" />
<input type="password" name ="j_password" />

<input type="submit" value="Submit" />
</form>
</body>
</html>
