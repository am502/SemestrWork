<%--
  Created by IntelliJ IDEA.
  User: anteg
  Date: 19.12.2016
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet"
</head>
<body>
<div class="container">
    <p class="text-center"><h1>This nickname is already exist</h1></p>
    <form>
        <input type="button" class="btn btn-primary" value="Вернуться"
               onclick=location.href="/registration">
    </form>
</div>
</body>
</html>
