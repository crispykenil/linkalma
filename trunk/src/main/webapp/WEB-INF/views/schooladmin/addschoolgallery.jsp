<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>

	<div class="left-column border-box">
		<div class="navigation">
			<ul>
				<li><a href="/linkalma/schooladmin/addadminprofile?schoolName=${model.schoolName }">Admin Profile</a></li>
				<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
				<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
				<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
				<li><a href="/linkalma/schooladmin/addschoolgallery?schoolName=${model.schoolName }">School Gallery</a></li>
			</ul>
		</div>
	</div><!-- left-column -->

<div class="main-content border-box">
	<form action="updateschoolgallery" name="schoolGalleryForm" enctype="multipart/form-data">
	
			<ul class=" clear-fix">
				<li><label>Add Photos</label> 
					<input type="file" name="files" accept="image/*" class="button" onchange="javascript:fileUpload();" multiple="multiple">
				</li><br>
					<input type="hidden" name="destination" value="schoolgallery" />
			</ul>
	
		<input type="submit" value="Save Photos" />
	</form>
</div>
<%@ include file="../footer.jsp"%>
