<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="company is a free job board template">
        <meta name="author" content="Ohidul">
        <meta name="keyword" content="html, css, bootstrap, job-board">
        <meta name="viewport" content="width=device-width, initial-scale=1">

		<spring:url value="/resources/static/css" var="cssPath"/>
		<spring:url value="/" var="rootPath"/>
		<spring:url value="/resources/static/images" var="imgPath"/> 		
		<spring:url value="/resources/static/font" var="fontPath"/>
		<spring:url value="/resources/static/js" var="jsPath"/>		
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="${rootPath}/favicon.ico" type="image/x-icon">
        <link rel="icon" href="${rootPath}/favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="${cssPath}/normalize.css">
        <link rel="stylesheet" href="${cssPath}/font-awesome.min.css">
        <link rel="stylesheet" href="${cssPath}/fontello.css">
        <link rel="stylesheet" href="${cssPath}/animate.css">        
        <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
        <link rel="stylesheet" href="${cssPath}/owl.carousel.css">
        <link rel="stylesheet" href="${cssPath}/owl.theme.css">
        <link rel="stylesheet" href="${cssPath}/owl.transitions.css">
        <link rel="stylesheet" href="${rootPath}/style.css">
        <link rel="stylesheet" href="${rootPath}/responsive.css">
		<title>Item Information</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<spring:url value="/resources/static/css/displayItems.css"
	var="displayItemsCss" />
<link href="${displayItemsCss}" rel="stylesheet">
<spring:url value="/resources/static/styles/normalize.css"
	var="NormalizeCss" />
<link href="${NormalizeCss}" rel="stylesheet">
<spring:url value="/resources/static/styles/styles.css" var="StylesCss" />
<spring:url value="/resources/static/images/" var="ImagePath" />
<link href="${StylesCss}" rel="stylesheet">
<script src="/js/jquery.js"></script>
<script src="/js/modernizr.js"></script>
</head>
<body>
 <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <!-- Body content -->
		
        <div class="header-connect">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-8 col-xs-8">
                        <div class="header-half header-call">
                            <p>
                                <span><i class="icon-cloud"></i>+019 4854 8817</span>
                                <span><i class="icon-mail"></i>email.auctionspace@gmail.com</span>
                            </p>
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-3  col-xs-offset-1">
                        <div class="header-half header-social">
                            <ul class="list-inline">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-vine"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <nav class="navbar navbar-default">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
			   <!--<a class="navbar-brand" href="#"><img src="${imgPath}/logo.png" alt=""></a>-->
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<div class="button navbar-right">
						<button class="navbar-btn nav-button wow fadeInRight"
							data-wow-delay="0.6s">
							<a href="/auctionspace/SignOut">Logout</a>
						</button>
					</div>
              <ul class="main-nav nav navbar-nav navbar-right">
                <li class="wow fadeInDown" data-wow-delay="0s"><a class="active" href="#">Home</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.1s"><a href="#">Ongoing Auctions</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.2s"><a href="/auctionspace/Items/displayItems/${fname}">Buy</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="/auctionspace/Items/addItem/${fname}">Sell</a></li>
				<li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#"></a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>

	<div class="product clear">
		<header>
			<hgroup>
				<h1>${item.itemDisplayName}</h1>
				<h4>${item.seller}</h4>
			</hgroup>
		</header>
		<figure>
			<img src="${ImagePath}${item.imagePath}">
		</figure>
		<section>
			<p>${item.itemDisplayName}</p>
			<details>
				<summary>Product Features</summary>
				<ul>
					<li>Seller: ${item.seller}</li>
					<li>Description: ${item.description}</li>
					<li>Price: ${item.price}</li>
					<li>Quantity: ${item.quantity}</li>
					<li>Start Time: ${item.startTime}</li>
					<li>End Time: ${item.endTime}</li>
					<li>Location: ${item.location}</li>
					<li>Status: ${item.status}</li>
					<li>No of Bids: ${noOfBids}</li>
					<li>Current Bid: ${prevBid}</li>
				</ul>
			</details>
			<form:form commandName="auction"
				action="/auctionspace/Auction/registerUserforItemAuction"
				class="well form-horizontal" method="post">
				<input type="hidden" name="itemId" value="${item.itemId}" />
				<input type="hidden" name="fname" value="${fname}" />
				<input class="tbl-apply" type="submit" value="Register" name="Register">
			</form:form>
	
			<button id="Stop">Stop</button>
			<br><br>
			<p id="header"><b>${message}</b></p>
		</section>
	</div>
	<br><br><br><br><br>
	<div class="footer-area">
            <div class="container">
                <div class="row footer">
                    <div class="col-md-4">
                        <div class="single-footer">
                            <img src="${imgPath}/logo.png" alt="" class="wow pulse" data-wow-delay="1s">
                            <p>Online Auction System</p>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="single-footer">
                            <h4>Useful links</h4>
                            <div class="footer-links">
                                <ul class="list-unstyled">
                                    <li><a href="">About Us</a></li>
                                    <li><a href="" class="active">Services</a></li>
                                    <li><a href="">Work</a></li>
                                    <li><a href="">Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row footer-copy">
                    <p><span>(C) website, All rights reserved</span> | <span>Contributors </span> <span><a href="https://dribbble.com/siblu">Jessica Lu</a>  </span>  <span><a href="https://dribbble.com/siblu">Nitin Salvankar</a>  </span> <span> <a href="https://dribbble.com/siblu">Shipra Shinde</a></span></p>
                </div>
            </div>
        </div>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="${jsPath}/vendor/jquery-1.10.2.min.js"><\/script>')</script>
        <script src="${jsPath}/bootstrap.min.js"></script>
        <script src="${jsPath}/owl.carousel.min.js"></script>
        <script src="${jsPath}/wow.js"></script>
        <script src="${jsPath}/main.js"></script>
	<script>
		var DisplayButton = document.getElementById("Stop");
		DisplayButton.addEventListener('click', function(event) {
			location.href = '/auctionspace/Auction/stopAuction/${item.itemId}';
		})

	</script>

</body>
</html>