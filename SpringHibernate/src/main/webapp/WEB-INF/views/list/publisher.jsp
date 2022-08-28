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
        <th>Name</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${publishers}" var="p">
        <tr>
            <td><c:out value="${p.name}"/></td>
            <td><a href="<c:url value="/publisherForm/delete/${p.id}"/>" onclick="confirm('Are you sure to delete: ${p.name}?')">DELETE</a>
                <a href="<c:url value="/publisherForm/edit/${p.id}"/>">EDIT</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<hr>
<a href="<c:url value="/publisherForm/form"/>">Add publisher</a>

</body>
</html>
