<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>

<h2><c:if test="${model.msg!= null } ">${model.msg}</c:if> </h2>
<div class="left-column border-box">
	<div class="navigation">
		<ul>
			<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
			<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
			<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
			<li><a href="/linkalma/schooladmin/addschoolgallery?schoolName=${model.schoolName }">School Gallery</a></li>
		</ul>
	</div>
</div>
<!-- left-column -->
<div class="main-content border-box">
	<form action="/linkalma/schooladmin/updateschoolnews" name="schoolUpdateForm">
	<h1>Add Newsletter</h1>
	<ul class=" clear-fix">
			<li><label>Title</label> 
				<input type="text" value="" name="title" class="required" maxlength="50" />
				<input type="hidden" value="1" name="updateType" class="required" maxlength="50" />
				<input type="hidden" value="${model.schoolName }" name="schoolName" class="required" maxlength="50" />
				<input type="hidden" value="${model.school.schoolID }" name="schoolID" />
			</li>
		 	<li><label>Description</label> 
				<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="4775" ></textarea>
			</li>
			<li><input type="submit" value="Save" />
			</li>
	</ul>
	</form>
	<hr />
	<form action="/linkalma/schooladmin/updateschoolnews" name="schoolUpdateForm">
		<h1>Add Events</h1>
		<ul class="clear-fix">
			<li><label>Title</label> 
				<input type="text" value="" name="title" class="required" maxlength="50" />
				<input type="hidden" value="2" name="updateType" class="required" maxlength="50" />
				<input type="hidden" value="${model.schoolName }" name="schoolName" class="required" maxlength="50" />
				<input type="hidden" value="${model.school.schoolID }" name="schoolID" />
				<input type="hidden" value="${model.page }" name="page" />
			</li>
		 	<li><label>Description</label> 
				<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="4775" ></textarea>
			</li>
			<li><input type="submit" value="Save" /></li>
			
		</ul>
	</form>
	<hr />
	<form action="/linkalma/schooladmin/updateschoolnews" name="schoolUpdateForm">
		<h1>Add Project</h1>
		<ul class="clear-fix">
			<li><label>Title</label> 
				<input type="text" value="" name="title" class="required" maxlength="50" />
				<input type="hidden" value="3" name="updateType" class="required" maxlength="50" />
				<input type="hidden" value="${model.schoolName }" name="schoolName" class="required" maxlength="50" />
				<input type="hidden" value="${model.school.schoolID }" name="schoolID" />
			</li>
		 	<li><label>Description</label> 
				<textarea value="" rows="6" cols="40" name="description" class="required" maxlength="4775" ></textarea>
			</li>
			
			<li><input type="submit" value="Save" /></li>
		</ul>
	</form>
</div>
<%@ include file="../footer.jsp"%>
