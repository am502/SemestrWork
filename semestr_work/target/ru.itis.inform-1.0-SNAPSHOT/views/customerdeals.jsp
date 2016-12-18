<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer deals</title>

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
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Номер телефона</th>
            <th>Способ оплаты</th>
            <th>Товар</th>
            <th>Цена</th>
            <th>Объем покупки</th>
            <th>Примечание</th>
            <th>Купить</th>
        </tr>

        <c:forEach items="${customerDealList}" var="customerDeal">
            <tr>
                <td>${customerDeal.customerDealId}</td>
                <td>${customerDeal.customer.user.lastName}</td>
                <td>${customerDeal.customer.user.firstName}</td>
                <td>${customerDeal.phoneNumber}</td>
                <td>${customerDeal.paymentMethod}</td>
                <td>${customerDeal.goodName}</td>
                <td>${customerDeal.price}</td>
                <td>${customerDeal.lotSize}</td>
                <td>${customerDeal.note}</td>
                <td><a href="/buycustdeal/${customerDeal.customerDealId}">Купить</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
