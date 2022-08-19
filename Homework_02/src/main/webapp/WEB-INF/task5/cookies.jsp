<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${cookies}" var="cookieItem">
  <p>${cookieItem.name}</p>
  <p>${cookieItem.value}</p>
  <hr>
</c:forEach>
</body>
</html>
