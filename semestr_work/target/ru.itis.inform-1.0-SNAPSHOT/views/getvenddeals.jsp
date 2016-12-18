<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 15.12.2016
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vendor deal</title>

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
    <h3>
        №: ${vendorDeal.vendorDealId}<br>
        Способ оплаты: ${vendorDeal.paymentMethod}<br>
        Товар: ${vendorDeal.goodName}<br>
        Цена:${vendorDeal.price}<br>
        Объем партии при оптовой продаже: ${vendorDeal.lotSizeWholesale}<br>
        Условие продажи-отгрузки: ${vendorDeal.conditionsSale}<br>
        Примечание: ${vendorDeal.note}<br>
    </h3>
    <form action="" method="post">
        <input type="submit" class="btn btn-primary" value="Удалить">
    </form>
    <input type="button" class="btn btn-primary" value="Изменить" onclick=location.href="/updatevenddeal/${vendorDeal.vendorDealId}">
</div>
</body>
</html>
