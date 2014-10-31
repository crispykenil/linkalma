<%@ include file="header.jsp" %>

<div class="border-box fa fa-lock " id="signup-panel">
<h2>Login</h2>
	<div class="sign-in-wrapper">
	<c:if test="${not empty errors}">
		<c:forEach items="${errors}" var="error">
			<div class="errorMsg">
				<c:out value="${error}" />
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${empty errors}">
		<c:if test="${not empty model.msg}">
			<div class="infoPanel">${model.msg}</div>
		</c:if>
	
		<form:form action="resetpassword" modelAttribute="resetForm" method="POST" >
				<input type="hidden" value="<%=request.getParameter("emailAddress") %>" name="emailAddress" id="emailAddress" />
				<input type="hidden" value="reset" name="type" id="type" />
				<label>New Password</label><input type="password" value="" placeholder="" name="password" autofocus="autofocus" class="required" />
				<label>Confirm Password</label>	<input type="password" value="" placeholder=""  class="required" />
				<input type="submit" value="Reset Password" id="sign-in-button" class="button"/>

			
		</form:form>
		
	</c:if>
</div>
</div>
<%@ include file="footer.jsp" %>

