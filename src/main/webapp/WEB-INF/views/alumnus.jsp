<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="header.jsp" %>


<script type="text/javascript">

function fileUpload()
{

    document.forms["fileupload"].submit();
}
</script>
<div class="three-column-layout">
	<div class="left-column">
			<%@ include file="include/navigation.jsp" %>
	</div><!-- left-side-column -->
<div class="main-content border-box">
<div class="infoPanel message"></div>
	<form action="invitefriends" name="alumnusForm" id="alumnusForm" method="POST">
	<h1>My Alumnus</h1>
	<c:choose>
		<c:when test="${fn:length(model.myAlumnusList) gt 0}">
		<table border="0" cellpadding="0" cellspacing="0" class="dataTable">
			<thead>
				<tr>
					<th> Name </th>
					<th> Email Address </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${model.myAlumnusList}">
				<tr>
					<td>${user.userFirstName} ${user.userLastName}</td>
					<td>${user.emailAddress}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
      	<c:otherwise>
      		<div> You are not connected with any Alumnus!!!</div>
      	</c:otherwise>
	</c:choose>


	<h1>Invite Friends</h1>

		<ul class=" clear-fix">
			 <li><textarea value="" rows="8" cols="30" placeholder="Enter comma separated EmailID's"
			 	name="emailAddressesDelimited" class="required" maxlength="1024" id="emailAddressesDelimited" ></textarea>
			 </li>
		</ul>
	<br>
		<input type="button" value="Invite" onclick="sendFriendRequest('${model.loggedInUserName }', '', 999, 0, this);" />
	</form>
	
	<h1>Alumnus Suggestions</h1>
	<table border="0" cellpadding="0" cellspacing="0" class="dataTable">
		<thead>
			<tr>
				<th> Name </th>
				<th> Email Address </th>
				<th> Status </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${model.suggestedAlumniList}" varStatus="count">
			<tr>
				<td>${user.userFirstName} ${user.userLastName}</td>
				<td>${user.emailAddress}</td>
				<td id="friendRequestLink${count.index}"><a class="button" href="javascript:;" onclick="sendFriendRequest('${model.loggedInUserName }', '${user.emailAddress}', ${count.index}, 0, this);">Send Friend Request ?</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
<%@ include file="footer.jsp"%>
