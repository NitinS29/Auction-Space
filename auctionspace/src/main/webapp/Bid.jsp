<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bid</title>
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
	<p id="header">Bidding for ${itemId}</p>
	<br><br>
	<form:form commandName="bid" action="/auctionspace/Bid/bidProcess/${itemId}" method="post">
		<table>	
			<tr>
				<td><form:label path="bid_amount" name="bid_amount" id="bid_amount">Bid Amount</form:label></td>
				<td><form:input path="bid_amount" name="bid_amount" id="bid_amount" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="username" value="${user}"  /></td>
				<td><input type="hidden" name="item_id" value="${itemId}" /></td>
				
			</tr>
			<tr><td><form:button id="submit" name="submit" class="myButton">Submit</form:button></td></tr>
		</table>
	</form:form>
</body>
</html>