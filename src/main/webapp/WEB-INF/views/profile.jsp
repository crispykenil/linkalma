<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="header.jsp"%>

<script type="text/javascript">

function fileUpload()
{

    document.forms["fileupload"].submit();
}
</script>

<div class="profilePage" id="profilePage">

	<!-- left-column -->
	<div class="main-content border-box">
			<h1>${model.userProfile.userFirstName } ${model.userProfile.userLastName }  - <span class="smallestFont">${model.userProfile.emailAddress }</span></h1>
			
			<div id="personalDetails">
				<h2>Personal Details 	<a href="javascript:;" class="fr fa fa-chevron-down collapse-expand-btn"></a></h2>
			
				<div class="personal-details-container clear-fix collapse-expand-content">
					<div class="profile-pic">
						<form:form action="uploadfile" name="fileupload" enctype="multipart/form-data" method="post" >
				      		<img src="images/${model.profileImageURI }" onerror="this.src='images/profile-pic.png';" width="150px" height="130px" alt="" modelAttribute="uploadedFile" />
							<br> 
							<input type="hidden" type="file" name="files" accept="image/*" class="button" onchange="javascript:fileUpload();" id="change-profilepic-btn">
							<input type="hidden" name="destination" value="userprofile" />
					  	</form:form>		
					
					</div>
					<div >
						<form:form action="updateprofile" name="personalDetailsForm" modelAttribute="userProfile" 
						class="personalDetailsForm readOnlyForm" id="personalDetailsForm">
							<div class="personal-info" style="width: 77%; margin-left: 235px">
								<ul class="threeColumn clear-fix">
									<li><label>First Name</label> <input type="text" value="${model.userProfile.userFirstName }"
										 name="userFirstName" class="required" maxlength="50" /></li>
									<li><label>Last Name</label> <input type="text" value="${model.userProfile.userLastName }"
										 name="userLastName" class="required" maxlength="50" /></li>
								<!-- 	<li><label>Email</label> <input type="text" readonly="readonly" value="${model.userProfile.emailAddress }"
										 name="emailAddress" class="emailField required" /></li> -->
									<li>
									<label>Gender</label>
									<fieldset style="display:inline-block; margin-left:10px">
										<label class="fl">Male&nbsp;</label>
										<input class="fl" type="radio" value="M" name="gender" 
											<c:if test="${model.userProfile.gender == 'M'}">checked</c:if> />
										<label class="fl">&nbsp;&nbsp;Female &nbsp;</label>
										<input class="fl" type="radio" value="F"  
												name="gender" <c:if test="${model.userProfile.gender == 'F'}">checked</c:if> />
									</fieldset>
										
									</li>
									<!-- 
									<li><label>Password</label> <input type="password" value="${model.userProfile.password }"
										 name="password" class="required" /></li>
									<li><label>Confirm Password</label> <input type="password"
										value="${model.userProfile.password }"  class="required" /></li>
							-->
								</ul>
								<div class="family-details">
									
									<ul class="twoColumn_1-3 clear-fix">
										<li>
											<div id="maritalStatus">
												<label>Single</label> <input type="radio" value="" name="maritalStatus" class="single" checked="checked" />
												<label>Married</label> <input type="radio" value="" name="maritalStatus" class="married">
											</div>
										</li>
										<li>
											<div id="mairrageInfo">
												<label>Spouse Name</label> <input type="text" value=""  class="required" />
												<label>No of Children</label>
												<input type="text" value=""	 name="noOfChild" class="numeric" maxlength="1" />
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="contact-info">
								<h3>Contact Info</h3>
								<ul class="threeColumn clear-fix">
					
									<li><label>Address 1</label> <input type="text" value="${model.userProfile.address1 }"
										 name="address1" class="required" /></li>
									<li><label>Address 2</label> <input type="text" value="${model.userProfile.address2 }"
										 name="address2" class="" /></li>
									<li><label>City</label> <input type="text" value="${model.userProfile.city }"
										 name="city" class="required" /></li>
									<li><label>State</label> <input type="text" value="${model.userProfile.state }"
										 name="state" class="" /></li>
									<li><label>Country of Residence</label> <input type="text" value="${model.userProfile.country }"
										 name="country" class="required" /></li>
									<li><label>Zip Code</label> <input type="text" value="${model.userProfile.zipCode }"
										 name="zipCode" class="required" /></li>
									<li><label>Cell</label> 
										<input type="text" value="${model.userProfile.phoneCode1 }" name="phoneCode1" class="numeric" maxlength="3" size="1" /> 
										<input type="text" value="${model.userProfile.phone1 }" name="phone1" class="numeric" size="10"/></li>
									<li><label>Work</label> 
										<input type="text" value="${model.userProfile.phoneCode2 }" name="phoneCode2" class="numeric" maxlength="3" size="1" /> 
										<input type="text" value="${model.userProfile.phone2 }"
										 name="phone2"class="numeric" size="10" /></li>
									<li><label>Residence</label> 
										<input type="text" value="${model.userProfile.phoneCode3 }" name="phoneCode3" class="numeric" maxlength="3" size="1" /> 
										<input type="text" value="${model.userProfile.phone3 }" name="phone3" class="numeric" maxlength="10" size="10" /></li>
					
								</ul>
				
							</div>
						
							<div class="btn-wrapper">
								<input type="button" value="Edit" class="editUpdateFormBtn editForm" />
								<input type="reset" value="Cancel" class="button lesser cancelUpdateAction" disabled="disabled"/>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<div id="schoolDetails">
				<h2>School Details  <a href="javascript:;" class="fr fa fa-chevron-down collapse-expand-btn"></a> </h2>
			<form:form name="userSchoolDetailsForm" id="userSchoolDetailsForm" class="readOnlyForm clear-fix schoolDetailsForm collapse-expand-content" 
			action="updateuserschool" modelAttribute="userSchool" method="post">
		
			<input type="hidden" name="totalUserSchoolCount" value="${fn:length(model.userProfile.userSchoolList)}" />
								<table class="dataTable" cellpadding="0" cellspacing="0">
						<thead>
							<tr>
								<th> School Name </th>
								<th class="table-year-col"> From Year </th>
								<th class="table-year-col"> To Year </th>
								<th class="table-year-col"> Batch</th>
								<th> Branch</th>
								<th class="align-center">Action</th>
								
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="userSchoolList" items="${model.userProfile.userSchoolList}" varStatus="count">
							<tr>
								<td>
							
								<input type="hidden" value="${userSchoolList.userSchoolID}" name="userSchoolList[${count.index}].userSchoolID" />
								<input type="hidden" value="${userSchoolList.schoolID}" name="schoolID_${count.index}" />
								<div class="select-drop-down">
									<select name="userSchoolList[${count.index}].schoolID">
										<c:forEach var="schoolList" items="${model.schoolList}">
											<option value="${schoolList.schoolID}"
											<c:if test="${schoolList.schoolID == userSchoolList.schoolID}">selected="selected"</c:if> > 
											${schoolList.schoolName } - ${schoolList.branch }
											</option>
										</c:forEach>
									</select> 
								</div>
								</td>
								<td><input type="text" value="${userSchoolList.fromYear}" placeholder="" name="userSchoolList[${count.index}].fromYear"  maxlength="4" /></td>
								<td><input type="text" value="${userSchoolList.toYear}" placeholder="" name="userSchoolList[${count.index}].toYear"  maxlength="4" /></td>
								<td><input type="text" value="${userSchoolList.passOutBatch}" placeholder="" name="userSchoolList[${count.index}].passOutBatch"  maxlength="4" /></td>
								<td><input type="text" value="${userSchoolList.branch}" placeholder="" name="userSchoolList[${count.index}].branch"  /></td>
							
								<td class="align-center"> <a href="deletemyschool?ID=${userSchoolList.userSchoolID}" class="fa fa-times delete-icon"></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="btn-wrapper">
				<input type="button" class="button addMySchool" value="Add School" />
					<input type="button" value="Edit" class="editUpdateFormBtn editForm" />
					
					<input type="reset" value="Cancel" class="button lesser cancelUpdateAction" disabled="disabled"/>
				</div>
			</form:form>
				<div id="addMySchool" class="addMydSchoolContainer popupContent" style="width:450px">
	
					<h2>Add school to your profile</h2>
					<form:form action="addmyschool" name="addMySchool" method="post">
						<label>School Name</label>
						<input type="text" name="schoolName" list="schoolID"/>
						<input type="hidden" name="schoolID"/>
						<datalist id="schoolID">
							<c:forEach var="schoolList" items="${model.schoolList}">
								<option id="${schoolList.schoolID}" value="${schoolList.schoolName } - ${schoolList.branch }" > ${schoolList.schoolName } - ${schoolList.branch }
							</c:forEach>
						</datalist> 
						<label>From Year</label>
						<input type="text" value=""  name="fromYear" maxlength="4" />
						<label>To Year</label>
						<input type="text" value=""  name="toYear" />
						<label>Passout</label>
						<input type="text" value=""  name="passOutBatch" />
						<label>Branch</label>
						<input type="text" value=""  name="branch" />
						<div class="btn-wrapper">
							<input type="submit" class="button large" value="Add School Details" />
						</div>
					</form:form>
				</div>
			</div>
			<div id="workDetails">
			<h2>Work Details <a href="javascript:;" class="fr fa fa-chevron-down collapse-expand-btn"></a></h2>
				<form:form class="readOnlyForm clear-fix workDetailsForm collapse-expand-content" action="updateworkplace" 
				name="userWorkplaceDetailsForm" id="userWorkplaceDetailsForm" modelAttribute="workDetails" method="post">
					
					<input type="hidden" name="totalUserWorkplaceCount" value="${fn:length(model.workplaceList)}" />
					<table class="dataTable" cellpadding="0" cellspacing="0">
						<thead>
							<tr>
								<th> Organisation Name </th>
								<th> From Date (MM / YYYY)</th>
								<th> To Date (MM / YYYY)</th>
								<th> Designation </th>
