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
			<a href="../linkalma">RYAN INTERNATIONAL</a>
		</div>
		
	</div><!-- header-content-wrapper -->
</div><!-- hd -->
<h1>
	About School - Admin
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="search" name="searchForm">
<div>
						<ul class="threeColumn clear-fix">
							<li><label>School Logo</label> 
								<input type="file" name="file" accept="image/*" class="button" onchange="javascript:fileUpload();">
							</li><br>
							<li><label>School Name</label> <input type="text" value=""
								 name="schoolName" class="required" maxlength="50" /></li>
						</ul>
					</div><input type="submit" value="Update" />
</form>
					<h3><a href="/linkalma/schooladmin/addschoolbasics">School Basics</a></h3>
					<h3><a href="/linkalma/schooladmin/addschoolcurriculum">Curriculum</a></h3>

</body>
<%@ include file="../footer.jsp"%>
