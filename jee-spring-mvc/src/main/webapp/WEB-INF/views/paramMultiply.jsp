<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        td, th {
            padding: 1rem 1.5rem;
        }
        table {
            display: table;
            border-collapse: separate;
            box-sizing: border-box;
            text-indent: initial;
            border-spacing: 2px;
            border-color: grey;
        }
        thead {
            display: table-header-group;
            vertical-align: middle;
            border-color: inherit;
        }
        td {
            color: rgb(77, 77, 79);
            background-color: rgb(231, 231, 231);
        }
        th {
            color: rgb(255, 255, 255);
            font-weight: normal;
            background-color: rgb(124, 124, 125);
        }
    </style>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>x</th>
            <c:forEach var = "i" begin = "1" end = "${cols}">
            <th>${i}</th>
            </c:forEach>
        </tr>
    </thead>
    <tbody>
    <c:forEach var = "i" begin = "1" end = "${rows}">
        <tr>
            <th>${i}</th>
            <c:forEach var = "j" begin = "1" end = "${cols}">
                <td>${i * j}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
