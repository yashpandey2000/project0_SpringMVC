<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>ORS</title>
<!-- fontawesome library -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<!-- bootstrap library -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- datepicker picker library -->

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="http://localhost:8080/project0/resources/js/CheckBox11.js"></c:url>"></script>

</head>
<body class="img-fluid">

	<div class="wrapper">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
      <div class="container-fluid">

		<c:if test="${not empty sessionScope.user}">
			<div class="row">
				<div class="col-md-2">
				  <tiles:insertAttribute name="menu"></tiles:insertAttribute> 
				</div>

				<div class="col-md-8">
                
					<tiles:insertAttribute name="body"></tiles:insertAttribute>
					<tiles:insertAttribute name="footer"></tiles:insertAttribute>
					
				</div>
				
			</div>
		</c:if>
		<c:if test="${empty sessionScope.user }">
			<div>

				<tiles:insertAttribute name="body"></tiles:insertAttribute>
				<tiles:insertAttribute name="footer"></tiles:insertAttribute>
			</div>

		</c:if>
	</div>
	</div>
</div>

<br><br><br><br><br><br><br>
</body>
</html>