<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items for Auction</title>
<script src="http://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<spring:url value="/resources/static/css/displayItems.css"
	var="displayItemsCss" />
<link href="${displayItemsCss}" rel="stylesheet">
<spring:url value="/resources/Home.css" var="HomeCss"/> 
<link href= "${HomeCss}" rel="stylesheet" >
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	function MyController($scope, $http) {
		$scope.getItemsList = function(itemsJson) {
			$scope.itemsList = angular.fromJson(itemsJson);
			console.log($scope.itemsList);
		};
	};
</script>
</head>

<body data-ng-app="myApp">
<div id="header">
<h1>Auction Space</h1>
<span>An Auction site for students of UNC Charlotte.</span>
</div>
	<h1>Items for Auction</h1>
	<p>Item ${itemName} added successfully !</p>
	<div class="table-responsive-vertical shadow-z-1"
		data-ng-controller="MyController">
		<div data-ng-init="getItemsList('${items}')">
			<table id="table" class="table table-hover table-mc-light-blue">
				<thead>
					<tr>
						<th>Name</th>
						<th>Quantity</th>
						<th>Description</th>
						<th>Start Time</th>
						<th>End Time</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach var="i" items="${items}">
					<tr>
						<td>${i}</td>
						<td>${i.quantity}</td>
						<td>${i.description}</td>
						<td>${i.startTime}</td>
						<td>${itemDetails.endTime}</td>
						<td>${itemDetails.location}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<a href="/auctionspace/index.jsp">Home</a>
</body>
</html>