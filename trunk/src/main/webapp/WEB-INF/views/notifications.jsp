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

	<h1>My Notifications</h1>
	<c:choose>
		<c:when test="${fn:length(model.pendingFriendRequest) gt 0}">
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
							<a href="javascript:;" onclick="sendFriendRequest('${user.emailAddress}', '${model.loggedInUserName }',  ${count.index}, 1);"  
									class="fa fa-check" title="Accept Friend Request ?"></a> |
							<a href="javascript:;" onclick="sendFriendRequest('${user.emailAddress}', '${model.loggedInUserName }',  ${count.index}, 2);" 
									class="fa fa-times delete-icon" title="Reject Friend Request ?"></a> |
							<a href="javascript:;" onclick="sendFriendRequest('${user.emailAddress}', '${model.loggedInUserName }',  ${count.index}, 3);" 
									class="fa fa-ban " title="Block Friend Request ?"></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
      	<c:otherwise>
      		<div> You have 0 Notifications...</div>
      	</c:otherwise>
	</c:choose>
	
</div>
</div>
<%@ include file="footer.jsp"%>
