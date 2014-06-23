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
	<c:if test="${not empty model.schoolName}">
		<%@ include file="schoolHeaderResources.jsp"%>
	</c:if>
</head>

		
<c:choose>
      <c:when test="${empty model.schoolName}">
		<body>
      </c:when>
      <c:otherwise>
		<body id="schoolPageBody">			
      </c:otherwise>
</c:choose>

<div id="top-bar">
	<div class="top-navigation fl">
		<ul>
			<li><a href="/linkalma">Home</a></li>
			
			<li><a href="/linkalma">About Us</a></li>
			<li><a href="/linkalma">Contact Us</a></li>
		</ul>
	</div>
	
	<c:if test="${model.loggedIn == true}">
		<div class="status-info-bar fr">
		<ul>
			<li><a href="/linkalma/dashboard">My Dashboard</a></li><li><a href="/linkalma/viewprofile">My Profile</a>  <a href="/linkalma/logout" class="" title="Sign Out">Log Out</a></li>
		</ul>
	</div>
	</c:if>
	
</div>
<div id="doc">
<c:choose>
      <c:when test="${empty model.schoolName}">
	      <div id="hd">
			<div class="header-content-wrapper">
				<div class="logo">
					<a href="/linkalma"></a>
				</div>
				<div class="fr">
					<div class="search-bar">
					<label>Search Your Freinds</label>
						<input type="text" value="" placeholder="" class="search-field "/>
						<a href=";" class="fa fa-search" id="submitSearchBtn"></a>
					</div>
				</div>
			</div><!-- header-content-wrapper -->
		</div><!-- hd -->
      </c:when>
      <c:otherwise>
      <!-- school header starts -->
      	<div id="hd" class="school-header" >
			<div class="header-content-wrapper">
				<div class="school-logo fl">
					<a href="/linkalma/school/${model.schoolName }" style="text-transform: uppercase;">${model.schoolName }</a>
				</div>
				<div class="top-navigation fl">
					<ul>
						<li class="adminLink"><a href="/linkalma/schooladmin?schoolName=${model.schoolName }">Administrator</a></li>
					</ul>
				</div>
		
			</div><!-- header-content-wrapper -->
				<div class="clear-fix">
				<ul class="sf-menu clear-fix">
						<li><a href="/linkalma/school/${model.schoolName }">Home</a></li>
						<li><a href="/linkalma/school/${model.schoolName }/events">News & Events</a></li>
						<li><a href="/linkalma/school/${model.schoolName }/curriculum">Curriculum</a></li>
						<li><a href="/linkalma/school/${model.schoolName }/aboutus">About Us</a></li>
						<li><a href="/linkalma/school/${model.schoolName }/ourstaff">Our Staff</a></li>
						<li><a href="/linkalma/school/${model.schoolName }/gallery">Our Gallery</a></li>
						
					</ul>
		</div>
		</div><!-- hd -->

      </c:otherwise>
</c:choose>
<div id="bd">
	<div id="main-content-wrapper" class="clear-fix">
