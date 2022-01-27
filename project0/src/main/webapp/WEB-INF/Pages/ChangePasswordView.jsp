<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</br>
<div class="row">

	<div class="col-md-3"></div>
	<div class="col-md-6">
		<div class="card c1">
			<div class="card-body c1">
				<h3 class="text-center default-text py-3">
				<b>	<s:message code="label.changepassword"></s:message>  </b>
				</h3>

				<div>
					<c:if test="${error!=null }">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="message">
								<i class="nc-icon nc-bell-55"></i>${error}
							</div>
						</div>
					</c:if>

					<c:if test="${success!=null }">
						<div class="alert alert-success alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="message">
								<i class="nc-icon nc-bell-55"></i>${success}
							</div>
						</div>
					</c:if>
				</div>
				<sf:form method="post" modelAttribute="form">




					<sf:label path="oldPassword">
						<s:message code="label.oldPassword" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-lock grey-text"></span>
							</span>
						</div>
						<sf:input type="password" path="oldPassword" class="form-control"
							placeholder="${enteroldpassword}" />
					</div>

					<font color="red"><sf:errors path="oldPassword" /></font>
					<br>

					<sf:label path="newPassword">
						<s:message code="label.newPassword" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-key  grey-text"></span>
							</span>
						</div>
						<sf:input type="password" path="newPassword" class="form-control"
							placeholder="${enternewpassword}" />
					</div>

					<font color="red"><sf:errors path="newPassword" /></font>
					<br>


					<sf:label path="confirmPassword">
						<s:message code="label.confirmPassword" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-lock  grey-text"></span>
							</span>
						</div>
						<sf:input type="password" path="confirmPassword"
							class="form-control" placeholder="${enterconfirmpassword}" />
					</div>

					<font color="red"><sf:errors path="confirmPassword" /></font>
					<br>
					<br>
					<div>
					<center>
							<button type="submit" class="btn btn-outline-success"
								name="operation" value="Save">
								<s:message code="label.save" />
							</button>
							<button type="submit" class=" btn btn-outline-danger"
								name="operation" value="MyProfile">
								<s:message code="label.myprofile" />
							</button>
							</center>
					</div>





					<br>
					<br>
					<style>
.c1 {
	border-width: 5px;
	border-style: ridge;
	border-radius: 25px;
}
.btn{
padding: 18px;
}

body {

	background-image: linear-gradient( rgba(0, 0, 0, 0.550) ,  rgba(0, 0, 0, 0.550)),
		url('http://localhost:8080/project0/resources/img/18.jpg');
   background-position: center;
   background-size: 1550px;
      height: 752px;
      background-repeat: no-repeat;
} 


</style>
				</sf:form>
			</div>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>
<br>
<br>
