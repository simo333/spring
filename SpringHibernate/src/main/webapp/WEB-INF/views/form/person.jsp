<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person form</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    Login: <form:input path="login"/><br>
    Password: <form:password path="password"/><br>
    Email: <form:input path="email"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
