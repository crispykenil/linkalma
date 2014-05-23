<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>


	<h1>My Profile</h1>
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
			<div id="personalDetails">
				<form:form action="updateprofile" name="personalDetailsForm" modelAttribute="userProfile" class="personalDetailsForm readOnlyForm" id="personalDetailsForm">
					<h2>Personal Details </h2>
					<div>
					<input type="hidden" value="${model.school.schoolID}"
								 name="schoolID" />
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

<%@ include file="../footer.jsp"%>
