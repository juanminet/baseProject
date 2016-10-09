<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>WELCOME TO HOMEPAGE!</h3>
	<br>
	<br> Count : ${count}

	<c:if test="${not empty baseList}">
		<table class="display" id="table_athletes">
			<thead>
				<tr>
					<th>ID</th>
					<th>VALUE</th>
					<th>DESCRIPTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="base" items="${baseList}">
				
					<%-- <c:choose>
						<c:when test="${rowCounter.count % 2 == 0}">
							<c:set var="rowStyle" scope="page" value="odd" />
						</c:when>
						<c:otherwise>
							<c:set var="rowStyle" scope="page" value="even" />
						</c:otherwise>
					</c:choose> --%>
					<tr >
						<td>${base.idBase}</td>
						<td>${base.value}</td>
						<td>${base.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<div class="container">
		<div id="body_home">
			<div id="body_home_container">
				<div id="caja_form">
					<form:form commandName="baseCommand" action="${pageContext.request.contextPath}/home/save"
						method="POST">

						<form:errors path="*" element="div" />

						<div class="subcaja">
							<fieldset>
								<div class="form-row">
									<label for="value">value:</label> <span class="input"><form:input
											path="value" size="20" /> <form:errors path="value"
											cssClass="error" /></span>
								</div>
								<div class="form-row">
									<label for="password">description:</label> <span class="input"><form:input
											path="description" size="20" /> <form:errors
											path="description" cssClass="error" /></span>
								</div>
								<input type="submit" value="save">
							</fieldset>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>