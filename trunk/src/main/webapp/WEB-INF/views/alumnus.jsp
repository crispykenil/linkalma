<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>


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
	<form action="invitefriends" name="alumnusForm" method="POST">
	<h1>My Alumnus</h1>
	
			<ul class=" clear-fix">
				 <li><label>Invite Friend(s)</label> <textarea value="" rows="8" cols="30" placeholder="Enter comma separated EmailID's"
				 	name="emailAddressList" class="required" maxlength="1024" ></textarea>
				 </li>
			</ul>
	
		<input type="submit" value="Invite" />
	</form>
	
	<table border="0" cellpadding="0" cellspacing="0" class="dataTable">
						<thead>
							<tr>
								<th> Name </th>
								<th> Email Address </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${model.suggestedAlumniList}">
							<tr>
								<td>${user.userFirstName} ${user.userLastName}</td>
								<td>${user.emailAddress}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
</div>
<%@ include file="footer.jsp"%>
