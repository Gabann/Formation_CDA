<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<div class="container-fluid">
    <form method="post">
        <label for="name">Username:
            <input type="text" id="name" name="username">
        </label>
        <label for="password">Password:
            <input type="password" id="password" name="password">
        </label>
        <button>Submit</button>
    </form>
</div>
</body>
</html>
<%@include file="../WEB-INF/bootstrapImport.jsp" %>
