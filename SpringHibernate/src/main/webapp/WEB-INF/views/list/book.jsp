<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<table>
    <tr>
        <th>Title</th>
        <th>Rating</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${books}" var="b">
        <tr>
            <td><c:out value="${b.title}"/></td>
            <td><c:out value="${b.rating}"/></td>
            <td><c:out value="${b.description}"/></td>
            <td><a href="<c:url value="/bookForm/delete/${b.id}"/>" onclick="confirm('Are you sure to delete: ${b.title}?')">DELETE</a>
                <a href="<c:url value="/bookForm/edit/${b.id}"/>">EDIT</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<hr>
<a href="<c:url value="/bookForm/form"/>">Add book</a>

</body>
</html>
