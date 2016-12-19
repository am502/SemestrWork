<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 14.12.2016
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add vendor deal</title>

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
    <h2>Заполните все поля</h2>
    <form action="addvenddeal" method="post">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="goodName">Товар:</label>
                <input type="text" pattern="[]|(([a-zA-Z]+ ?)*[a-zA-Z]+)" id="goodName" name="goodName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="lotSizeWhole">Объем партии при оптовой продаже:</label>
                <input type="text" pattern="[1-9][0-9]*" id="lotSizeWhole" name="lotSizeWhole" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="price">Цена:</label>
                <input type="text" id="price" pattern="[1-9][0-9]*" name="price" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="paymentMethod">Способ оплаты:</label>
                <input type="text" id="paymentMethod" pattern="[]|(([a-zA-Z]+ ?)*[a-zA-Z]+)" name="paymentMethod" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="conditionsSale">Условие продажи-отгрузки:</label>
                <input type="text" id="conditionsSale" pattern="[]|(([a-zA-Z]+ ?)*[a-zA-Z]+)" name="conditionsSale" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="note">Примечание:</label>
                <input type="text" id="note" name="note" pattern="[]|(([a-zA-Z]+ ?)*[a-zA-Z]+)" class="form-control" required>
            </div>
        </div>
        <br>
        <input type="submit" value="Добавить" class="btn btn-primary">
    </form>
</div>
</body>
</html>
