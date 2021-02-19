<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
</head>
<body>
    <form action="/studentServlet" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="${student.id}" />
        <label>Name: </label>
        <input type="text" name="name" value="${student.name}"/><br>
        <label>Date of birth: </label>
        <input type="text" name="dateOfBirth" value="${student.dateOfBirth}"/><br>
        <input type="submit" value="Update" />
    </form>
</body>
</html>
