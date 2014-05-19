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
${model.msg }
<h5><c:if test="${model.msg!= null } ">${model.msg}</c:if> </h5>
<h1>
	School Events - Admin
</h1>

	<div class="left-column border-box">
		<div class="navigation">
			<ul>
				<li><a href="/linkalma/schooladmin/addadminprofile?schoolName=${model.schoolName }">Admin Profile</a></li>
				<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
				<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
				<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
			</ul>
		</div>
	</div>
<form action="updateschoolnews" name="schoolUpdateForm">
<ul class="threeColumn clear-fix">
		<li><label>Newsletter</label> 
		</li><br>
		<li><label>Title</label> 
			<input type="text" value="" name="title" class="required" maxlength="50" />
			<input type="hidden" value="1" name="updateType" class="required" maxlength="50" />
			<input type="hidden" value="${model.school.schoolID }" name="schoolID" />
		</li>
	 	<li><label>Description</label> 
			<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
		</li>
		<li><input type="submit" value="Save" />
		</li>
	</ul>
</form>
<form action="updateschoolnews" name="schoolUpdateForm">
<ul class="threeColumn clear-fix">
		<li><label>Events</label> 
		</li><br>
		<li><label>Title</label> 
			<input type="text" value="" name="title" class="required" maxlength="50" />
			<input type="hidden" value="2" name="updateType" class="required" maxlength="50" />
			<input type="hidden" value="${model.school.schoolID }" name="schoolID" />
			<input type="hidden" value="${model.page }" name="page" />
		</li>
	 	<li><label>Description</label> 
			<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
		</li>
		<li><input type="submit" value="Save" />
		</li>
		
	</ul>
	</form>
	<form action="updateschoolnews" name="schoolUpdateForm">
	
<ul class="threeColumn clear-fix">
		<li><label>Projects</label> 
		</li><br>
		<li><label>Title</label> 
			<input type="text" value="" name="title" class="required" maxlength="50" />
			<input type="hidden" value="3" name="updateType" class="required" maxlength="50" />
			<input type="hidden" value="${model.school.schoolID }" name="schoolID" />
		</li>
	 	<li><label>Description</label> 
			<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
		</li>
		
		<li><input type="submit" value="Save" />
		</li>
	</ul>
</form>
<%@ include file="../footer.jsp"%>
