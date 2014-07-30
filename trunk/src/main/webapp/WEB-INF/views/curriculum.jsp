<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<h1>Our Curriculums</h1>
<c:forEach var='schoolDataMap' items='${model.schoolDataMap}'>
	<h3>${schoolDataMap.key}</h3>
	<table cellpadding="0" border"0" cellspacing="0" class="dataTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Title </th>
				<th>Description</th>
				<th>Grade</th>
				<th>Division</th>
				<th>File</th>
				<th>Uploaded Date</th>
				<th>Download</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var='schoolDataDto' items='${schoolDataMap.value}' varStatus="count">
				<tr>
					<td>${count.index+1}</td>
					<td>${schoolDataDto.title}</td>
					<td>${schoolDataDto.description}</td>
					<td>${schoolDataDto.grade }</td>
					<td>${schoolDataDto.description}</td>
					<td>${schoolDataDto.documentName}</td>
					<td>${schoolDataDto.createDttm}</td>
					<td align="center"><a href="" class="fa fa-download">${schoolDataDto.serverDocumentUrl}</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:forEach>
<%@ include file="footer.jsp" %>
