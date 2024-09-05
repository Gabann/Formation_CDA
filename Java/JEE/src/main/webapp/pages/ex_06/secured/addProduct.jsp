<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add hibernateProduct</title>
</head>
<body>
<div class="container-fluid">
    <form method="post" enctype="multipart/form-data">
        <label for="brand">Brand:
            <input type="text" id="brand" name="brand">
        </label>
        <label for="reference">Reference:
            <input type="text" id="reference" name="reference">
        </label>
        <label for="purchase-date">Purchase date:
            <input type="date" id="purchase-date" name="purchase-date">
        </label>
        <label for="price">Price:
            <input type="number" id="price" name="price">
        </label>
        <label for="stock">Stock:
            <input type="number" id="stock" name="stock">
        </label>
        <label for="image">Image:
            <input type="file" accept="image/*" id="image" name="image">
        </label>
        <button>Submit</button>
    </form>
</div>
</body>
</html>
<%@include file="../../../WEB-INF/bootstrapImport.jsp" %>
