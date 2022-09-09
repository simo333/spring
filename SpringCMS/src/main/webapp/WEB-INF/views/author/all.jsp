<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors list</title>
</head>
<body>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${authors}" var="a">
        <tr>
            <td><c:out value="${a.firstName}"/></td>
            <td><c:out value="${a.lastName}"/></td>
            <td><a href="<c:url value="/authors/delete/${a.id}"/>">DELETE</a>
                <a href="<c:url value="/authors/edit/${a.id}"/>">EDIT</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<hr>
<a href="<c:url value="/authors/add"/>">Add author</a>

</body>
</html>
