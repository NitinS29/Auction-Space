<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="description" content="company is a free job board template">
<meta name="author" content="Ohidul">
<meta name="keyword" content="html, css, bootstrap, job-board">
<meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/resources/static/css" var="cssPath" />
<spring:url value="/" var="rootPath" />
<spring:url value="/resources/static/images" var="imgPath" />
<spring:url value="/resources/static/font" var="fontPath" />
<spring:url value="/resources/static/js" var="jsPath" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="${rootPath}/favicon.ico"
	type="image/x-icon">
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
<script src="${jsPath}/vendor/modernizr-2.6.2.min.js"></script>
<title>All Auctions</title>
<script src="http://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>

<spring:url value="/resources/static/styles/styles.css" var="StylesCss" />
<link href="${StylesCss}" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<spring:url value="/resources/static/css/displayItems.css"
	var="displayItemsCss" />
<link href="${displayItemsCss}" rel="stylesheet">
<spring:url value="/resources/static/styles/normalize.css"
	var="NormalizeCss" />
<link href="${NormalizeCss}" rel="stylesheet">
<spring:url value="/resources/static/styles/styles.css" var="StylesCss" />
<link href="${StylesCss}" rel="stylesheet">
<script src="/js/jquery.js"></script>
<script src="/js/modernizr.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script>
	var app = angular.module('displayItemsApp', []);

	function displayItemsAppCtrl($scope, $http) {
		$scope.onloadFun = function() {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/auctionspace/Auction/getAllAuctions/${fname}'
			}).success(function(data, status, headers, config) {
				$scope.itemsList = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		}

		$scope.go = function(itemDetails) {
			$http(
					{
						method : 'GET',
						url : 'http://localhost:8080/auctionspace/Items/getItemInfo/'
								+ itemDetails.itemId
					}).success(function(data, status, headers, config) {
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		}
	};
</script>
</head>
<body data-ng-app="displayItemsApp"
	data-ng-controller="displayItemsAppCtrl">
	<div class="table-responsive-vertical shadow-z-1"
		data-ng-init="onloadFun()">

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
								<span><i class="icon-cloud"></i>+019 4854 8817</span> <span><i
									class="icon-mail"></i>email.auctionspace@gmail.com</span>
							</p>
						</div>
					</div>
					<div
						class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-3  col-xs-offset-1">
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
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><Auction Space></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<div class="button navbar-right">
						<button class="navbar-btn nav-button wow fadeInRight"
							data-wow-delay="0.6s">
							<a href="/auctionspace/Users/SignOut">Logout</a>
						</button>
					</div>
					<ul class="main-nav nav navbar-nav navbar-right">
						<li class="wow fadeInDown" data-wow-delay="0s"><a
							class="active" href="/auctionspace/index.jsp">Home</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#"></a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<br>
		<p id="header"><b>${message}</b></p>
		<br>
		<div class="content-area">
			<div class="container">
				<div class="row page-title text-center wow bounce"
					data-wow-delay="1s">
					<h3>Items for Auction</h3>
				</div>
				<div class="row jobs" data-ng-init="onloadFun()">
					<div class="col-md-9">
						<div class="job-posts table-responsive">
							<table class="table" data-ng-table="myTable">
								<tr class="odd wow fadeInUp" data-wow-delay="1s">
									<th><p></p></th>
									<th><p>Name</p></th>
									<th><p>Quantity</p></th>
									<th><p>Seller</p></th>
									<th><p>Start Time</p></th>
									<th><p>End Time</p></th>
									<th><p>Location</p></th>
									<th><p>Price</p></th>
									<th><p>No Of Bids</p></th>
									<th><p>Current Bid</p></th>
									<th><p>Status</p></th>
									<th><p></p></th>
								</tr>
								<tr class="odd wow fadeInUp" data-wow-delay="1s"
									data-ng-repeat="itemDetails in itemsList">
									<td class="tbl-logo"><img src="${imgPath}/job-logo1.png"
										alt=""></td>
									<td class="tbl-title"><h4>
											<a
												ng-href="/auctionspace/Auction/ItemInfoAdmin?itemId={{itemDetails.itemId}}&fname=${fname}" /><br>
											<span class="job-type">{{itemDetails.itemDisplayName}}</span>
										</h4></td>
									<td><p>{{itemDetails.quantity}}</p></td>
									<td><p>{{itemDetails.seller}}</p></td>
									<td><p>{{itemDetails.startTime}}</p></td>
									<td><p>{{itemDetails.endTime}}</p></td>
									<td><p>
											<i class="icon-location"></i>{{itemDetails.location}}
										</p></td>
									<td><p>&dollar; {{itemDetails.price}}</p></td>
									<td><p>{{itemDetails.noOfBids}}</p></td>
									<td><p>{{itemDetails.currentBid}}</p></td>
									<td><p>{{itemDetails.status}}</p></td>
									<td class="tbl-apply"><form:form modelAttribute="auction"
											action="/auctionspace/Auction/stopAuction/{{itemDetails.itemId}}"
											class="well form-horizontal" method="post">
											<input type="hidden" name="itemId"
												value="{{itemDetails.itemId}}" />
											<input type="hidden" name="fname" value="${fname}" />
											<input type="submit" value="Stop" name="Stop" ng-disabled = "${itemDetails.status} == Stopped">
										</form:form></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<hr>
		</div>
		<div class="footer-area">
			<div class="container">
				<div class="row footer">
					<div class="col-md-4">
						<div class="single-footer">
							<img src="${imgPath}/logo.png" alt="" class="wow pulse"
								data-wow-delay="1s">
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
					<p>
						<span>(C) website, All rights reserved</span> | <span>Contributors
						</span> <span><a href="https://dribbble.com/siblu">Jessica Lu</a>
						</span> <span><a href="https://dribbble.com/siblu">Nitin
								Salvankar</a> </span> <span> <a href="https://dribbble.com/siblu">Shipra
								Shinde</a></span>
					</p>
				</div>
			</div>
		</div>

		<a href="/auctionspace/index.jsp">Home</a>


		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="${jsPath}/vendor/jquery-1.10.2.min.js"><\/script>')</script>
		<script src="${jsPath}/bootstrap.min.js"></script>
		<script src="${jsPath}/owl.carousel.min.js"></script>
		<script src="${jsPath}/wow.js"></script>
		<script src="${jsPath}/main.js"></script>
		
		<script>
		var DisplayButton = document.getElementById("bid");
		
		function disableFunction(){
			if(itemDetails.status = "Stopped"){
			document.getElementById("Stop").disabled = true;
			}
			else{
				document.getElementById("Stop").disabled = false;
			}
		}
		window.onload=function() {
			if(itemDetails.status = "Stopped"){
			  document.getElementById("Stop").disabled=true;
			}
			else{
				document.getElementById("Stop").removeatrribute("");
			}
			}
		</script>
</body>
</html>