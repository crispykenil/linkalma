<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="/linkalma/css/jquery.lightbox-0.5.css" media="screen" />
<style type="text/css">
	
		.main-content a{
		border:4px solid #ececec;
		margin:0px 22px 22px 0px;
		display:inline-block;
		}
		.main-content a:hover{
			border:4px solid #86b52b;
	
		}
		
		.thumbnail {
			width:160px; height:140px;
			float:left;
			
		}
	</style>
<script type="text/javascript" src="/linkalma/js/jquery.lightbox-0.5.js"></script>


 <script type="text/javascript">
	$(document).ready(function(){
		$(function() {
  			$('#gallery a').lightBox();
		});
	});

  </script>
<div id="gallery">
	
<h1>Our Gallery </h1>
<a href="/linkalma/images/gallery/1.jpg" rel="lightbox"><img src="/linkalma/images/gallery/1.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/2.jpg" rel="lightbox"><img src="/linkalma/images/gallery/2.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/3.jpg" rel="lightbox"><img src="/linkalma/images/gallery/3.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/4.jpg" rel="lightbox"><img src="/linkalma/images/gallery/4.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/5.jpg" rel="lightbox"><img src="/linkalma/images/gallery/5.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/6.jpg" rel="lightbox"><img src="/linkalma/images/gallery/6.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/7.jpg" rel="lightbox"><img src="/linkalma/images/gallery/7.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/8.jpg" rel="lightbox"><img src="/linkalma/images/gallery/8.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/9.jpg" rel="lightbox"><img src="/linkalma/images/gallery/9.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/10.jpg" rel="lightbox"><img src="/linkalma/images/gallery/10.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/11.jpg" rel="lightbox"><img src="/linkalma/images/gallery/11.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/12.jpg" rel="lightbox"><img src="/linkalma/images/gallery/12.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/13.jpg" rel="lightbox"><img src="/linkalma/images/gallery/13.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/14.jpg" rel="lightbox"><img src="/linkalma/images/gallery/14.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/15.jpg" rel="lightbox"><img src="/linkalma/images/gallery/15.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/16.jpg" rel="lightbox"><img src="/linkalma/images/gallery/16.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/17.jpg" rel="lightbox"><img src="/linkalma/images/gallery/17.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/18.jpg" rel="lightbox"><img src="/linkalma/images/gallery/18.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/19.jpg" rel="lightbox"><img src="/linkalma/images/gallery/19.jpg" class="thumbnail" alt="" /></a>
<a href="/linkalma/images/gallery/20.jpg" rel="lightbox"><img src="/linkalma/images/gallery/20.jpg" class="thumbnail" alt="" /></a>
<c:forEach items="${schoolAlbumList}" var="album">
		<h1> ${album.albumName }</h1></br>
       <c:forEach items="${album.photoList}" var="photo">
       <a href="${IMAGE_HOST}//${SCHOOL}//${album.albumName}//${photo.photoName}" rel="lightbox">
       <img src="${IMAGE_HOST}//${SCHOOL}//${album.albumName}//${photo.photoName}" class="thumbnail" alt="${photo.photoName}" />
       </a>
       		
		</c:forEach>
</c:forEach>
</div>
<form action="/linkalma/schooladmin/createSchoolGallery" name="schoolGalleryForm" method="POST" enctype="multipart/form-data">
	
	albumName<input type="text" name="albumName"/>
	photoName<input type="text" name="photoName"/>
	description<input type="text" name="description"/>
	<input type="file" name="uploadedFileList" accept="image/*" class="button" multiple="multiple" />
	<input type="submit" name=""/>
		
	</form>
	
	
	
<%@ include file="footer.jsp" %>
