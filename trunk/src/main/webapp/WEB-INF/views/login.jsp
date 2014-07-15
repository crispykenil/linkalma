<%@ include file="header.jsp" %>
<style>
.sign-in-wrapper input[type=text], .sign-in-wrapper input[type=password]{
	width:79%;
}
#signup-panel {
	font-size: 566px;
	position: relative;
	margin: auto;
	color:#eee;
	background:none;
	display:block;
	width:360px
}
#signup-panel h2 {
	position:absolute;
	top:160px;
	left:148px;
	
}
#signup-panel:hover, #signup-panel.fa:hover {
	background:none
}
.sign-in-wrapper {
	position:absolute;
	bottom:140px;
	left:30px;
	width:85%
}
</style>

<div class="border-box fa fa-lock " id="signup-panel">
<h2>Login</h2>
	<div class="sign-in-wrapper">
	<c:forEach items="${errors}" var="error">
		<div class="errorMsg">
			<c:out value="${error}" />
		</div>
	</c:forEach>
		<form:form action="login" modelAttribute="loginForm" >
			<ul>
				<li><label>Email</label><input type="text" value="" name="userName" autofocus="autofocus" /> </li>
				<li><label>Password</label><input type="password" value="" name="password" /> </li>
				<li> <input type="submit" value="Sign In" id="sign-in-button" class="button"/>
				<a href="javascript:;" class="smallFont fr" title="Click here to reset your password" id="forgotPasswordBtn">Forgot password?</a>
				</li>

			</ul>
		</form:form>
</div>
</div>
<%@ include file="footer.jsp" %>

