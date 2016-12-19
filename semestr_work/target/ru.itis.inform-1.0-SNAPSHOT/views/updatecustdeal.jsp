<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update deal</title>

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
    <h2>Введите новые значения</h2>
    <form action="" method="post">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="goodName">Товар:</label>
                <input type="text" pattern="[a-zA-Z]*" id="goodName" name="goodName" class="form-control">
            </div>
            <div class="form-group">
                <label for="lotSize">Объем покупки:</label>
                <input type="text" pattern="[]|([1-9][0-9]*)" id="lotSize" name="lotSize" class="form-control">
            </div>
            <div class="form-group">
                <label for="price">Цена:</label>
                <input type="text" pattern="[]|([1-9][0-9]*)" id="price" name="price" class="form-control">
            </div>
            <div class="form-group">
                <label for="paymentMethod">Способ оплаты:</label>
                <input type="text" pattern="[a-zA-Z]*" id="paymentMethod" name="paymentMethod" class="form-control">
            </div>
            <div class="form-group">
                <label for="note">Примечание:</label>
                <input type="text" pattern="[a-zA-Z]*" id="note" name="note" class="form-control">
            </div>
        </div>
        <br>
        <input type="submit" value="Изменить" class="btn btn-primary">
    </form>
</div>
</body>
</html>
