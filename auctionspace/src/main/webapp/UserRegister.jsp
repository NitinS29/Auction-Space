<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Registration</title>
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
</head>
<body id="Register">
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
			<!--<a class="navbar-brand" href="#"><img src="${imgPath}/logo.png" alt=""></a>-->
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="main-nav nav navbar-nav navbar-right">
				<li class="wow fadeInDown" data-wow-delay="0s"><a
					class="active" href="/auctionspace/index.jsp">Home</a></li>
				<li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#"></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<br>

	<div class="row page-title text-center wow bounce" data-wow-delay="1s">
		<h4>User Registration</h4>
	</div>

	<form:form commandName="user" action="registerProcessUser"
		method="post" name="myForm" onsubmit="return validate();">
		<table align="center">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><form:label path="fname">First Name</form:label></td>
				<td><form:input path="fname" name="firstname" id="firstname" />
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><form:label path="mname">Middle Name</form:label></td>
				<td><form:input path="mname" name="middlename" id="middlename" />
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>

			<tr>
				<td><form:label path="lname">Last Name</form:label></td>
				<td><form:input path="lname" name="lastname" id="lastname" />
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" />
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
			</tr>
			<tr></tr>
		</table>
		<br>
		<br>
		<table align="center">
			<tr>
				<td></td>
				<td><form:button id="register" name="register" class="myButton">Register</form:button>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

		</table>
	</form:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
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
					</span> <span><a href="https://dribbble.com/siblu">Jessica Lu</a> </span>
					<span><a href="https://dribbble.com/siblu">Nitin
							Salvankar</a> </span> <span> <a href="https://dribbble.com/siblu">Shipra
							Shinde</a></span>
				</p>
			</div>
		</div>
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="${jsPath}/vendor/jquery-1.10.2.min.js"><\/script>')</script>
	<script src="${jsPath}/bootstrap.min.js"></script>
	<script src="${jsPath}/owl.carousel.min.js"></script>
	<script src="${jsPath}/wow.js"></script>
	<script src="${jsPath}/main.js"></script>

	<script>
            function validate() {
    var x = document.myForm.firstname.value;
    if (x == "") {
        alert("First Name must be filled out");
        return false;
    }
    var x1 = document.myForm.username.value;
    if (x1 == "") {
        alert("UserName must be filled out");
        return false;
     }
    var x2 = document.myForm.password.value;
    if (x2 == "") {
        alert("Password must be filled out");
        return false;
    }
    var x3 = document.myForm.email.value;
    if (x3 == "") {
        alert("Email ID must be filled out");
        return false;
    }
    var x4 = document.myForm.phone.value;
    if (x4 == "") {
        alert("Phone must be filled out");
        return false;
    }
    if (x4.length != 10){
    	alert("Phone number should have 10 digits.");
    	return false;
    }
  
    atpos = x3.indexOf("@");
    dotpos = x3.lastIndexOf(".");
    if (atpos < 1 || ( dotpos - atpos < 2 )) 
    {
       alert("Please enter correct email ID")
       //document.myForm.EMail.focus() ;
       return false;
    }
    return (true);
}
</script>
</body>
</html>
