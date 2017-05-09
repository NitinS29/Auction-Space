<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Put up an item for auction</title>
<script src="http://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="/resources/static/css/addItems.css">
 <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AuctionSpace</title>
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
</head>

<body id="AddItem">
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
							<a href="/auctionspace/Users/SignOut">Logout</a>
						</button>
					</div>
              <ul class="main-nav nav navbar-nav navbar-right">
                <li class="wow fadeInDown" data-wow-delay="0s"><a class="active" href="#">Home</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.2s"><a href="/auctionspace/Items/displayItems/${seller}">Buy</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="/auctionspace/Items/addItem/${seller}">Sell</a></li>
				<li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#"></a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
	<div class="container">
		<form:form commandName="item"
			action="/auctionspace/Items/processAddItem"
			class="well form-horizontal" method="post" enctype="multipart/form-data">
			<fieldset>

				<!-- Form Name -->
				<legend>Add Item for Auction</legend>
				<form:input path="seller" type="hidden" name="seller"
					value='${seller}' />

				<div class="form-group">
					<form:label path="itemDisplayName" class="col-md-4 control-label">Item Name</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="itemDisplayName" name="itemDisplayName"
								id="itemDisplayName" placeholder="Item Name"
								class="form-control" type="text" size="100" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" class="col-md-4 control-label">Item Description</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:textarea cols="100" rows="6" class="form-control"
								path="description" name="description" id="description"
								placeholder="Item Description"></form:textarea>
						</div>
					</div>
				</div>

				<div class="form-group">
					<form:label path="image" class="col-md-4 control-label">Image</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input type="file" name="fileUpload" style="width: 135; height: 20;"  class="form-control"
								path="image" id="image" placeholder="Item Image" />
						</div>
					</div>
				</div>
				<!-- Text input-->

				<div class="form-group">
					<form:label path="price" class="col-md-4 control-label">Price</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="price" name="price" id="price"
								placeholder="Price in $" size="100" class="form-control" />
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<form:label path="quantity" class="col-md-4 control-label">Quantity</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="quantity" name="quantity" id="quantity"
								placeholder="Number of Items" size="100" class="form-control" />
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<form:label path="startTime" class="col-md-4 control-label">Start Time</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="startTime" name="startTime" id="startTime"
								placeholder="mm/dd/yyyy" class="form-control" size="100"
								type="date" />
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<form:label path="endTime" class="col-md-4 control-label">End Time</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="endTime" name="endTime" id="endTime"
								placeholder="mm/dd/yyyy" size="100" class="form-control"
								type="date" />
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Location</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="location" name="location" id="location"
								placeholder="Location" class="form-control" size="100"
								type="text" />
						</div>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<form:button type="submit" class="btn btn-warning">Add Item</form:button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
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
	<!-- /.container -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
		$(function() {
			// Find any date inputs and override their functionality
			$('input[type="date"]').datepicker();
		});
	</script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
</body>
</html>
