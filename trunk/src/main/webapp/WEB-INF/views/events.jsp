<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>

<c:forEach var='schoolUpdatesMap' items='${model.schoolUpdatesMap}'>
								<h3>${schoolUpdatesMap.key}</h3>
						    <c:forEach var='schoolUpdateDto' items='${schoolUpdatesMap.value}' >
								<p><b>${schoolUpdateDto.title } </b></p>
								<p><pre>${schoolUpdateDto.description }</pre></p>
						    </c:forEach>
						</c:forEach>


<%@ include file="footer.jsp"%>
