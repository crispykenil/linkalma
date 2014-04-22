<%@ include file="header.jsp" %>
		
				<div id="addMySchool" class="addMydSchoolContainer">
				<span>${model.succesMsg}</span>
						<h2>Add school to your profile</h2>
						<form:form action="addmyschool" name="addMySchool" method="post">
							<select name="schoolID">
								<c:forEach var="schoolList" items="${model.schoolList}">
									<option value="${schoolList.schoolID}" > ${schoolList.schoolName } - ${schoolList.branch }
								</c:forEach>
							</select> 
							<input type="text" value="" placeholder="From Year" name="fromYear" />
							<input type="text" value="" placeholder="Last Name" name="toYear" />
							<input type="text" value="" placeholder="Batch" name="passOutBatch" />
							<input type="text" value="" placeholder="Branch" name="branch" />
							<input type="submit" class="button large" value="Add School" />
							<input type="button" class="button large" value="Cancel"  />
						</form:form>
					
					<table class="dataTable">
					<thead>
						<tr>
							<th> School Name </th>
							<th> From Year </th>
							<th> To Year </th>
							<th> Batch</th>
							<th> Branch</th>
							<th> - </th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="userSchoolList" items="${model.userSchoolList}">
						<tr>
							<td>${userSchoolList.schoolName}</td>
							<td>${userSchoolList.toYear}</td>
							<td>${userSchoolList.fromYear}</td>
							<td>${userSchoolList.passOutBatch}</td>
							<td>${userSchoolList.branch}</td>
							<td> <a href="deleteMySchool?ID=${userSchoolList.userSchoolID}">Delete</a></td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
				</div>
<%@ include file="footer.jsp" %>