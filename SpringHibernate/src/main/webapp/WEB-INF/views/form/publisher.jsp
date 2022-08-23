<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher form</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<form:form method="post" modelAttribute="publisher" action="/publisherForm/form">
    <form:hidden path="id" value="${publisher.id}"/>
    Title: <form:input path="name" value="${publisher.name}"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
