<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>
<div id="school-update-page">
<h1>Our Updates</h1>
<div class="threeColumn " >
<c:forEach var='schoolUpdatesMap' items='${model.schoolUpdatesMap}'>

	<div class="panel">
		<div class="panel-head">
			<h3>${schoolUpdatesMap.key}</h3>
		</div>
		<div class="panel-body">
		<ul>
			<c:forEach var='schoolUpdateDto' items='${schoolUpdatesMap.value}' >
			<li>
				<h4>${schoolUpdateDto.title } </h4>
				<p>${schoolUpdateDto.description }</p>
			</li>
		    </c:forEach>
		    </ul>
		</div>
	</div>

</c:forEach>
</div>
</div>
<%@ include file="footer.jsp"%>
