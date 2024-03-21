<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 3/21/2024
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Chi tiết Sp</h1>
<h3>${pro.name}</h3>
<div>
    ${pro.description}
</div>
<p>${pro.price}</p>
<img src="${pro.imageUrl}" width="300" height="300" style="object-fit: cover"> <br>

<h4>Danh sách ảnh phụ</h4>
<c:forEach items="${pro.imageList}" var="image">
    <img src="${image.url}" width="100" height="100" style="object-fit: cover">
</c:forEach>
</body>
</html>
