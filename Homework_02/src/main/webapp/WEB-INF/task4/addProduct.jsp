<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add-product" method="post">
    <label for="name">Nazwa: </label><input type="text" name="name" id="name" value="${name}"> <br>
    <label for="price">Cena: </label><input type="number" name="price" id="price" min="0.01" step="0.01" value="${price}"> <br>
  <button type="submit">Utwórz <b>PRODUKT</b></button>
</form>
</body>
</html>
