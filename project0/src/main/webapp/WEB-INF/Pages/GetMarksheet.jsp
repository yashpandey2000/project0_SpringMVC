<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<div class="row">

	<div class="col-md-3"></div>
	<div class="col-md-6">
	<br><br>
		<div class="card c1">
			<div class="card-body c1">
				<h3 class="text-center default-text py-3">

				<b>	<s:message code="label.getmarksheet" /> </b>

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
					<sf:hidden path="id" />
					<sf:hidden path="createdBy" />
					<sf:hidden path="modifiedBy" />
					<sf:hidden path="createdDateTime" />
					<sf:hidden path="modifiedDateTime" />

					<sf:label path="rollNo">
						<s:message code="label.rollNo" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-calendar  grey-text"></span>
							</span>
						</div>
						<sf:input path="rollNo" class="form-control"
							placeholder="${enterRollNo}" />
					</div>
					<font color="red"><sf:errors path="rollNo" /></font>
					<br>
					<br>
					<center>
						<button type="submit" class=" btn btn-outline-danger"
							name="operation" value="search">
							<s:message code="label.getmarksheet" />
						</button>

					</center>
					<br>
					<br>
					<c:if test="${not empty GetMarksheet}">

						<div class="container" >

							<table width="100%" style="background-color: white;" border="3px">
								<tr>
									<th id="po1" colspan="2"><s:message code="label.rollNo" /></th>
									<td id="po1" align="center" colspan="3">${form.rollNo}</td>
								</tr>
								<tr>
									<th id="po1" colspan="2"><s:message code="label.name" /></th>
									<td id="po1" align="center" colspan="3">${form.name }</td>
								</tr>
								<tr style="background-color: #e1b5158c;">
									<th id="po1"><s:message code="label.max" /></th>
									<th id="po1"><s:message code="label.min" /></th>
									<th id="po1"><s:message code="label.subject" /></th>
									<th id="po1" colspan="2"><s:message code="label.marks" /></th>
								</tr>

								<tr>
									<th id="po1"><s:message code="label.physics" /></th>
									<td align="center">100</td>
									<td align="center">35</td>
									<td id="po1" align="center">${form.physics}</td>
								</tr>
								<tr>
									<th id="po1"><s:message code="label.maths" /></th>
									<td align="center">100</td>
									<td align="center">35</td>
									<td id="po1" align="center">${form.maths}</td>
								</tr>
								<tr>
									<th id="po1"><s:message code="label.chemistry" /></th>
									<td align="center">100</td>
									<td align="center">35</td>
									<td id="po1" align="center">${form.chemistry}</td>
								</tr>
								<tr>
									<td colspan="2"><s:message code="label.total" /></td>
									<c:set var="total">
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2"
											value="${(form.physics+form.chemistry+form.maths)}" />
									</c:set>
									<td colspan="2">${total}</td>
								</tr>
								<tr>
									<td colspan="2"><s:message code="label.percentage" /></td>
									<c:set var="percentage">
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2"
											value="${(form.physics+form.chemistry+form.maths)/3}" />
									</c:set>
									<td colspan="2">${percentage}%</td>
								</tr>

							</table>


						</div>





					</c:if>



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
