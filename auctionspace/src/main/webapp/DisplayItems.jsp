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
				url : 'http://localhost:8080/auctionspace/Items/getItemsList'
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
						url : 'http://localhost:8080/auctionspace/Items/getItemInformation/'
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
		<div id="header">
			<h1>Auction Space</h1>
			<span>An Auction site for students of UNC Charlotte</span>
		</div>
		<h1>Items for Auction</h1>
	<div align = "right">
	<button id = "logout" type="button" >Log Out</button>
	</div>
		<p>Item ${itemName} added successfully !</p>
		<table id="table" data-ng-table="myTable"
			class="table table-hover table-mc-light-blue">
			<thead>
				<tr>
					<th>Item Id</th>
					<th>Name</th>
					<th>Quantity</th>
					<th>Description</th>
					<th>Seller</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
				<tr data-ng-repeat="itemDetails in itemsList">
					<td>{{itemDetails.itemId}}</td>
					<td><a
						ng-href="/auctionspace/Items/getItemInformation/{{itemDetails.itemId}}">{{itemDetails.itemDisplayName}}</td>
					<td>{{itemDetails.quantity}}</td>
					<td>{{itemDetails.description}}</td>
					<td>{{itemDetails.seller}}</td>
					<td>{{itemDetails.startTime}}</td>
					<td>{{itemDetails.endTime}}</td>
					<td>{{itemDetails.location}}</td>
					<td><form:form commandName="auction"
							action="/auctionspace/Auction/registerUserforItemAuction"
							class="well form-horizontal" method="post">
							<input type="hidden" name="itemId" value="{{itemDetails.itemId}}" />
							<input type="hidden" name="fname"
								value="${fname}" />
							<input type="submit" value="Register" name="Register">
						</form:form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<a href="/auctionspace/index.jsp">Home</a>
<script>
var LogOutButton = document.getElementById("logout");
LogOutButton.addEventListener('click',function(event){
location.href='/auctionspace/SignOut';
})
</script>
</body>
</html>