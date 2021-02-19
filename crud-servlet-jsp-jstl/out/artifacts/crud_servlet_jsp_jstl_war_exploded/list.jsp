<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>

<a href="/studentServlet?action=create">Create student</a>
<p style="color: green">${message}</p>

<h3>List student</h3>

<table align="center" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.id}</td>
            <td><a href="/studentServlet?action=detail&id=${student.id}">${student.name}</a></td>
            <td>${student.dateOfBirth}</td>
            <td><a href="/studentServlet?action=update&id=${student.id}">Update</a></td>
            <td><a href="/studentServlet?action=delete&id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