<!-- 								<th> Description </th> -->
								<th class="align-center"> Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="workplaceList" items="${model.workplaceList}" varStatus="count"	>
								<tr>
									<td><input type=hidden name="workplace[${count.index}].userWorkplaceID" value="${workplaceList.userWorkplaceID }">
										<input type="text" name="workplace[${count.index}].organisationName" value="${workplaceList.organisationName }">
									</td>
									<td>
										<input type="text" maxlength="7" name="workplaceList[${count.index}].fromMonthYear" value="${workplaceList.fromMonth}/${workplaceList.fromYear}">
										<input type="hidden" size="2" name="workplaceList[${count.index}].fromMonth" value="${workplaceList.fromMonth}" >
										<input type="hidden" size="4" name="workplaceList[${count.index}].fromYear" value="${workplaceList.fromYear}" maxlength="4" />
									</td>
									<td>
										<input type="text" maxlength="7" maxlength="2"  name="workplaceList[${count.index}].toMonthYear" value="${workplaceList.toMonth}/${workplaceList.toYear}">
										<input type="hidden" size="2" maxlength="2"  name="workplaceList[${count.index}].toMonth" value="${workplace.toMonth}">
										<input type="hidden" size="4" maxlength="4" name="workplaceList[${count.index}].toYear" value="${workplace.toYear}" >
									</td>
									<td><input type="text" name="workplaceList[${count.index}].designation" value="${workplaceList.designation}"></td>
