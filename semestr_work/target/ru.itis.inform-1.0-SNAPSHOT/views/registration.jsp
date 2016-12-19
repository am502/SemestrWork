<%--
  Created by IntelliJ IDEA.
  User: anteg
  Date: 18.12.2016
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Заполните все поля</h2>
    <form action="" method="post">
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="username">Никнейм:</label>
                <input type="text" pattern="[0-9a-zA-Z]*" id="username" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" pattern="[0-9a-zA-Z]*" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="firstName">Имя:</label>
                <input type="text" pattern="[a-zA-Z]*" id="firstName" name="firstName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="lastName">Фамилия:</label>
                <input type="text" pattern="[a-zA-Z]*" id="lastName" name="lastName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Номер телефона:</label>
                <input type="text" pattern="[1-9][0-9]{10}" id="phoneNumber" name="phoneNumber" class="form-control"
                       required>
            </div>
            <div class="form-group">
                <select name="status" required>
                    <option value="cust">Покупатель</option>
                    <option value="vend">Продавец</option>
                </select>
            </div>
        </div>
        <input type="submit" value="Регистрация" class="btn btn-primary">
    </form>
</div>
</body>
</html>
