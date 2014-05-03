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

<P>  The time on the server is ${serverTime}. </P>

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
					<h3><a href="/linkalma/schooladmin/addschoolbasics">School Basics</a></h3>
					<h3><a href="/linkalma/schooladmin/addschoolcurriculum">Curriculum</a></h3>


<%@ include file="../footer.jsp"%>
