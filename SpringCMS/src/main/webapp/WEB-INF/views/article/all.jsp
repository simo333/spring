<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article list</title>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Content</th>
        <th>Created at</th>
        <th>Updated at</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${articles}" var="a">
        <tr>
            <td><c:out value="${a.title}"/></td>
            <td><c:out value="${a.content}"/></td>
            <td><c:out value="${a.created }"/></td>
            <td><c:out value="${a.updated }"/></td>
            <td><c:out value="${a.author.fullName }"/></td>
            <td><a href="<c:url value="/articles/get/${a.id}"/>">DETAILS</a>
                <a href="<c:url value="/articles/edit/${a.id}"/>">EDIT</a>
            <td><a href="<c:url value="/articles/delete/${a.id}"/>">DELETE</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<hr>
<a href="<c:url value="/articles/add"/>">Add article</a>

</body>
</html>
