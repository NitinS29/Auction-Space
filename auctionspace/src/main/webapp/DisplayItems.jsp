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
	<script type="text/javascript">
 var itemDetail= ${items};
</script>
<script>
 var app = angular.module('displayItemsApp', []);

    function displayItemsAppCtrl($scope, $http) {
      $scope.onloadFun = function() {
		$http({
				method : 'GET',
				url : 'http://localhost:8080/auctionspace/Items/getItemsList'
			}).success(function(data, status, headers, config) {
				$scope.itemsList = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
      }
    };
</script>
</head>
<body ng-app="displayItemsApp" ng-controller="displayItemsAppCtrl">
	<div class="table-responsive-vertical shadow-z-1" data-ng-init="onloadFun()">
		<div id="header">
			<h1>Auction Space</h1>
			<span>An Auction site for students of UNC Charlotte</span>
		</div>
		<h2>Items for Auction</h2>
		<p>Item ${itemName} added successfully !</p>
		
		<table id="table" data-ng-table="myTable"  class="table table-hover table-mc-light-blue">
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
				<tr data-ng-repeat="itemDetails in itemsList">
					<td>{{itemDetails.itemDisplayName}}</td>
					<td>{{itemDetails.quantity}}</td>
					<td>{{itemDetails.description}}</td>
					<td>{{itemDetails.startTime}}</td>
					<td>{{itemDetails.endTime}}</td>
					<td>{{itemDetails.location}}</td>
					<td><button type="button">Register</button> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<a href="/auctionspace/index.jsp">Home</a>
</body>
</html>