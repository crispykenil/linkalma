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
	School Curriculum - Admin
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

<div>
<form action="updateschooldata" name="schoolDataForm" >
	<ul class="threeColumn clear-fix">
		<li><label>Syllabus</label> 
		</li><br>
		<li><label>Title</label> 
			<input type="text" value="" name="title" class="required" maxlength="50" />
		</li>
	 	<li><label>Description</label> 
			<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="50" ></textarea>
		</li>
		<li><label>File</label> 
			<input type="file" name="uploadedFile" class="required"  enctype="multipart/form-data" />
			<input type="hidden" name="destination" value="curriculum" />
			
		</li>
		<li><input type="submit" value="Save" />
		</li>
	</ul>
</form>
</div>
<table class="dataTable">
						<thead>
							<tr>
								<th>Title </th>
								<th>Description</th>
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
<%@ include file="../footer.jsp"%>
