<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/add-hero">
    <label for="name">Hero name: </label><input type="text" id="name" name="name"><br>
    <label for="power">Hero power: </label><input type="number" id="power" name="power" min="0" step="1"><br>
    <label for="dateOfBirth">Hero date of birth: </label><input type="date" id="dateOfBirth" name="dateOfBirth"><br>
    <label for="phoneNumber">Hero phone number: </label><input type="tel" id="phoneNumber" name="phoneNumber"><br>
    <button type="submit">Add hero</button>
</form>

<ol>
    <c:forEach items="${heroes}" var="hero">
        <li>${hero}</li>
    </c:forEach>
</ol>
</body>
</html>
