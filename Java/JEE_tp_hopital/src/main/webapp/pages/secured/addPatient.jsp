<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add patient</title>
</head>
<body>
<div class="container-fluid">
    <form method="post" enctype="multipart/form-data">
        <label for="first-name">First name:
            <input type="text" id="first-name" name="first-name">
        </label>
        <label for="last-name">Last name:
            <input type="text" id="last-name" name="last-name">
        </label>
        <label for="birth-date">Birth date:
            <input type="date" id="birth-date" name="birth-date">
        </label>
        <label for="photo">Photo:
            <input type="file" accept="image/*" id="photo" name="photo">
        </label>
        <button>Submit</button>
    </form>
</div>
</body>
</html>
<%@include file="../../WEB-INF/bootstrapImport.jsp" %>
