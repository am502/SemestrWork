<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your deals</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/profile">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout"><span class="glyphicon glyphicon-user"></span> Выйти</a></li>
            <li><a href="/delete"><span class="glyphicon glyphicon-log-in"></span> Удалить свой профиль</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <th>№</th>
            <th>Способ оплаты</th>
            <th>Товар</th>
            <th>Цена</th>
            <th>Объем партии при оптовой продаже</th>
            <th>Условие продажи-отгрузки</th>
            <th>Примечание</th>
        </tr>

        <c:forEach items="${vendorDealList}" var="vendorDeal">
            <tr>
                <td><a href="/getvenddeals/${vendorDeal.vendorDealId}">${vendorDeal.vendorDealId}</a></td>
                <td>${vendorDeal.paymentMethod}</td>
                <td>${vendorDeal.goodName}</td>
                <td>${vendorDeal.price}</td>
                <td>${vendorDeal.lotSizeWholesale}</td>
                <td>${vendorDeal.conditionsSale}</td>
                <td>${vendorDeal.note}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
