<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/Home.css" var="HomeCss"/> 
<link href= "${HomeCss}" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title >Welcome</title>
</head>
<body id = "Welcome">
	<h1 id = "header">Welcome ${user.fname}</h1>
	<div align = "right">
	<button id = "logout" type="button" >Log Out</button>
	</div>
	<p></p>
	<button id = "auctionItem" type="button" >Auction an Item</button>
	<button id = "displayItems" type="button" >List all Items</button>
<script>	
var AuctionButton = document.getElementById("auctionItem");
AuctionButton.addEventListener('click',function(event){
	location.href='/auctionspace/Items/addItem/${user.username}';
})
var DisplayButton = document.getElementById("displayItems");
DisplayButton.addEventListener('click',function(event){
	location.href='/auctionspace/Items/displayItems/${user.username}';
})

var LogOutButton = document.getElementById("logout");
LogOutButton.addEventListener('click',function(event){
location.href='/auctionspace/SignOut';
})

</script>	
</body>
</html>
