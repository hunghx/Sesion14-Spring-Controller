<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 3/20/2024
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>cập nhật đào</h1>
<form action="/dao/update" method="post">
    <input type="text" name="id" readonly value="${dao.id}"><br>
    <input type="text" name="name" value="${dao.name}"><br>
    <input type="number" name="height" value="${dao.height}"><br>
    <input type="number" name="weight" value="${dao.weight}" ><br>
<%--    yyyy-MM-dd--%>
    <input type="date" name="birthday" value="<c:formatDate value="${dao.birthday}" pattern="yyyy-MM-dd"/>"><br>
    <input type="number" name="price" value="${dao.price}"><br>
    <input type="submit" value="Update" >
</form>
</body>
</html>
