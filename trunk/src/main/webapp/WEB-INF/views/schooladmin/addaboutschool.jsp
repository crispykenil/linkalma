<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>


<script type="text/javascript">

function fileUpload()
{

    document.forms["fileupload"].submit();
}
</script>

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
	<form action="/linkalma/schooladmin/updateaboutschool" name="aboutSchoolForm" method="POST" enctype="multipart/form-data">
	
			<ul class=" clear-fix">
				<li><label>School Logo</label> 
					<input type="file" name="uploadedFile" accept="image/*" class="button" onchange="javascript:fileUpload();">
					<img alt="${model.schoolName } Logo" src="images/school/${model.logoFileName}/">
				</li> <br>
				<li><label>School Name</label> <input type="text" value="${model.school.schoolName }"
						 name="schoolName" class="required" maxlength="50" /></li><br>
				 <li><label>School Contact Info</label> <textarea value="" rows="8" cols="20" 
				 	name="schoolContact" class="required" maxlength="100" >${model.school.address1 } </textarea>
				 </li>
				 <br>
				  <li><label>School History</label> <textarea value=""
				 	name="schoolHistory" class="required" maxlength="5000" rows="8" cols="20" >${model.school.schoolHistory } </textarea>
				 </li><br>
				 				 <li><label>Website Address</label> <input type="text" value="${model.school.websiteAddress}"
				 	name="websiteAddress" class="required" maxlength="255" /> 
				 </li>
				 <br>
				 <li><label>Linkalma URL</label> <c:out value="${requestScope['javax.servlet.forward.context_path']}"></c:out>/<input type="text" value="${model.schoolName } "
				 	name="linkalmaUrl" class="required" maxlength="10" />
				 </li>
					<input type="hidden" name="destination" value="schooladmin" />
					<input type="hidden" name="schoolEmailAddress" value="${model.school.emailAddress}" />
			</ul>
	
		<input type="submit" value="Update" />
	</form>
</div>
<%@ include file="../footer.jsp"%>
