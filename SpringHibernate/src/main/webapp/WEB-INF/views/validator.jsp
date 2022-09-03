<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<c:forEach items="${violations}" var="violation">
    <li><b>${violation.propertyPath}:</b> ${violation.message}</li>
</c:forEach>
</ul>
</body>
</html>
