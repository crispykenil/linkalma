<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../headerResources.jsp"%>
<%@ include file="../schoolHeaderResources.jsp"%>

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
			<li><a href="#">My Profile</a> | <a href="#">Logout</a></li>
		</ul>
	</div>
</div>

<div id="hd" class="school-header" >
	<div class="header-content-wrapper">
		<div class="school-logo">
			<a href="/linkalma">RYAN INTERNATIONAL</a>
		</div>
		
	</div><!-- header-content-wrapper -->
</div><!-- hd -->
<h1>
	School Events - Admin
</h1>

	<div class="left-column border-box">
		<div class="navigation">
			<ul>
				<li><a href="/linkalma/schooladmin/addschoolbasics?schoolName=${model.schoolName }">School Basics</a></li>
				<li><a href="/linkalma/schooladmin/addadminprofile?schoolName=${model.schoolName }">Admin Profile</a></li>
				<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
				<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
				<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
			</ul>
		</div>
	</div>

<form action="search" name="searchForm">
<input type="text" name ="schoolName" />
<input type="text" name ="schoolAddress1" />
<input type="text" name ="schoolAddress2" />
<input type="text" name ="branch" />
<input type="text" name ="websiteAddress" />
<input type="submit" value="Submit" />
</form>
<%@ include file="../footer.jsp"%>
