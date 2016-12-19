<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 15.12.2016
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update profile</title>

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
    <form action="updatecustomer" method="post">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="lastName">Фамилия:</label>
                <input type="text" pattern="[a-zA-Z]*" id="lastName" name="lastName" class="form-control">
            </div>
            <div class="form-group">
                <label for="firstName">Имя:</label>
                <input type="text" pattern="[a-zA-Z]*" id="firstName" name="firstName" class="form-control">
            </div>
            <div class="form-group">
                <label for="phone">Телефон:</label>
                <input type="text" id="phone" pattern="[]|([1-9][0-9]{10})" name="phone" class="form-control">
            </div>
        </div>
        <br>
        <input type="submit" value="Изменить" class="btn btn-primary">
    </form>
</div>
</body>
</html>
