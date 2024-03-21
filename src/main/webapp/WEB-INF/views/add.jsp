<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 3/20/2024
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới đào</h1>
<form action="/dao/add" method="post">
    <input type="text" name="name" > <br>
    <input type="number" name="height" ><br>
    <input type="number" name="weight" ><br>
    <input type="date" name="birthday" ><br>
    <input type="number" name="price" ><br>
    <input type="submit" value="Add" >
</form>
</body>
</html>
