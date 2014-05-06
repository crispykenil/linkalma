<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp"%>



<div id="hd" class="school-header" >
	<div class="header-content-wrapper">
		<div class="school-logo">
			<a href="../linkalma">RYAN INTERNATIONAL</a>
		</div>
		
	</div><!-- header-content-wrapper -->
</div><!-- hd -->
<h1>
	About School - Admin
</h1>

	<div class="left-column border-box">
		<div class="navigation">
			<ul>
				<li><a href="/linkalma/schooladmin/addschoolbasics?schoolName=${model.schoolName }">School Basics</a></li>
				<li><a href="/linkalma/schooladmin/addadminprofile?schoolName=${model.schoolName }">Admin Profile</a></li>
				<li><a href="/linkalma/schooladmin/addschoolcurriculum?schoolName=${model.schoolName }">Curriculum</a></li>
				<li><a href="/linkalma/schooladmin/addschoolevents?schoolName=${model.schoolName }">School Events</a></li>
				<li><a href="/linkalma/schooladmin/addaboutschool?schoolName=${model.schoolName }">About School</a></li>
			</ul>
		</div>
	</div>

<form action="search" name="searchForm">
<div>
						<ul class="threeColumn clear-fix">
							<li><label>School Logo</label> 
								<input type="file" name="file" accept="image/*" class="button" onchange="javascript:fileUpload();">
							</li><br>
							<li><label>School Name</label> <input type="text" value=""
								 name="schoolName" class="required" maxlength="50" /></li>
						</ul>
					</div><input type="submit" value="Update" />
</form>

<%@ include file="../footer.jsp"%>
