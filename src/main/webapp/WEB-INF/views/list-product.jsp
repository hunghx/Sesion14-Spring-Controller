<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 3/21/2024
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<p class="h2 text-danger fw-bold">Danh sách sản phẩm</p>
<a href="">Add product</a>

<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Name</th>
        <th scope="col">Image</th>
        <th scope="col">Price</th>
        <th scope="col">Status</th>
        <th scope="col" colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
   <c:forEach items="${products}" var="pro" varStatus="loop">
       <tr>
           <td>${loop.count}</td>
           <td>${pro.name}</td>
           <td><img src="${pro.imageUrl}" alt="${pro.name}" width="100" height="100" style="border-radius: 100%; object-fit: cover"></td>
           <td>${pro.price}</td>
           <td>${pro.status?"Active":"Inactive"}</td>
           <td><a href="" class="btn btn-warning">Edit</a></td>
           <td><a href="/product/detail/${pro.id}" class="btn btn-primary">Detail</a></td>
           <td><a href="" class="btn btn-danger">Delete</a></td>
       </tr>

   </c:forEach>

    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
