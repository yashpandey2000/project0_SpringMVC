<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">


img{

    border-radius: 8px;
    padding: 5px;
    background-color: hsl(240, 0%, 50%);
   
}
.im1 {
	width: 110px;
	height: 50px;
}

.navbar-dark .navbar-nav .nav-link {
	color: #F0F8FF;
	margin-left: 35px;
}

ul.dropdown-menu {
	width: 11vw;
	border-radius: 0px;
	font-weight: 400;
	font-size: 0.9em;
	line-height: 16px;
	text-decoration: none;
	padding: 0px;
	list-style-type: none;
	-webkit-animation: mymove 0.5s;
	animation: mymove 0.5s;
	background-color: #fff;
	-webkit-box-shadow: 4px 9px 25px -6px rgba(77, 77, 77, 0.61);
	-moz-box-shadow: 4px 9px 25px -6px rgba(77, 77, 77, 0.61);
	box-shadow: 4px 9px 25px -6px rgba(77, 77, 77, 0.61);
}

li.dropdown:hover ul.dropdown-menu {
	display: block;
}

.dropdown-menu li:hover a {
	color: #ec5626;
}

.dropdown-menu li {
	border-bottom: 1px solid #ccc;
	padding: 20px;
	display: block;
}

.dropdown-menu li a {
	color: #444;
	text-decoration: none;
	text-transform: capitalize;
}

@
keyframes mymove {from { left:100px;
	height: 0px;
	opacity: 0;
	border-bottom: 0px;
}

to {
	height: auto;
}

}
.navbar-nav a.nav-link {
	font-family: 'Roboto', sans-serif;
	text-transform: uppercase;
	padding: 0px !important;
	
}

ul.navbar-nav li.nav-item {
	margin: 0 25px;
}

ul.navbar-nav .nav-item:after {
	content: '';
	display: block;
	height: 3px;
	width: 0;
	transition: width .5s ease, background-color .5s ease;
}

.navbar-nav .nav-item:hover:after {
	width: 100%;
	background: #eb3719;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".dropdown").hover(
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideDown("fast");
							$(this).toggleClass('open');
						},
						function() {
							$('.dropdown-menu', this).not('.in .dropdown-menu')
									.stop(true, true).slideUp("fast");
							$(this).toggleClass('open');
						});
			});
</script>
</head>
<div style="background-color: #000000">
<nav class="navbar navbar-expand-lg navbar-dark">

