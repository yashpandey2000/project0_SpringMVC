<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">

<style type="text/css">
body {

	background-image: linear-gradient( rgba(0, 0, 0, 0.550) ,  rgba(0, 0, 0, 0.550)),
		url('http://localhost:8080/project0/resources/img/18.jpg');
   background-position: center;
   background-size: 1550px;
      height: 752px;
      background-repeat: no-repeat;
} 

</style>
</head>
<body class="img-fluid">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<c:if test="${empty sessionScope.user }">
		<div class="row">
			<div class="col-sm-12">

				<h1 align="center">
					<font  color="white" style="font-size: 70px"><b>Welcome
						To ORS</b></font>
				</h1>
			</div>
		</div>
	</c:if>
	
	<c:if test="${not empty sessionScope.user }">


<div class="row">
			<div class="col-sm-12">

				<h1 align="center">
					<font  color="white" style="font-size: 70px"><b>Welcome
						To ORS</b></font>
				</h1>
			</div>
		</div>
		



	</c:if>
	
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
</body>
</html>