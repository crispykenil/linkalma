<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: LINK-ALMA ::</title>

<link href="css/reset.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/application.css" rel="stylesheet" type="text/css" media="screen" />
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery.bpopup.min.js"></script>
	<script type="text/javascript" src="js/application.js"></script>
	<script type="text/javascript" src="js/jquery.tinycarousel.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#slider1').tinycarousel({ controls: false, pager: false, animation: true });
		});
	</script>
</head>
<body>


<div id="top-bar">
	<div class="top-navigation fl">
		<ul><li><a href="contact.html">Contact Us</a></li><li><a href="gallery.html">Photo Gallery</a></li><li><a href="whyus.html"> Why Us </a></li><li><a href="services.html">Services </a></li><li><a href="aboutus.html">About Us</a></li><li><a href="index.html">Home</a></li></ul>
	</div>
	<div class="status-info-bar fr">
		<ul>
			<li><a href="#">My Profile</a> | <a href="#">Logout</a></li>
		</ul>
	</div>
</div>
<div id="doc">
	<div id="hd">
		<div class="header-content-wrapper">
			<div class="logo">
				<a href="#"></a>
			</div>
			<div class="fr">
				<div class="search-bar">
					<input type="text" value="" placeholder="Search Your Freinds" class="search-field"/>
				</div>
			</div>
		</div><!-- header-content-wrapper -->
	</div><!-- hd -->
	<div id="bd">
		
		<div id="main-content-wrapper">
				<div id="user-info-panel" class="clear-fix">
					<div class="profile-pic fl">
						<img src="images/profile-pic.png" width="162px" height="158px" />
					</div>
					<div class="user-info fl">
						<h2>Gautam Sharma</h2>
						<ul>
							<li> <label>Email:</label> gautam.sharma@rediffmail.com</li>
							<li> <label>Contact No:</label> gautam.sharma@rediffmail.com</li>
							
						</ul>
						<div class="posting-panel">
							<form>
								<textarea placeholder="Share your views"></textarea>
								<div class="posting-options border-box clear-fix">
									<div class="fl">
										Post At:
									</div>
									<div class="fr">
										<input type="submit" value="Post" class="smalbtn"/>
									</div>
									
								</div>
							</form>
						</div>
					</div>
					
				</div>
				<div class="left-content border-box">
					<div class="panel">
						<div class="panel-header">
							<h3>My School's Update</h3>
						</div>
						<div class="panel-content">
							<h3>Ryan International</h3>
							<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
						</div>
					</div>
					<div class="panel">
						<div class="panel-header">
							<h3>My School's Update</h3>
						</div>
						<div class="panel-content">
							<h3>Ryan International</h3>
							<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
						</div>
					</div>
				</div><!-- left-side-wrapper -->
				<div class="main-content fl border-box">
						<div class="panel">
							<div class="panel-header">
								<h3>My Updates</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My Group's Updates</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My School's News & Event</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My School's Update</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
				</div>
				

			</div>
		</div><!-- main-wrapper -->
	</div><!-- bd -->
</div><!-- doc-->
<div id="ft">
	<script type="text/javascript" src="js/footer.js"></script>
</div><!-- ft -->

</body>
</html>
