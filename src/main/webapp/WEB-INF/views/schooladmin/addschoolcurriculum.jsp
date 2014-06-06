<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>

<div class="left-column border-box">
	<div class="navigation">
		<ul>
			<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
			<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
			<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
			<li><a href="/linkalma/schooladmin/addschoolgallery?schoolName=${model.schoolName }">School Gallery</a></li>
		</ul>
	</div>
</div>

<!-- left-column -->
<div class="main-content border-box">
	<h1>Syllabus</h1>
	<form action="updateschooldata" name="schoolDataForm" enctype="multipart/form-data" method="POST">
		<ul class="clear-fix">

			<li><label>Title</label> 
				<input type="text" value="" name="title" class="required" maxlength="50" />
			</li>
		 	<li><label>Description</label> 
				<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
			</li>
			<li><label>File</label> 
				<input type="file" name="uploadedFile" class="required" id="syllabusUploadedFile"/>
				<input type="hidden" name="dataType" value="1" />
				<input type="hidden" name="schoolName" value="${model.schoolName }"/>
			</li>
			<li><input type="submit" value="Save" />
			</li>
		</ul>
	</form>
	<hr />
	<h1>Calendar</h1>
	<form action="updateschooldata" name="schoolDataForm" method="POST" enctype="multipart/form-data" >
		<ul class="clear-fix">

			<li><label>Title</label> 
				<input type="text" value="" name="title" class="required" maxlength="50" />
			</li>
		 	<li><label>Description</label> 
				<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
			</li>
			<li><label>File</label> 
				<input type="file" name="uploadedFile" class="required" id="calenderUploadedFile" />
				<input type="hidden" name="dataType" value="2" />
				<input type="hidden" name="schoolName" value="${model.schoolName }"/>
				
			</li>
			<li><input type="submit" value="Save" />
			</li>
		</ul>
	</form>
	<hr />
	<h1>Exams</h1>
	<form action="updateschooldata" name="schoolDataForm" method="POST" enctype="multipart/form-data" >
		<ul class="clear-fix">

			<li><label>Title</label> 
				<input type="text" value="" name="title" class="required" maxlength="50" />
			</li>
		 	<li><label>Description</label> 
				<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
			</li>
			<li><label>Grade</label> 
				<input type="text" value="" name="grade" class="required" maxlength="20" /> 
			</li>
			<li><label>Division</label> 
				<input type="text" value="" name="division" class="required" maxlength="20" /> 
			</li>
			<li><label>File</label> 
				<input type="file" name="uploadedFile" class="required" id="examUploadedFile"/>
				<input type="hidden" name="dataType" value="3" />
				<input type="hidden" name="schoolName" value="${model.schoolName }"/>
			</li>
			<li><input type="submit" value="Save" />
			</li>
		</ul>
	</form>
	<table class="dataTable" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>Title </th>
				<th>Description</th>
				<th>Grade</th>
				<th>Division</th>
				<th>File</th>
				<th>Uploaded Date</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="schoolDataDto" items="${model.userProfile.userSchoolList}" varStatus="count">
			<tr>
				<td>
				<input type="text" value="${userSchoolList.schoolName} - ${userSchoolList.branch}" placeholder="" name="userSchoolList[${count.index}].schoolName"  />
				<input type="hidden" value="${userSchoolList.schoolID}" name="schoolID_${count.index}" />
				<select name="userSchoolList[${count.index}].schoolID">
					<c:forEach var="schoolList" items="${model.schoolList}">
						<option value="${schoolList.schoolID}"
						<c:if test="${schoolList.schoolID == userSchoolList.schoolID}">selected="selected"</c:if> > 
						${schoolList.schoolName } - ${schoolList.branch }
						</option>
					</c:forEach>
				</select> 
				</td>
				<td><input type="text" value="${userSchoolList.toYear}" placeholder="" name="userSchoolList[${count.index}].fromYear"  /></td>
				<td><input type="text" value="${userSchoolList.fromYear}" placeholder="" name="userSchoolList[${count.index}].toYear"  /></td>
				<td><input type="text" value="${userSchoolList.passOutBatch}" placeholder="" name="userSchoolList[${count.index}].passOutBatch"  /></td>
				<td><input type="text" value="${userSchoolList.branch}" placeholder="" name="userSchoolList[${count.index}].branch"  /></td>
			
				<td> <a href="deletemyschool?ID=${userSchoolList.userSchoolID}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</form>
</div>
<%@ include file="../footer.jsp"%>
