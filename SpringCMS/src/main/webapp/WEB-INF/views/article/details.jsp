<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.title} - details</title>
</head>
<body>
<h1>${article.title}</h1>
<h4>${article.content}</h4>
<hr>

<div>
    <h3>Details:</h3>
    Author: ${article.author.fullName}<br>
    Categories:
    <ul>
        <c:forEach items="${article.categories}" var="category">
            <li>${category.name}</li>
        </c:forEach>
    </ul>
</div>
<a href="/articles"><button>Back to list</button></a>
</body>
</html>
