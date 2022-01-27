<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: "Lato", sans-serif;
}

.sidebar {
  height: 80%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 85px;
  left: 0;
/*   background-color: #ddddbb; */
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 40px;
  
}

.sidebar a {
  padding: 5px 8px 8px 32px;
  text-decoration: none;
  font-size: 20px;
  color: white;
  display: block;
  transition: 0.3s;
}


.sidebar .closebtn {
  position: absolute;
  top:0;
  right: 45px;
  font-size: 25px;
  margin-left: 0px;
}

.openbtn {
  font-size: 12px;
  background-color: #008B8B;
  color: white;
  padding: 10px 15px;
  margin-left: 10px;
  }


#main {
  transition: margin-left .5s;
  padding: 16px;
}

/* On smaller screens, where height is less tha	n 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px){
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
</style>

</head>
<body>
<c:if test="${not empty sessionScope.user }">
<div id="mySidebar" class="sidebar" style="background-color: #000000;">

  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
 <i class="fa fa-remove"></i></a>
  <br>
  <a href="<c:url value="/ctl/User/UserListCtl"/>"><b><s:message code="label.userlist" /></b></a>
  <a href="<c:url value="/ctl/Role/RoleListCtl"/>"><b><s:message code="label.rolelist" /></b></a>
  <a href="<c:url value="/ctl/Marksheet/MarksheetListCtl"/>"><b><s:message code="label.marksheetlist"/></b></a>
  <a href="<c:url value="/ctl/College/CollegeListCtl"/>"><b><s:message code="label.collegelist" /></b></a>
  <a href="<c:url value="/ctl/Course/CourseListCtl"/>"><b><s:message code="label.courselist" /></b></a>
  <a href="<c:url value="/ctl/Subject/SubjectListCtl"/>"><b><s:message code="label.subjectlist" /></b></a>
  <a href="<c:url value="/ctl/Faculty/FacultyListCtl"/>"><b><s:message code="label.facultylist" /></b></a>
  <a href="<c:url value="/ctl/Student/StudentListCtl"/>"><b><s:message code="label.studentlist" /></b></a>
  <a href="<c:url value="/ctl/Timetable/TimetableListCtl"/>"><b><s:message code="label.timetablelist" /></b></a>
</div>


<div id="main">
  <button class="openbtn" onclick="openNav()"><i class="fa fa-list"></i> Menu </button>  

</div>


<script>
function openNav() {
  document.getElementById("mySidebar").style.width = "230px";
  document.getElementById("main").style.marginLeft = "250px";
  openbtn="hide"
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
  
</c:if>
</body>
</html> 