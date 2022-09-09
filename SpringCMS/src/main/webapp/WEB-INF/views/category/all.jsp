<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category list</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${categories}" var="c">
        <tr>
            <td><c:out value="${c.name}"/></td>
            <td><c:out value="${c.description}"/></td>
            <td><a href="<c:url value="/categories/delete/${c.id}"/>">DELETE</a>
                <a href="<c:url value="/categories/edit/${c.id}"/>">EDIT</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<hr>
<a href="<c:url value="/categories/add"/>">Add category</a>

</body>
</html>
