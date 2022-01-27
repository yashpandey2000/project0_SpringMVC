<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<div class="row">
	<div class="col-lg-12">
		<div class="card card-table c1">
		 <br>
			<h3 class="w-100 text-center under-over-line">
			<u><b>	<s:message code="label.marksheetmeritlist" /> </u></b>
			</h3>
			
     <br>
    
			<sf:form method="post" modelAttribute="form">
				<c:set value="${((form.pageNo-1)*form.pageSize)+1}" var="index"></c:set>
				<sf:hidden path="pageNo" />
				<sf:hidden path="pageSize" />
				<c:if test="${!empty list}">
				
				
				<c:if test="${not empty list}">
				
				<div style="margin-left:2%;" class="pb-2" >

<a href= '<c:url value= "/ctl/Jasper"></c:url>' class="btn btn-sm btn-danger "  role="button" target="blank">
<span class="fa fa-print mr-1"></span>Print</a>

</c:if>

<br><br>
		
					<div class="row d-flex justify-content-center">
						<div class="col-lg-12 table-responsive">
							<table
								class="table table-hover table-striped border border-secondary">
								<thead class="c3">
									<tr>
										<th scope="col" class="text-center text-white"><input
											type="checkbox" id="select_all" /></th>
										<th scope="col" class="text-center"><s:message code="label.sno"></s:message></th>
										<th scope="col" class="text-center"><s:message
												code="label.name" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.rollNo" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.physics" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.chemistry" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.maths" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.total" /></th>
										<th scope="col" class="text-center"><s:message
												code="label.percentage" /></th>
										<%-- <th scope="col" class="text-center"><s:message
												code="label.edit" /></th> --%>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="marksheet" varStatus="ct">
										<c:set var="percentage">
											<fmt:formatNumber type="number" minFractionDigits="2"
												maxFractionDigits="2"
												value="${(marksheet.physics+marksheet.chemistry+marksheet.maths)/3}" />
										</c:set>

										<tr>
											<td class="text-center"><input class="checkbox"
												name="chk_1" type="checkbox" value="${course.id}"></td>
											<td class="text-center"><c:out
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
												<c:set var="index"
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
											</td>
											<td class="text-center">${marksheet.name}</td>
											<td class="text-center">${marksheet.rollno}</td>
											<td class="text-center">${marksheet.physics}</td>
											<td class="text-center">${marksheet.chemistry}</td>
											<td class="text-center">${marksheet.maths}</td>
											<td class="text-center">${marksheet.physics+marksheet.chemistry+marksheet.maths}</td>
											<td class="text-center">${percentage}%</td>
											<%-- <td class="text-center"><c:url var="editUrl"
													value="/ctl/Marksheet/AddMarksheet?id=" /> <a
												class="btn btn-outline-warning btn-block btn-round w-100"
												href="${editUrl}${marksheet.id}"><i class="fa fa-trash"
													aria-hidden="true"></i> <s:message code="label.edit" /></a></td>
										 --%></tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty list}">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-2 col-6">
							<button type="submit"
								class="btn btn-outline-warning btn-block btn-round w-100"
								name="operation" value="Back">
								<i class="fa fa-reply" aria-hidden="true"></i>
								<s:message code="label.back"></s:message>
							</button>
						</div>
					</div>
				</c:if>
				
				<c:if test="${empty list}">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-2 col-6">
							<button type="submit"
								class="btn btn-outline-warning btn-block btn-round w-100"
								name="operation" value="Back">
								<i class="fa fa-reply" aria-hidden="true"></i>
								<s:message code="label.back"></s:message>
							</button>
						</div>
					</div>
				</c:if>
				
				
				<style>
.c1 {
	border-width: 5px;
	border-style: ridge;
	border-radius: 25px;
}
.c3 {
	background-color: #36cac3;
}

	.btn{
	padding:13px;
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
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>