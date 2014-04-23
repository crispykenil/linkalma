<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>
<div class="profilePage" id="profilePage">
	<div class="left-column border-box">
		<div class="profile-pic">
			<img src="images/profile-pic.png" width="162px" height="158px" alt="" />
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
				<form action="" class="personalDetailsForm readOnlyForm">
					<h2>Personal Details </h2>
					<div>
						<ul class="twoColumn clear-fix">
							<li><label>First Name</label> <input type="text" value="Gautam"
								 name="userFirstName" class="required" maxlength="50" /></li>
							<li><label>Last Name</label> <input type="text" value="Sharma"
								 name="userLastName" class="required" maxlength="50" /></li>
							<li><label>Email</label> <input type="text" value="gautam@gmail.com"
								 name="emailAddress" class="emailField required" /></li>
							<li><label>Password</label> <input type="password" value="test"
								 name="password" class="required" /></li>
							<li><label>Confirm Password</label> <input type="password"
								value="test"  class="required" /></li>
							<li>
									<ul class="twoColumn" style="margin-top:22px;">
										<li><label class="fl">Male </label>
										<input type="radio" value=""  name="gender" checked /></li>
										<li><label class="fl">Female </label>
										<input type="radio" value=""  name="gender" /></li>
									</ul>
							</li>
						</ul>
					</div>
					<div>
						<h4>Family Details</h4>
						<ul class="twoColumn clear-fix">
							<li><label>Married To</label> <input type="text" value=""  name="userLastName" class="required" /></li>
							<li>
								<h5>No of Children</h5>
								<select disabled="disabled">
									<option>One</option>
									<option>Two</option>
									<option>Three</option>
									<option>Four</option>
									<option>Five</option>
								</select>
							</li>
			
						</ul>
					</div>
				
				
				<div>
					<h4>Contact Info</h4>
					<ul class="twoColumn clear-fix">
		
						<li><label>Address 1</label> <input type="text" value=""
							 name="userLastName" class="required" /></li>
						<li><label>Address 2</label> <input type="text" value=""
							 name="userLastName" class="" /></li>
						<li><label>City</label> <input type="text" value=""
							 name="userLastName" class="required" /></li>
						<li><label>State</label> <input type="text" value=""
							 name="userLastName" class="" /></li>
						<li><label>Country of Residence</label> <input type="text" value=""
							 name="userLastName" class="required" /></li>
						<li><label>Zip Code</label> <input type="text" value=""
							 name="userLastName" class="" /></li>
						<li><label>Cell</label> <input type="text" value="9324445952"
							 name="userLastName" class="numeric"  maxlength="10" /></li>
						<li><label>Work</label> <input type="text" value="02226165555"
							 name="userLastName"class="numeric"  maxlength="10" /></li>
						<li><label>Residence</label> <input type="text" value="02228730217"
							 name="userLastName" class="numeric" maxlength="10"/></li>
		
					</ul>
	
				</div>
				
					<div class="btn-wrapper">
						<input type="button" value="Edit" class="editUpdateFormBtn editForm" />
						<input type="reset" value="Cancel" class="button cancelUpdateAction" disabled="disabled"/>
					</div>
			</form>
			</div>
			<div id="schoolDetails">
			<form:form class="readOnlyForm schoolDetailsForm" action="updateprofile">
			<h2>School Details <a href="javascript:;" class="button  fr addMySchool">Add School</a></h2>
			<input type="hidden" name="totalUserSchoolCount" value="${model.userSchoolList.size()}" />
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
						
						<c:forEach var="userSchoolList" items="${model.userSchoolList}" varStatus="count">
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
								<td><input type="text" value="${userSchoolList.toYear}" placeholder="" name="fromYear_${count.index}" readonly="readonly" /></td>
								<td><input type="text" value="${userSchoolList.fromYear}" placeholder="" name="toYear_${count.index}" readonly="readonly" /></td>
								<td><input type="text" value="${userSchoolList.passOutBatch}" placeholder="" name="passOutBatch_${count.index}" readonly="readonly" /></td>
								<td><input type="text" value="${userSchoolList.branch}" placeholder="" name="branch_${count.index}" readonly="readonly" /></td>
							
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
