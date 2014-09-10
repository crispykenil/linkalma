<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>


<script type="text/javascript">

function fileUpload()
{

    document.forms["fileupload"].submit();
}
</script>
<div class="two-column-layout">

	<div class="left-column">
			<div class="vertical-main-nav">
				<ul>
					<li><a href="javascirpt:;">Personalize</a>
						<ul>
							<li><a href="viewprofile" title="Update Profile">Update Profile</a></li>
							<li><a href="javascirpt:;" title="Add Groups">Add Groups</a></li>
							<li><a href="javascirpt:;" title="Add Friends">Add Alumnus</a></li>
						</ul>
					</li>
					
				</ul>
				<ul>
					<li><a href="javascirpt:;">Links</a>
						<ul>
							<li><a href="notifications">My Notifications</a></li>
							<li><a href="myalumnus">My Alumnus</a></li>
							<li><a href="viewprofile">My Schools</a></li>
							<li><a href="javascirpt:;">My Groups</a></li>
						</ul>
					</li>
					
				</ul>
				<ul>
					<li><a href="javascirpt:;">Privacy Settings</a>
						<ul>
							<li><a href="javascirpt:;">My Data</a></li>
							<li><a href="javascirpt:;">My Updates</a></li>
						</ul>
					</li>
					
				</ul>
			</div>
		</div><!-- left-side-column -->

<div class="main-content border-box">
	<h1>My Notifications</h1>
	
	<table border="0" cellpadding="0" cellspacing="0" class="dataTable">
			<thead>
				<tr>
					<th> Name </th>
					<th> Email Address </th>
					<th> Status </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${model.pendingFriendRequest}" varStatus="count">
				<tr>
					<td>${user.userFirstName} ${user.userLastName}</td>
					<td>${user.emailAddress}</td>
					<td id="friendRequestLink${count.index}">
						<a href="#" onclick="sendFriendRequest('${user.emailAddress}', ${count.index}, 1);">Accept Friend Request ?</a> |
						<a href="#" onclick="sendFriendRequest('${user.emailAddress}', ${count.index}, 2);">Reject Friend Request ?</a> |
						<a href="#" onclick="sendFriendRequest('${user.emailAddress}', ${count.index}, 3);">Block Friend Request ?</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
	</table>
</div>
</div>
<%@ include file="footer.jsp"%>
