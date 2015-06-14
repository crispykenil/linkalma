<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<%@ include file="header.jsp" %>
		<c:if test="${empty errors}">
		<c:if test="${not empty model.msg}">
			<div class="infoPanel message">${model.msg}</div>
		</c:if>
		</c:if>
				<div class="registerSchoolContainer">
						<h2>Register New School</h2>
						<form action="registerschool" name="registerSchool" method="post" id="registerSchoolForm" >
							<ul>
								<li><label>School Name</label> <input type="text" value="" placeholder="" name="schoolName" class="required"/></li>
								<li><label>Branch</label><input type="text" value="" placeholder="" name="branch" class="required" /></li>
								<li><label>Address1</label><input type="text" value="" placeholder="" name="address1" class="required" /></li>
								<li><label>Address2</label><input type="text" value="" placeholder="" name="address2" /> </li>
								<li><label>Email</label><input type="text" value=""  placeholder="" name="emailAddress" class="required emailField" /> </li>
								<li><label>School Website URL</label><input type="text" value="" placeholder="" name="websiteAddress" /></li>
								<li><label>Linkalma URL</label><input type="text" value="" placeholder="" name="linkalmaAddress" class="required" /></li>
								<li><label>Password</label><input type="password" value="" placeholder="" name="password" class="required"/> </li>
								<li><label>Confirm Password</label> <input type="password" value="" placeholder="" /></li>
							</ul>
							<div class="align-center">
							 <input type="submit" class="button large" value="Register School" id="registerSchoolBtn"/>
							</div>
							
						</form>
					</div>
					<!--  
					<table border="0" cellpadding="0" cellspacing="0" class="dataTable">
						<thead>
							<tr>
								<th> School Name </th>
								<th> Address </th>
								<th> Branch </th>
								<th> Email Address </th>
								<th> LinkAlma URL </th>
								<th> Approved </th>
								<th> Active </th>
								<th> Created On </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="school" items="${model.schoolList}">
							<tr>
								<td>${school.schoolName}</td>
								<td>${school.address1}, ${school.address2} </td>
								<td>${school.branch}</td>
								<td>${school.websiteAddress}</td>
								<td>${school.schoolName}</td>
								<td>${school.approved}</td>
								<td>${school.active}</td>
								<td>${school.createDttm}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			-->
<%@ include file="footer.jsp" %>	


