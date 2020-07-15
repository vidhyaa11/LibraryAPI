<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New book</title>
</head>
<body>

<div align="center">

<h3>New Book details</h3>

<form:form action="http://localhost:8080/springMVC/save" method="post" modelAttribute="bookDetails">

<table border="0" cellpadding="5">

<tr>
<td>Title :</td>
<td> <form:input path="title"/></td>  
</tr>

<tr>
<td>Author</td>
<td> <form:input path="author"/></td>  
</tr>

<tr>
<td colspan="2"><input type="submit" value="Save"></td>
</tr> 


</table>


</form:form>


</div>

</body>
</html>