<div class="container-fluid">


	<a class="navbar-brand" href='<c:url value="/Welcome"></c:url>'><img
		class="im1"
		src=  '<c:url value="http://localhost:8080/project0/resources/img/JOBPORTAL-1583211843.png"></c:url>'></a>
	<a class=" circle p-1 m-0"
		href='<c:url value="?lang=en"></c:url>'><strong>English</strong></a> <font color="grey">|</font> <a
		class=" circle p-1 m-0"
		href="<c:url value="?lang=hi"></c:url>"><strong>हिन्दी </strong></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="nav navbar-nav ml-auto">
			<a class="nav-link" href="#"> <span class="sr-only">(current)</span>
			</a>

			<c:if test="${sessionScope.user.roleid == 1}">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="far fa-file"></i> <s:message
							code="label.marksheet" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:if test="${sessionScope.user.roleid == 1}">
							<a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/AddMarksheet"/>"><i
								class="far fa-file"></i> <s:message code="label.addmarksheet" /></a>
							<div class="dropdown-divider"></div>
						</c:if>
						<a class="dropdown-item"
							href="<c:url value="/ctl/Marksheet/GetMarksheet"/>"><i
							class="far fa-copy"></i> <s:message code="label.getmarksheet" /></a>
						<a class="dropdown-item"
							href="<c:url value="/ctl/Marksheet/MeritList"/>"><i
							class="far fa-copy"></i> <s:message
								code="label.marksheetmeritlist" /></a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-user-circle"></i> <s:message
							code="label.adduser" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<c:url value="/ctl/User/AddUser"/>"><i
							class="fas fa-user-circle"></i> <s:message code="label.adduser" /></a>

					</div></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-user-tie"></i> <s:message
							code="label.addrole" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<c:url value="/ctl/Role/AddRole"/>"><i
							class="fas fa-user-tie"></i> <s:message code="label.addrole" /></a>

					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-user-tie"></i> <s:message
							code="label.addfaculty" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item"
							href="<c:url value="/ctl/Faculty/AddFaculty"/>"><i
							class="fas fa-user-tie"></i> <s:message code="label.addfaculty" /></a>

					</div></li>


			</c:if>
			<c:if
				test="${sessionScope.user.roleid==1||sessionScope.user.roleid==2}">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-university"></i> <s:message
							code="label.addcollege" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item"
							href="<c:url value="/ctl/College/AddCollege"/>"><i
							class="fas fa-university"></i> <s:message code="label.addcollege" /></a>

					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-book-open"></i> <s:message
							code="label.addcourse" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item"
							href="<c:url value="/ctl/Course/AddCourse"/>"><i
							class="fas fa-book-open"></i> <s:message code="label.addcourse" /></a>

					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="far fa-user-circle"></i> <s:message
							code="label.addstudent" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item"
							href="<c:url value="/ctl/Student/AddStudent"/>"><i
							class="far fa-user-circle"></i> <s:message
								code="label.addstudent" /></a>

					</div></li>




				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-clock"></i> <s:message
							code="label.addtimetable" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item"
							href="<c:url value="/ctl/Timetable/AddTimetable"/>"><i
							class="fas fa-clock"></i> <s:message code="label.addtimetable" /></a>

					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-university"></i> <s:message
							code="label.addsubject" /></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item"
							href="<c:url value="/ctl/Subject/AddSubject"/>"><i
							class="fas fa-calculator"></i> <s:message code="label.addsubject" /></a>

					</div></li>
			</c:if>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user-tie"></i> <c:if
						test="${not empty sessionScope.user }">
						<c:set var="name" value="${sessionScope.user.firstname} ," />
						<c:set var="role" value='${sessionScope["role"]}' />
						<c:out value="${name}(${role})"></c:out>
					</c:if> <c:if test="${empty sessionScope.user}">
						<s:message code="label.hiGuest"></s:message>
					</c:if> </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<c:if test="${not empty sessionScope.user }">
						<a class="dropdown-item"
							href="<c:url value="/ctl/User/MyProfileCtl"/>"><i
							class="fas fa-user-tie"></i> <s:message code="label.myprofile" /></a>
						<a class="dropdown-item"
							href="<c:url value="/ctl/User/ChangePasswordCtl"/>"><i
							class="fas fa-edit"></i> <s:message code="label.changepassword" /></a>
						<a class="dropdown-item"
							href="<c:url value="/resources/doc/index.html"/>" target="_blank"><i
							class="fas fa-clone"></i> <s:message code="label.javadoc" /></a>
						<a class="dropdown-item" href="<c:url value="/Login"/>"><i
							class="fas fa-sign-out-alt"></i> <s:message code="label.logout" /></a>
					</c:if>
					<c:if test="${empty sessionScope.user }">
						<a class="dropdown-item" href="<c:url value="/Login"/>"><i
							class="fas fa-sign-in-alt"></i> <s:message code="label.login" /></a>
						<a class="dropdown-item" href="<c:url value="/Registration"/>"><i
							class="fas fa-registered"></i> <s:message code="label.signup" /></a>
						<a class="dropdown-item" href="<c:url value="/ForgetPassword"/>"><i
							class="fas fa-university"></i> <s:message
								code="label.forgetpassword" /></a>
					</c:if>
				</div></li>
		</ul>
	</div>
</div>
</div>
</nav>