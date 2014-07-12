<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>

	<div class="left-column border-box">
		<div class="navigation">
			<ul>
				<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
				<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
				<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
				<li><a href="/linkalma/schooladmin/addschoolgallery?schoolName=${model.schoolName }">School Gallery</a></li>
				<li><a href="/linkalma/schooladmin/addschoolstaff?schoolName=${model.schoolName }">School Staff</a></li>
			</ul>
		</div>
	</div><!-- left-column -->

<div class="main-content border-box">
	<form:form action="/linkalma/schooladmin/createstaff" name="staffForm" method="POST" enctype="multipart/form-data">
	
		<label>Faculty Name</label>
		<input type="text" name="facultyName"/>
		
		<label>Faculty Email ID</label>
		<input type="text" name="facultyEmail"/>
		
		<label>Subject Area</label>
		<input type="text" name="subjectArea"/>
		
		<label>Upload Image</label>
		<input type="file" name="uploadedFile" accept="image/*" class="button" />
		<input type="submit" name=""/>
		
	</form:form>	
</div>
<%@ include file="../footer.jsp"%>
