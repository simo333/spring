<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2;}

        tr:hover {background-color: #ddd;}

        th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>
<div>
    <p>W koszyku jest ${cartItemsQuantity} pozycji.</p>
    <p>W koszyku jest ${cartProductQuantity} produktów.</p>
    <p>Wartość koszyka to: <fmt:formatNumber value="${cartValue}" type="currency" currencySymbol="zł"/>.</p>
</div>
<div>
    <table style="border: black, ">
        <tr>
            <th>ID</th>
            <th>Nazwa produktu</th>
            <th>Cena za sztukę</th>
            <th>Ilość</th>
            <th>Cena sumaryczna</th>
            <th>Akcje</th>
        </tr>
        <c:forEach items="${cart}" var="cartItem">
            <tr>
                <td>${cartItem.product.id}</td>
                <td>${cartItem.product.name}</td>
                <td><fmt:formatNumber value = "${cartItem.product.price}" type="currency" currencySymbol="zł"/></td>
                <td>${cartItem.quantity}</td>
                <td><fmt:formatNumber value = "${cartItem.product.price * cartItem.quantity}" type="currency" currencySymbol="zł"/></td>
                <td>
                    <a href="/cart-items/${cartItem.product.id}/increase-quantity"><button value="button">+</button></a>
                    <a href="/cart-items/${cartItem.product.id}/decrease-quantity"><button value="button">-</button></a>
                    <a href="/cart-items/${cartItem.product.id}"><button value="button">Usuń</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
