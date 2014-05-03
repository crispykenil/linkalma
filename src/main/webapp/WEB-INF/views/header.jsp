<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: LINK-ALMA ::</title>

	<!-- IF Alumni -->
		<%@ include file="headerResources.jsp"%>
	<!-- Else -->
	<c:if test="${model.schoolName != ''}">
		<%@ include file="schoolHeaderResources.jsp"%>
	</c:if>
</head>
<body>
<div id="top-bar">
	<div class="top-navigation fl">
		<ul>
			<li><a href="/linkalma">Home</a></li>
			<li><a href="/linkalma/dashboard">My Dashboard</a></li>
			<li><a href="/linkalma">About Us</a></li>
			<li><a href="/linkalma">Contact Us</a></li>
		</ul>
	</div>
	<div class="status-info-bar fr">
		<ul>
			<li><a href="/linkalma/viewprofile">My Profile</a> | <a href="/linkalma/logout">Logout</a></li>
		</ul>
	</div>
</div>
<div id="doc">
<c:if test="${model.schoolName != ''}">
	
	<div id="hd">
		<div class="header-content-wrapper">
			<div class="logo">
				<a href="/linkalma"></a>
			</div>
			<div class="fr">
				<div class="search-bar">
				<label>Search Your Freinds</label>
					<input type="text" value="" placeholder="" class="search-field"/>
				</div>
			</div>
		</div><!-- header-content-wrapper -->
	</div><!-- hd -->
	</c:if>
		<div id="bd">
		
			<div id="main-content-wrapper" class="clear-fix">
