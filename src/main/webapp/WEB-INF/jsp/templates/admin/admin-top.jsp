<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">

    <head>

        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="SemiColonWeb" />

        <!-- Stylesheets
        ============================================= -->
        <link
            href="https://fonts.googleapis.com/css?family=Crete+Round|Nunito+Sans:300,400,400i,700|Ramabhadra&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="/css/canvas.css" type="text/css" />
        <link rel="stylesheet" href="/css/dark.css" type="text/css" />
        <link rel="stylesheet" href="/css/font-icons.css" type="text/css" />
        <link rel="stylesheet" href="/css/animate.css" type="text/css" />
        <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css" />

        <link rel="stylesheet" href="/css/canvas-responsive.css" type="text/css" />
        <link rel="stylesheet" href="/css/custom.css">
        <link rel="stylesheet" href="/css/colors.css" type="text/css" />
        <link rel="stylesheet" href="/css/fonts.css" type="text/css" />
	
	<!-- Bootstrap Select CSS -->
	<link rel="stylesheet" href="/css/bs-select.css" type="text/css" />
	<link rel="stylesheet" href="/css/bs-filestyle.css" type="text/css" />
	<link rel="stylesheet" href="/css/select-boxes.css" type="text/css" />
		<link rel="stylesheet" href="/css/skin.css" type="text/css" />
	<link rel="stylesheet" href="/css/bs-switches.css" type="text/css" />
	<link rel="stylesheet" href="/css/bs-datatable.css" type="text/css" />
    <!-- Range Slider CSS -->
	<link rel="stylesheet" href="/css/ion.rangeslider.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Document Title
	============================================= -->
	<title>${title}</title>

	<style>
		.file-caption.icon-visible .file-caption-name {
			font-family: 'Lato', sans-serif;
			color: #666;
		}
	.form-process {
		position: absolute;
		-webkit-transition: all .3s ease;
		-o-transition: all .3s ease;
		transition: all .3s ease;
		background-image: none;
	}

	.form-process > div { background-color: #999;  }

	.form-process,
	#template-contactform-submitted,
	.template-contactform-complete .form-process {
		display: none;
		opacity: 0;
		background-color: rgba(255,255,255,0.7);
	}

	.template-contactform-processing .form-process {
		display: block;
		opacity: 1;
	}

	</style>

</head>

<body class="stretched">
