<!DOCTYPE html>
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
        <div id="banner">
            <tiles:insertAttribute name="header" />
        </div>
        <div></div>
        <div id="page">
            <tiles:insertAttribute name="content" />
        </div>
        <div></div>
        <div id="footer_wrapper">
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>
