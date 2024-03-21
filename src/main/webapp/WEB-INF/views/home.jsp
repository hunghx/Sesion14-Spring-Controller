<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 3/20/2024
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach Đào</h1>
<a href="/dao/add">Add new Dao</a>
<a href="/product/list">Quản lý sản sản phâm</a>
<table border="10" cellspacing="10" cellpadding="20">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Height</th>
        <th>Weight</th>
        <th>Date</th>
        <th>Price</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
<c:forEach items="${list}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.height} m</td>
        <td>${item.weight} kg</td>
        <td><fmt:formatDate value="${item.birthday}" pattern="dd/MM/yyyy"/></td>
        <td>${item.price}</td>
        <td><a href="/dao/edit/${item.id}">Edit</a></td>
        <td><a href="/dao/delete/${item.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>



<form method="post" action="/form-object" >
    <input type="text" name="id" id="id" value="${formRequest.id}"><br>
    <input type="text" name="name" id="name" value="${formRequest.name}"><br>
    <input type="submit" value="Send">
</form>
</body>
</html>
