<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>

	<div class="school-staffs clear-fix">
	<h2>Our Staff</h2>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>
		<div>
			<h3>Sam Kronshtain</h3>
			<div class="pic-container"><img src="/linkalma/images/staff/img-3.jpg" width="100%" height="185" /></div>
			<p class="description"> Vivamus vel eros eget magna volutpat sagittis. Nulla faucibus nibh a magna tincidunt accumsan hendrerit nunc facilisis. Curabitur et libero sit amet ante hendrerit molestie.  <a href="javascript:;">read more</a></p>
		</div>					
	</div>
	
	<form action="/linkalma/schooladmin/createStaff" name="staffForm" method="POST" enctype="multipart/form-data">
	
	facultyName<input type="text" name="facultyName"/>
	facultyEmail<input type="text" name="facultyEmail"/>
	subjectArea<input type="text" name="subjectArea"/>
	<input type="file" name="uploadedFile" accept="image/*" class="button" />
	<input type="submit" name=""/>
		
	</form>
		
<%@ include file="footer.jsp"%>
