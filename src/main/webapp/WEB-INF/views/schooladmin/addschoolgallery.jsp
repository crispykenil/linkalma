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
	<form  method="POST" action="createschoolgallery" name="schoolGalleryForm" enctype="multipart/form-data">
		<c:if test="${not empty model.msg}">
			<div class="infoPanel">${model.msg}</div>
		</c:if>
		<h1>Add Gallery</h1>
				<ul class=" clear-fix">
			<li>
				<label>Album Name</label>
				<input type="text" name="albumName"/>
			</li><br>
			<li>
				<label>Description</label>
				<input type="text" name="description"/>
			</li><br>
			<li>
				<label>Add Photos</label> 
				<input type="file" name="uploadedFileList" accept="image/*" class="button" multiple="multiple" />
				</li><br>
				<input type="hidden" name="destination" value="schoolgallery" />
			</ul>
		<input type="submit" value="Save Gallery" />
	</form>
		
</div>
<%@ include file="../footer.jsp"%>
