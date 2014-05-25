<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>
<div class="inner-page fl border-box">
<h1>About Us</h1>
<p>${model.school.schoolHistory}</p>
</div>
<div class="fr border-box fa fa-users inner-page-image" >
</div>
<!-- 
		<p><b>Contact Info: </b></p>
		Branch :
		<p>${model.school.branch}</p>
		Address:
		<p>${model.school.address1}</p>
		<p>${model.school.address2}</p>
		
		Phone:
		<p>${model.school.phone1}</p>
		<p>${model.school.phone2}</p>
	 -->	
<%@ include file="footer.jsp"%>
