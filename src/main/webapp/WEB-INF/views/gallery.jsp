<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %>

<!--  currently used only in gallery page of school -->
<link href="/linkalma/css/vendor/magnific-popup.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="/linkalma/js/vendor/jquery.magnific-popup.js"></script>
<script type="text/javascript">

$(document).ready(function() {
 	$('.gallery').each(function() { // the containers for all your galleries
		$(this).magnificPopup({
			delegate: 'a', // the selector for gallery item
			type: 'image',
			gallery: {
			  enabled:true
			}
		});
	}); 
});

</script>
<style type="text/css">
		.gallery h2 {
			margin-bottom:0px;
			color:#86b52b;
		}
		.gallery a{
		border:10px solid #ececec;
		margin:0px 22px 22px 0px;
		display:inline-block;
		}
		.gallery a:hover{
			border:10px solid #86b52b;
	
		}
		
		.thumbnail {
			width:160px; height:140px;
			float:left;
			
		}
	</style>
	
<h1>Our Gallery </h1>
<c:forEach items="${schoolAlbumList}" var="album">
<div class="gallery">
		<h2> ${album.albumName }</h2></br>
       <c:forEach items="${album.photoList}" var="photo">
	       <a href="${IMAGE_HOST_PATH}//${album.albumName}//${photo.photoName}" rel="lightbox" >
	       		<img src="${IMAGE_HOST_PATH}//${album.albumName}//${photo.photoName}" class="thumbnail" alt="Image Not Available"  />
	       </a>

		</c:forEach>
	</div>
</c:forEach>

	
<%@ include file="footer.jsp" %>
