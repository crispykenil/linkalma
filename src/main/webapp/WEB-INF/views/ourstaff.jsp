<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>

	<div class="school-staffs clear-fix">
	<h2>Our Staff</h2>
			
		<c:forEach items="${staffInfoList}" var="staff">
		
       	<div>
			<h3>${staff.facultyName}</h3>
			<div class="pic-container"><img src="${IMAGE_HOST_PATH}//${staff.photoName}" width="100%" height="185" /></div>
			<p class="description">
				 ${staff.subjectArea}</br>
			     ${staff.facultyEmail} <a href="javascript:;">read more</a>
			</p>
		</div>
		
		
	</c:forEach>					
	</div>
		
<%@ include file="footer.jsp"%>
