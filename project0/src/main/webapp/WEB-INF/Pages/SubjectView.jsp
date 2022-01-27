<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<div class="row">

	<div class="col-md-3"></div>
	<div class="col-md-6">
		<div class="card c1">
			<div class="card-body c1">
				<h3 class="text-center default-text py-3">
					<c:choose>
						<c:when test="${form.id==0}">
							<b><s:message code="label.addsubject" /></b>
						</c:when>
						<c:otherwise>
						<b>	<s:message code="label.updatesubject"></b></s:message>
						</c:otherwise>
					</c:choose>
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

					<sf:label path="subjectName">
						<s:message code="label.name" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-book  grey-text"></span>
							</span>
						</div>
						<sf:input path="subjectName" class="form-control"
							placeholder="${enterName}" />
					</div>
					<font color="red"><sf:errors path="subjectName" /></font>
					<br>



					<sf:label path="courseId">
						<s:message code="label.coursename" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-user-md grey-text"></span>
							</span>
						</div>
						<sf:select path="courseId" class="form-control">
							<sf:option value="0">
								<s:message code="label.selectcourse"></s:message>
							</sf:option>
							<sf:options items="${courseList}" itemValue="id" itemLabel="name" />
						</sf:select>
					</div>
					<font color="red"><sf:errors path="courseId" /></font>
					<br>
					<sf:label path="description">
						<s:message code="label.description" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-edit grey-text"></span>
							</span>
						</div>
						<sf:textarea path="description" class="form-control"
							placeholder="${enterdescription}" />
					</div>
					<font color="red"><sf:errors path="description" /></font>
					<br>



					<br>
					<div>
						<c:choose>
							<c:when test="${form.id==0}">
								<center>
									<button type="submit" class="btn btn-outline-success"
										name="operation" value="Save">
										<s:message code="label.save" />
									</button>
									<button type="submit" class=" btn btn-outline-danger"
										name="operation" value="Reset">
										<s:message code="label.reset" />
									</button>
								</center>
							</c:when>
							<c:otherwise>
								<center>
									<button type="submit" class="btn btn-outline-danger"
										name="operation" value="Update">
										<s:message code="label.update" />
									</button>
									<button type="submit" class="btn btn-outline-success"
										name="operation" value="Cancel">
										<s:message code="label.cancel" />
									</button>
									</center>
					</c:otherwise>
					</c:choose>
			</div>





			<br> <br>
			<style>
			.btn{
			padding: 18px;
			}
.c1 {
	border-width: 5px;
	border-style: ridge;
	border-radius: 25px;
}

i.css {
	border-radius: 6px 0px 0px 6px;
	border: 1px solid #ced4da;
	padding-left: 15px;
	padding-bottom: 18px;
	background-color: #e9ecef;;
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
			<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						changeMonth : true,
						changeYear : true,
						yearRange : '1970:2030',
						dateFormat : 'dd/mm/yy',
						endDate : '-18y'
					});
				});
			</script>

			</sf:form>
		</div>
	</div>
</div>
<div class="col-md-4"></div>
</div>

<br>
<br>
