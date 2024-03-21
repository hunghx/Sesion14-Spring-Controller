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
    <script src="/js/ckeditor/ckeditor.js"></script>
</head>
<body>

<p class="h2 text-danger fw-bold">Thêm mới sản phẩm</p>
<div class="container text-center" >
    <form class="row g-3" action="/product/add" method="post" enctype="multipart/form-data">
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label">Name</label>
            <input type="text" class="form-control" id="inputEmail4" name="name">
        </div>
        <div class="col-md-6">
            <label for="inputPassword4" class="form-label">Image Product</label>
            <input type="file" class="form-control" id="inputPassword4" name="mainImage">
        </div>
        <div class="col-12">
            <label for="description" class="form-label">Description</label>
            <textarea name="description" id="description" cols="100" rows="10"></textarea>
        </div>
        <div class="col-md-6">
            <label for="price" class="form-label">Price</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="col-md-12">
            <label for="subImage" class="form-label">Sub Product</label>
            <input type="file" class="form-control" id="subImage" multiple name="subImage">
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
</div>
<script>
    // Replace the <textarea id="editor1"> with a CKEditor 4
    // instance, using default configuration.
    CKEDITOR.replace('description');
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
