<%@ include file="header.jsp" %>

<div>
<h2>Password Reset</h2>
	
	<c:if test="${not empty errors}">
	<div class="errorMsg">
		<c:forEach items="${errors}" var="error">
			<c:out value="${error}" />
		</c:forEach>
		</div>
	</c:if>
	<c:if test="${empty errors}">
		<c:if test="${not empty model.msg}">
			<div class="infoPanel">${model.msg}</div>
		</c:if>
	
<form:form action="resetpassword" modelAttribute="resetForm" method="POST" id="resetPassword" >
	<input type="hidden" value="<%=request.getParameter("emailAddress") %>" name="emailAddress" id="emailAddress" />
	<input type="hidden" value="reset" name="type" id="type" />
	<ul>
		<li><label>New Password</label><input type="password" value="" placeholder="" name="password" autofocus="autofocus" class="required" /></li>
		<li><label>Confirm Password</label>	<input type="password" value="" placeholder=""  class="required" /></li>
		<li><input type="button" value="Reset Password" id="sign-in-button" class="button" onclick="submitPasswordResetForm()"/></li>
	</ul>
			
</form:form>
		
	</c:if>
</div>

<%@ include file="footer.jsp" %>

