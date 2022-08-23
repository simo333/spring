<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
  First name: <form:input path="firstName"/><br>
  Last name: <form:input path="lastName"/><br>
  Gender: Male <form:radiobutton path="gender" value="M"/> Female <form:radiobutton path="gender" value="F"/><br>
  Country: <form:select path="country">
              <form:option value="-" label="--Please Select--"/>
              <form:options items="${countries}"/>
          </form:select><br>
  Notes: <form:textarea path="notes"/><br>
  Mailing list: <form:checkbox path="mailingList"/><br>
  Programming skills: <form:select path="programmingSkills" multiple="true">
                        <form:option value="-" label="--Please Select--"/>
                        <form:options items="${programmingSkills}"/>
                      </form:select><br>
  Hobbies: <form:checkboxes path="hobbies" items="${hobbies}"/><br>
  <button type="submit">Save</button>
</form:form>
</body>
</html>
