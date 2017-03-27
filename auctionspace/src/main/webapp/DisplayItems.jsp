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
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	function MyController($scope, $http) {
		$scope.items = ${items};
		$scope.itemName = ${itemName};
	};
</script>
</head>

<body data-ng-app="myApp">
	<h1>Items for Auction</h1>
	<p>Item ${items} ${itemName} added successfully !</p>
	<div class="table-responsive-vertical shadow-z-1"
		data-ng-controller="MyController">
		<table id="table" class="table table-hover table-mc-light-blue"
			data-ng-table="myTable">
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
				<tr data-ng-repeat="itemDetails in ${items}">
					<td>{{itemDetails.itemDisplayName}}</td>
					<td>{{itemDetails.quantity}}</td>
					<td>{{itemDetails.description}}</td>
					<td>{{itemDetails.startTime}}</td>
					<td>{{itemDetails.endTime}}</td>
					<td>{{itemDetails.location}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>