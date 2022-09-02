<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>title</th>
        <th>content</th>
        <th>created</th>
        <th>updated</th>
        <th>author</th>
    </tr>
    <c:forEach var="article" items="#{articles}">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>${article.author.firstName} ${article.author.lastName}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
