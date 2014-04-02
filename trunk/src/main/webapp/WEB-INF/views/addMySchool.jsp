<%@ include file="header.jsp" %>
		
				<div id="addMydSchool" class="addMydSchoolContainer">
						<h2>Add school to your profile</h2>
						<form action="createProfile" name="userProfile" method="post">

							<input type="text" value="" placeholder="First Name" name="fName" />
							<input type="text" value="" placeholder="Last Name" name="lName" />
							<input type="email" value="" placeholder="Email" name="emailAddress" />
							<input type="password" value="" placeholder="Password" name="password" />
							<input type="password" value="" placeholder="Confirm Password" />
							<input type="date" value="" placeholder="DOB" name="dob" />
							<input type="text" value="" placeholder="Gender" name="gender" />
							
							<div id="capchaContainer"> <img src="images/captcha-image.jpg" />
							<input type="text" value="" placeholder="Enter Text" name="captcha" style="width:75px" /></div>
							
							<input type="submit" class="button large" value="Sign Up" />
						</form>
					</div>

<%@ include file="footer.jsp" %>