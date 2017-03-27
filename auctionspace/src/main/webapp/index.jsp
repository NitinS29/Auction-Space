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
<span>An auction site for students of UNC Charlotte.</span>
</div>
<a href = "Users/login" id="loginlink">LOG IN</a><a href = "#" id="registerlink">REGISTER/</a>
<div id="myModal" class="modal">
	<div class="modalcontent">
  		<span class="close">&times;</span>
  		<p>
  	  		<input type="radio" name="user" id = "user1" value="seller">Seller<br>
  			<input type="radio" name="user" id = "user2" value="buyer"> Buyer<br>
  			<button id = "submitbutton" type="button" >Submit</button>	
  		</p>
	</div>
</div>
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
		<img src="${HomeImage}" height = 200 width = 750>
	</div>
<script>
var modal = document.getElementById('myModal');
var btn = document.getElementById("registerlink");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
    modal.style.display = "block";
}

span.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var SubButton = document.getElementById("submitbutton");
SubButton.addEventListener('click',function(event){
	if(document.getElementById("user1").checked)

	{
		location.href='Users/registerSeller';
	}
	
	if(document.getElementById("user2").checked)
	{
		location.href='Users/registerBuyer';
	}
})
</script>
</body>
</html>