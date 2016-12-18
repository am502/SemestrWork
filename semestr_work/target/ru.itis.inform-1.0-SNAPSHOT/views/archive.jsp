<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Archive</title>

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
            <th>Id продавца</th>
            <th>Id покупателя</th>
            <th>Имя товара</th>
            <th>Дата продажи</th>
            <th>Цена сделки</th>
            <th>Комментарий</th>
        </tr>

        <c:forEach items="${archive}" var="arc">
            <tr>
                <td>${arc.vendorId}</td>
                <td>${arc.customerId}</td>
                <td>${arc.goodName}</td>
                <td>${arc.sellDate}</td>
                <td>${arc.price}</td>
                <td>${arc.comment}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
