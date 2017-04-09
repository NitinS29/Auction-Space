<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items for Auction</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<spring:url value="/resources/static/css/displayItems.css"
	var="displayItemsCss" />
<link href="${displayItemsCss}" rel="stylesheet">
<spring:url value="/resources/static/styles/normalize.css"
	var="NormalizeCss" />
<link href="${NormalizeCss}" rel="stylesheet">
<spring:url value="/resources/static/styles/styles.css" var="StylesCss" />
<spring:url value="/resources/static/images/honda_cbr.png"
	var="ImageCss" />
<link href="${StylesCss}" rel="stylesheet">
<script src="/js/jquery.js"></script>
<script src="/js/modernizr.js"></script>
</head>
<body>
			<div id="header">
			<h1>Auction Space</h1>
			<span>An Auction site for students of UNC Charlotte</span>
		</div>

			<div align = "right">
				<button id = "logout" type="button" >Log Out</button>
			</div>

<div class="product clear">
			<header>
				<hgroup>
					<h1>${item.itemDisplayName}</h1>
					<h4>${item.seller}</h4>
				</hgroup>
			</header>
			<figure>
				<img src="${ImageCss}">
			</figure>
			<section>
				<p>${item.itemDisplayName}</p>
				<details>

				<p id="header">${message}</p>
				<br>

					<summary>Product Features</summary>
					<ul>
						<li>Seller ${item.seller}</li>
						<li>Price ${item.price}</li>
						<li>Quantity  ${item.quantity}</li>
						<li>Start Time ${item.startTime}</li>
						<li>End Time ${item.endTime}</li>
						<li>Location ${item.location}</li>

						<li>No of Bids ${noOfBids}</li>
						<li>Current Bid ${prevBid}</li>


					</ul>
				</details>
				<button>Register</button>
				
				<button id = "bid">Bid</button>
			</section>
		</div>
	<a href="/auctionspace/index.jsp">Home</a>
	

				<button>Bid</button>
			</section>
		</div>
	<a href="/auctionspace/index.jsp">Home</a>
<script>
var DisplayButton = document.getElementById("bid");
DisplayButton.addEventListener('click',function(event){
	location.href='/auctionspace/Bid/bidding/${item.itemId}';
})

var LogOutButton = document.getElementById("logout");
LogOutButton.addEventListener('click',function(event){
location.href='/auctionspace/SignOut';
})
</script>

</body>
</html>