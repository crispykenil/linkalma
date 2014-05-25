<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>

		<p><b>School History </b></p>
		<p>${model.school.schoolHistory}</p>

		<p><b>Contact Info: </b></p>
		Branch :
		<p>${model.school.branch}</p>
		Address:
		<p>${model.school.address1}</p>
		<p>${model.school.address2}</p>
		
		Phone:
		<p>${model.school.phone1}</p>
		<p>${model.school.phone2}</p>
		
<%@ include file="footer.jsp"%>
