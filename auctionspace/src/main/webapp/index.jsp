<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/Home.css" var="HomeCss"/> 
<link href= "${HomeCss}" rel="stylesheet" >
</head>
<body>
<div id="header">
<h1>Auction Space</h1>
<span>An Auction site for students of UNC Charlotte.</span>
</div>
<a href = "Users/login" id="loginlink">LOG IN</a><a href = "/auctionspace/Users/registerUser" id="registerlink">REGISTER/</a>
<br>
<br>
<div id="m">
<ul>
	<li >HOME</li>
	<li>ONGOING AUCTIONS</li>
	<li>FUTURE AUCTIONS</li>
	<li>BUY</li>
	<li>SELL</li>
	<li>INFORMATION</li>
	<li>HELP</li>
</ul>
</div>
	<div id="image">
		<spring:url value="/resources/home-union-900.jpg" var="HomeImage"/>
		<img src="${HomeImage}" height = 800 width = 1155>
	</div>
</body>
</html>