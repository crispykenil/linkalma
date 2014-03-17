<!DOCTYPE html>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: LINK-ALMA ::</title>

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
	<div id="show-case-area">
		<div id="signin-signup-panel" class="fl border-box">
				<div class="sign-in-wrapper">
					<h2>Login</h2>
					<form>
						<input type="text" value="" placeholder="Username" />
						<input type="password" value="" placeholder="Password" />
						<label>Alumni Login
							<input type="radio" value="" />
						</label>
							<label>Studant Login
							<input type="radio" value="" />
						</label>
					</form>
				</div>
				<div><a href="javascript:;">Forgot your password?</a></div>
				<div class="sign-up-wrapper">
					<ul>
						<li>No Account Yet? </li>
						<li><input type="button" value="Create an Account" id="sign-up-button" class="button large"/></li>
						<!--
						<li>OR</li>
						<li>Login through ...</li> -->
					</ul>
					<div id="sign-up" class="sign-up-container">
						<h2>New User? Sign Up</h2>
						<form action="createProfile" name="userProfile" method="post">

							<input type="text" value="" placeholder="First Name" name="fName" />
							<input type="text" value="" placeholder="Last Name" name="lName" />
							<input type="email" value="" placeholder="Email" name="emailAddress" />
							<input type="password" value="" placeholder="Password" name="password" />
							<input type="password" value="" placeholder="Confirm Password" />
							<input type="date" value="" placeholder="DOB" name="dob" />
							<input type="text" value="" placeholder="Gender" name="gender" />

							<input type="submit" class="button large" value="Sign Up" />
						</form>
					</div>
				</div>
			
		</div><!-- signin-signup-panel -->
		<div id="slider-panel" class="fl">
			<img src="images/show-case.png" />
		</div>
	</div><!-- show-case-area -->
	<div id="bd">
		<div id="main-content-wrapper">
			<div class="main-content">
				<div class="left-wrapper border-box">
					<div class="news-and-event">
						<h2>Linkalma News & Events</h2>
						<ul>
								<li>
									<h3>Consultancy</h3>
									<p>Limited to Design & downloading to the Client Contractors </p>
								</li>
								<li>
									<h3>Retail Outlet Interior</h3>
									<p>Shops, Company Flagship stores, Kiosks, coffee shops etc </p>
								</li>
						</ul>
					
					</div>
				
					
				</div><!-- left-side-wrapper -->
				<div class="middle-wrapper border-box">
					<h2>Welcome to Linkalma</h2>
					<ul>
					<li>
						<h3>Consultancy</h3>
						<p>Limited to Design & downloading to the Client Contractors </p>
					</li>
					<li>
						<h3>Retail Outlet Interior</h3>
						<p>Shops, Company Flagship stores, Kiosks, coffee shops etc </p>
					</li>
					</ul>
					
				</div>
				
				<div class="clear-both" ></div>
			</div>
		</div><!-- main-wrapper -->
	</div><!-- bd -->
</div><!-- doc-->
<div id="ft">
	<script type="text/javascript" src="js/footer.js"></script>
</div><!-- ft -->

</body>
</html>
