<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>WELCOME TO HOMEPAGE!</h3>
	<br>
	<br>
	Count : ${count}
	
	
	<div class="container">					
		<div id ="body_home">
			<div id = "body_home_container">		
				<div id="caja_form">	
				 	<form:form commandName="baseCommand" action="home/save" method="POST" >
						 
					    <form:errors path="*" element="div" />
					    
					    <div class="subcaja">
							<fieldset>						
						        <div class="form-row">
						            <label for="value">value:</label>
						            <span class="input"><form:input path="value" size="20"/>   <form:errors path="value" cssClass="error" /></span>
						        </div>   
						        <div class="form-row">
						            <label for="password">description:</label>
						            <span class="input"><form:input path="description" size="20" />   <form:errors path="description" cssClass="error" /></span>
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