<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            font-size: larger;
            padding: 5px;
        }
        th {
            background-color: gray;
            padding: 3px;
            color: white;
        }
    </style>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>x</th>
            <c:forEach var = "i" begin = "1" end = "${size}">
            <th>${i}</th>
            </c:forEach>
        </tr>
    </thead>
    <tbody>
    <c:forEach var = "i" begin = "1" end = "${size}">
        <tr>
            <th>${i}</th>
            <c:forEach var = "j" begin = "1" end = "${size}">
                <td>${i * j}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
