<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>
    <form action="/studentServlet" method="post">
        <input type="hidden" name="action" value="create" />
        <label>Name: </label>
        <input type="text" name="name"/><br>
        <label>Date of birth: </label>
        <input type="text" name="dateOfBirth"/><br>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
