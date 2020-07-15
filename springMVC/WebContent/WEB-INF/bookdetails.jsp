<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Central Library</title>
</head>
<body>
<div align="center">

<h3>Welcome to Central Library</h3>

<form method="get" action="http://localhost:8080/springMVC/search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="http://localhost:8080/springMVC/new">New Book</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${booklist}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>
                <a href="http://localhost:8080/springMVC/edit?id=${book.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="http://localhost:8080/springMVC/delete?id=${book.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>