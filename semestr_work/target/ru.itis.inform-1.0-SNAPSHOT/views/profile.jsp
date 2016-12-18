<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
<div class="jumbotron">
    <h1><p class="text-center">${lastName} ${firstName}</p></h1>
    <h1><p class="text-center">Статус: ${status}</p></h1>
</div>
<div class="container">
    <form>
        <input type="button" class="btn btn-primary" value="Показать всех покупателей"
               onclick=location.href="/customers">
    </form>
    <form>
        <input type="button" class="btn btn-primary" value="Показать всех продавцов" onclick=location.href="/vendors">
    </form>
    <form>
        <input type="button" class="btn btn-primary" value="Посмотреть архив" onclick=location.href="/archive">
    </form>
    <c:choose>
        <c:when test="${status=='Покупатель'}">
            <form>
                <input type="button" class="btn btn-primary" value="Показать предложения продавцов"
                       onclick=location.href="/vendordeals">
            </form>
            <form>
                <input type="button" class="btn btn-primary" value="Создать предложение"
                       onclick=location.href="/addcustdeal">
            </form>
            <form>
                <input type="button" class="btn btn-primary" value="Показать ваши объявления"
                       onclick=location.href="/yourcustomerdeals">
            </form>
            <form>
                <input type="button" class="btn btn-primary" value="Изменить профиль"
                       onclick=location.href="/updatecustomer">
            </form>
        </c:when>
        <c:otherwise>
            <form>
                <input type="button" class="btn btn-primary" value="Показать предложения покупателей"
                       onclick=location.href="/customerdeals">
            </form>
            <form>
                <input type="button" class="btn btn-primary" value="Создать предложение"
                       onclick=location.href="/addvenddeal">
            </form>
            <form>
                <input type="button" class="btn btn-primary" value="Показать ваши объявления"
                       onclick=location.href="/yourvendordeals">
            </form>
            <form>
                <input type="button" class="btn btn-primary" value="Изменить профиль"
                       onclick=location.href="/updatevendor">
            </form>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
