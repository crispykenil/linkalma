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
<c:forEach items="${schoolAlbumList}" var="album">
		<h1> ${album.albumName }</h1></br>
       <c:forEach items="${album.photoList}" var="photo">
       <a href="${IMAGE_HOST_PATH}//${album.albumName}//${photo.photoName}" rel="lightbox">
       <img src="${IMAGE_HOST_PATH}//${album.albumName}//${photo.photoName}" class="thumbnail" alt="${photo.photoName}" />
       </a>
       		
		</c:forEach>
</c:forEach>
</div>
	
<%@ include file="footer.jsp" %>
