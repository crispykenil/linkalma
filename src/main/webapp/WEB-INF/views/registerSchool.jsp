<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: LINK-ALMA ::</title>

<link href="css/reset.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/application.css" rel="stylesheet" type="text/css" media="screen" />

	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery.bpopup.min.js"></script>
	<script type="text/javascript" src="js/application.js"></script>
	<script type="text/javascript" src="js/jquery.tinycarousel.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#slider1').tinycarousel({ controls: false, pager: false, animation: true });
		});
	</script>
</head>
<body>


<div id="top-bar">
	<div class="top-navigation fl">
		<ul><li><a href="contact.html">Contact Us</a></li><li><a href="gallery.html">Photo Gallery</a></li><li><a href="whyus.html"> Why Us </a></li><li><a href="services.html">Services </a></li><li><a href="aboutus.html">About Us</a></li><li><a href="index.html">Home</a></li></ul>
	</div>
	<div class="status-info-bar fr">
		<ul>
			<li><a href="#">My Profile</a> | <a href="#">Logout</a></li>
		</ul>
	</div>
</div>
<div id="doc">
	<div id="hd">
		<div class="header-content-wrapper">
			<div class="logo">
				<a href="#"></a>
			</div>
			<div class="fr">
				<div class="search-bar">
					<input type="text" value="" placeholder="Search Your Freinds" class="search-field"/>
				</div>
			</div>
		</div><!-- header-content-wrapper -->
	</div><!-- hd -->
	
	<div id="bd">
		<div id="main-content-wrapper">
		
				<div class="registerSchoolContainer">
						<h2>Register New School</h2>
						<form action="registerSchool" name="registerSchool" method="post" id="registerSchoolForm" >
							<ul>
								<li><label>School Name</label> <input type="text" value="" placeholder="" name="schoolName" class="required"/></li>
								<li><label>Address1</label><input type="text" value="" placeholder="" name="address1" class="required" /></li>
								<li><label>Address2</label><input type="text" value="" placeholder="" name="address2" class="required" /> </li>
								<li><label>Email</label><input type="text" value=""  placeholder="" name="emailAddress" class="required emailField" /> </li>
								<li><label>Password</label><input type="password" value="" placeholder="" name="password" class="required"/> </li>
								<li><label>Confirm Password</label> <input type="password" value="" placeholder="" /></li>
							</ul>
							<div class="align-center">
							 <input type="submit" class="button large" value="Register School" id="registerSchoolBtn"/>
							</div>
							
						</form>
					</div>
					
					<table border="0" cellpadding="0" cellspacing="0" class="dataTable">
						<thead>
							<tr>
								<th> School Name </th>
								<th> Address </th>
								<th> Branch </th>
								<th> Email Address </th>
								<th> LinkAlma URL </th>
								<th> Approved </th>
								<th> Active </th>
								<th> Created On </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="school" items="${model.schoolList}">
							<tr>
								<td>${school.schoolName}</td>
								<td>${school.address1}, ${school.address2} </td>
								<td>${school.branch}</td>
								<td>${school.websiteAddress}</td>
								<td>${school.schoolName}</td>
								<td>${school.approved}</td>
								<td>${school.active}</td>
								<td>${school.createDttm}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
		</div><!-- main-wrapper -->
	</div><!-- bd -->
</div><!-- doc-->
<div id="ft">
	<script type="text/javascript" src="js/footer.js"></script>
</div><!-- ft -->

</body>
</html>
