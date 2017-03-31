<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Put up an item for auction</title>
<script src="http://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>

<link rel="stylesheet" href="/resources/static/css/addItems.css">
</head>

<body id="AddItem">
	<div class="container">
		<form:form commandName="item" action="processAddItem"
			class="well form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Add Item for Auction</legend>

				<div class="form-group">
					<form:label path="itemDisplayName" class="col-md-4 control-label">Item Name</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="itemDisplayName" name="itemDisplayName"
								id="itemDisplayName" placeholder="Item Name"
								class="form-control" type="text" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" class="col-md-4 control-label">Item Description</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:textarea class="form-control" path="description"
								name="description" id="description"
								placeholder="Item Description"></form:textarea>
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<form:label path="price" class="col-md-4 control-label">Price</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="price" name="price" id="price"
								placeholder="Price in $" class="form-control" />
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<form:label path="quantity" class="col-md-4 control-label">Quantity</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="quantity" name="quantity" id="quantity"
								placeholder="Number of Items" class="form-control" />
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<form:label path="startTime" class="col-md-4 control-label">Start Time</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="startTime" name="startTime" id="startTime"
								placeholder="Start time for auction of this item"
								class="form-control" type="datetime-local"/>
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<form:label path="endTime" class="col-md-4 control-label">End Time</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="endTime" name="endTime" id="endTime"
								placeholder="End time for auction of this item"
								class="form-control" />
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Location</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<form:input path="location" name="location" id="location"
								placeholder="location" class="form-control" type="text" />
						</div>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<form:button type="submit" class="btn btn-warning">Add Item</form:button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	<!-- /.container -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
</body>
</html>
