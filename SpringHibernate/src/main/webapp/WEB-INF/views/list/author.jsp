<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author list</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
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
      <td><a href="<c:url value="/authorForm/delete/${a.id}"/>" onclick="confirm('Are you sure to delete: ${a.fullName}?')">DELETE</a>
        <a href="<c:url value="/authorForm/edit/${a.id}"/>">EDIT</a>
      </td>
    </tr>
  </c:forEach>

</table>
<br>
<hr>
<a href="<c:url value="/authorForm/form"/>">Add author</a>
</body>
</html>
