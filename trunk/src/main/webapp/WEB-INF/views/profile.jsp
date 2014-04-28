<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>

<script type="text/javascript">

function fileUpload()
{

    document.forms["fileupload"].submit();
}
</script>

<div class="profilePage" id="profilePage">
	<div class="left-column border-box">
		<div class="profile-pic">
		<form:form action="uploadfile" name="fileupload" enctype="multipart/form-data" method="post" >
      		<img src="images/${model.profileImageURI }" onerror="this.src='images/profile-pic.png';" width="162px" height="158px" alt="" modelAttribute="uploadedFile" />
			<br> 
			<input type="file" name="file" accept="image/*" class="button" onchange="javascript:fileUpload();">
	  	</form:form>		
			
		</div>
		<div class="navigation">
			<ul>
				<li><a href="javascript:;">Personal Details</a></li>
				<li><a href="javascript:;">School Details</a></li>
				<li><a href="javascript:;">Workplace details</a></li>
				<!-- 
				<li><a href="javascript:;">Credit Card Details</a></li>
				<li><a href="javascript:;">Hobbies</a></li>
				<li><a href="javascript:;">Any Other information</a></li>  -->
			</ul>
		</div>
	</div>
	<!-- left-column -->
	<div class="main-content border-box">
			<h1>My Profile</h1>
			<div id="personalDetails">
				<form:form action="updateprofile" name="personalDetailsForm" modelAttribute="userProfile" class="personalDetailsForm readOnlyForm" id="personalDetailsForm">
					<h2>Personal Details </h2>
					<div>
						<ul class="twoColumn clear-fix">
							<li><label>First Name</label> <input type="text" value="${model.userProfile.userFirstName }"
								 name="userFirstName" class="required" maxlength="50" /></li>
							<li><label>Last Name</label> <input type="text" value="${model.userProfile.userLastName }"
								 name="userLastName" class="required" maxlength="50" /></li>
							<li><label>Email</label> <input type="text" value="${model.userProfile.emailAddress }"
								 name="emailAddress" class="emailField required" /></li>
							<li><label>Password</label> <input type="password" value="${model.userProfile.password }"
								 name="password" class="required" /></li>
							<li><label>Confirm Password</label> <input type="password"
								value="${model.userProfile.password }"  class="required" /></li>
							<li>
									<ul class="twoColumn" style="margin-top:22px;">
										<li><label class="fl">Male </label>
										<input type="radio" value="M"  
											name="gender" <c:if test="${model.userProfile.gender == 'M'}">checked</c:if> /></li>
										<li><label class="fl">Female </label>
										<input type="radio" value="F"  
										name="gender" <c:if test="${model.userProfile.gender == 'F'}">checked</c:if> /></li>
									</ul>
							</li>
						</ul>
					</div>
					<div class="family-details">
						<h4>Family Details</h4>
						<ul class="twoColumn_1-3 clear-fix">
						<li>
						<div id="maritalStatus">
							<label>Single</label> <input type="radio" value="" name="maritalStatus" class="single" checked="checked" />
							<label>Married</label> <input type="radio" value="" name="maritalStatus" class="married">
						</div>
						</li>
						<li>
							<div id="mairrageInfo">
								<label>Married To</label> <input type="text" value="Mamta Sharma"  class="required" />
								<label>No of Children</label>
								<select disabled="disabled">
									<option>One</option>
									<option>Two</option>
									<option>Three</option>
									<option>Four</option>
									<option>Five</option>
								</select>
							</div>
							
							</li>
						</ul>
					</div>
				<div>
					<h4>Contact Info</h4>
					<ul class="twoColumn clear-fix">
		
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
						<li><label>Zip Code</label> <input type="text" value=""
							 name="zipCode" class="" /></li>
						<li><label>Cell</label> <input type="text" value=""
							 name="code1" class="numeric" maxlength="3" size="1" /> <input type="text" value="${model.userProfile.phone1 }"
							 name="phone1" class="numeric" size="10"/></li>
						<li><label>Work</label> <input type="text" value=""
							 name="code2" class="numeric" maxlength="3" size="1" /> <input type="text" value="${model.userProfile.phone2 }"
							 name="phone2"class="numeric" size="10" /></li>
						<li><label>Residence</label> <input type="text" value=""
							 name="code3" class="numeric" maxlength="3" size="1" /> <input type="text" value="${model.userProfile.phone3 }"
							 name="phone3" class="numeric" maxlength="10" size="10" /></li>
		
					</ul>
	
				</div>
				
					<div class="btn-wrapper">
						<input type="button" value="Edit" class="editUpdateFormBtn editForm" />
						<input type="reset" value="Cancel" class="button cancelUpdateAction" disabled="disabled"/>
					</div>
			</form:form>
			</div>
			<div id="schoolDetails">
			<form:form class="readOnlyForm schoolDetailsForm" action="updateprofile" modelAttribute="userSchool" method="post">
			<h2>School Details <a href="javascript:;" class="button  fr addMySchool">Add School</a></h2>
			<input type="hidden" name="totalUserSchoolCount" value="${model.userProfile.userSchoolList.size()}" />
				<table class="dataTable">
						<thead>
							<tr>
								<th> School Name </th>
								<th> From Year </th>
								<th> To Year </th>
								<th> Batch</th>
								<th> Branch</th>
								<th>Action</th>
								
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="userSchoolList" items="${model.userProfile.userSchoolList}" varStatus="count">
							<tr>
								<td>
								<input type="text" value="${userSchoolList.schoolName} - ${userSchoolList.branch}" placeholder="" name="schoolName_${count.index}" readonly="readonly" />
								<input type="hidden" value="${userSchoolList.schoolID}" name="schoolID_${count.index}" />
								<select name="schoolID">
									<c:forEach var="schoolList" items="${model.schoolList}">
										<option value="${schoolList.schoolID}"
										<c:if test="${schoolList.schoolID == userSchoolList.schoolID}">selected="selected"</c:if> > 
										${schoolList.schoolName } - ${schoolList.branch }
										</option>
									</c:forEach>
								</select> 
								</td>
								<td><input type="text" value="${userSchoolList.toYear}" placeholder="" name="userSchoolList[${count.index}].fromYear" readonly="readonly" /></td>
								<td><input type="text" value="${userSchoolList.fromYear}" placeholder="" name="userSchoolList[${count.index}].toYear" readonly="readonly" /></td>
								<td><input type="text" value="${userSchoolList.passOutBatch}" placeholder="" name="userSchoolList[${count.index}].passOutBatch" readonly="readonly" /></td>
								<td><input type="text" value="${userSchoolList.branch}" placeholder="" name="userSchoolList[${count.index}].branch" readonly="readonly" /></td>
							
								<td> <a href="deletemyschool?ID=${userSchoolList.userSchoolID}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="btn-wrapper">
						<input type="button" value="Edit" class="editUpdateFormBtn editForm" />
						<input type="reset" value="Cancel" class="button cancelUpdateAction" disabled="disabled"/>
				</div>
			</form:form>
				<div id="addMydSchool" class="addMydSchoolContainer popupContent" style="width:450px">
	
					<h2>Add school to your profile</h2>
					<form:form action="addmyschool" name="addMySchool" method="post">
						<select name="schoolID">
							<c:forEach var="schoolList" items="${model.schoolList}">
								<option value="${schoolList.schoolID}" > ${schoolList.schoolName } - ${schoolList.branch }
							</c:forEach>
						</select> 
						<input type="text" value=""  name="fromYear" />
						<input type="text" value=""  name="toYear" />
						<input type="text" value=""  name="passOutBatch" />
						<input type="text" value=""  name="branch" />
						<input type="submit" class="button large" value="Add School" />
						
					</form:form>
					</div>
			</div>
			<div id="workDetails">
				<h2>Workplace Details</h2>
			</div>
	</div><!-- main-content -->
</div>
	

<%@ include file="footer.jsp"%>