<%-- 									<td><input type="text" name="workplaceList[${count.index}].description" value="${workplaceList.description}"></td> --%>
									<td class="align-center"> <a href="deletemyworkplace?ID=${workplaceList.userWorkplaceID}" class="fa fa-times delete-icon" ></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="btn-wrapper">
						<input type="button" value="Add Work Details"class="button addMyWorkDetaitsBtn" />
						<input type="button" value="Edit" class="editUpdateFormBtn editForm" />
						<input type="reset" value="Cancel" class="button lesser cancelUpdateAction" disabled="disabled" />
					</div> 
				</form:form>
				<div id="addMyWorkDetails" class="addMyWorkDetails popupContent" style="width:450px">
					<h2>Add Work Details</h2>
					<form:form action="addworkplace" name="addWorkPlace" method="post" id="addWorkPlaceForm" >
						<label>Organisation Name</label>
					 	<input type="text" value=""  name="organisationName" class="required" />	
						<label>From Date</label>
						<input type="text" value=""  name="fromMonthYear" id="fromMonthYear" placeholder="MM / YYYY" maxlength="7" class="required numeric" />
							<input type="hidden" value=""  name="fromYear" id="fromYear" />
							<input type="hidden" value=""  name="fromMonth" id="fromMonth" />
						<label>To Date</label>
						<input type="text" value=""  name="toMonthYear" id="toMonthYear"  placeholder="MM / YYYY" maxlength="7" class="required numeric" />
							<input type="hidden" value=""  name="toYear" id="toYear" />
							<input type="hidden" value=""  name="toMonth" id="toMonth" />
						<label>Designation</label>
						<input type="text" value=""  name="designation" class="required" />
						<label>Experience Summary</label>
						<textarea type="text" name="description" rows="5" cols="30">
							
						</textarea>
						
						<div class="btn-wrapper">
							<input type="submit" class="button large" value="Save Work Details" id="saveWorkPlaceBtn" />
						</div>
					</form:form>
				</div>
			</div>
	</div><!-- main-content -->
</div>
	

<%@ include file="footer.jsp"%>
