<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>

<div class="left-column border-box">
	<div class="profile-pic">
		<img src="images/profile-pic.png" width="162px" height="158px" alt="" />
	</div>
	<div class="navigation">
		<ul>
			<li><a href="javascript:;">Personal Details</a></li>
			<li><a href="javascript:;">School Details</a></li>
			<li><a href="javascript:;">Workplace details</a></li>
			<li><a href="javascript:;">Credit Card Details</a></li>
			<li><a href="javascript:;">Hobbies</a></li>
			<li><a href="javascript:;">Any Other information</a></li>
		</ul>
	</div>
</div>
<!-- left-column -->
<div class="main-content border-box">
	<div class="profileContainer">
		<h1>My Profile</h1>
		<div id="personalDetails">
			<h2>Personal Details <a href="javascript:;" class="button smalbtn fr">Edit</a></h2>
			<div>
				<ul class="threeColumn clear-fix">
					<li><label>First Name</label> <input type="text" value=""
						placeholder="" name="userFirstName" class="required" /></li>
					<li><label>Last Name</label> <input type="text" value=""
						placeholder="" name="userLastName" class="required" /></li>
					<li><label>Email</label> <input type="text" value=""
						placeholder="" name="emailAddress" class="required" /></li>
	
					<li><label>Password</label> <input type="password" value=""
						placeholder="" name="password" class="required" /></li>
					<li><label>Confirm Password</label> <input type="password"
						value="" placeholder="" class="required" /></li>
					<li><label>Residence</label><input type="text" value=""
						placeholder="" name="userLastName" class="required" /></li>
				</ul>
			</div>
			<div>
				<h4>Family Details</h4>
				<ul>
					<li><label>Married To</label> <input type="text" value=""
						placeholder="" name="userLastName" class="required" /></li>
					<li>
						<h5>Children</h5>
						<ol>
							<li><input type="text" value="" placeholder=""
								name="userLastName" class="required" /></li>
							<li><input type="text" value="" placeholder=""
								name="userLastName" class="required" /></li>
						</ol>
					</li>
	
				</ul>
			</div>
			<div>
			<h4>Contact Info</h4>
			<ul class="threeColumn clear-fix">

				<li><label>Address 1</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>Address 1</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>City</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>State</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>Country</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>Zip Code</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>Cell</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>Work</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>
				<li><label>Residence</label> <input type="text" value=""
					placeholder="" name="userLastName" class="required" /></li>

			</ul>

		</div>
		</div>
		<div id="schoolDetails">
		<form class="readOnlyForm">
			<h2>School Details <a href="javascript:;" class="button smalbtn fr editFormBtn">Edit</a></h2>
			
				<table class="dataTable">
						<thead>
							<tr>
								<th> School Name </th>
								<th> From Year </th>
								<th> To Year </th>
								<th> Batch</th>
								<th> Branch</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" value="Paddar School"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="1990"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="2000"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="First"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="Malad East"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
							</tr>
							<tr>
								<td><input type="text" value="Paddar School"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="1990"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="2000"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="First"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
								<td><input type="text" value="Malad East"	placeholder="" name="emailAddress"  readonly="readonly" /></td>
							</tr>
						</tbody>
				</table>
			</form>
		</div>
		<div id="workDetails">
			<h2>Workplace Details</h2>
		</div>
	</div>
</div>
<!-- main-content -->

<%@ include file="footer.jsp"%>
