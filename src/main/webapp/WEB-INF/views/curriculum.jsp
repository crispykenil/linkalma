<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Curriculum
</h1>

<c:forEach var='schoolDataMap' items='${model.schoolDataMap}'>
	<h3>${schoolDataMap.key}</h3>
	<table border="1">
		<thead>
			<tr>
				<th>#</th>
				<th>Title </th>
				<th>Description</th>
				<th>Grade</th>
				<th>Division</th>
				<th>File</th>
				<th>Uploaded Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var='schoolDataDto' items='${schoolDataMap.value}' varStatus="count">
				<tr>
					<td>${count.index }</td>
					<td>&nbsp;${schoolDataDto.title }</td>
					<td>&nbsp;${schoolDataDto.description }</td>
					<td>&nbsp;${schoolDataDto.grade }</td>
					<td>&nbsp;${schoolDataDto.description }</td>
					<td>&nbsp;${schoolDataDto.documentName }</td>
					<td>&nbsp;${schoolDataDto.createDttm }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:forEach>

</body>
</html>
