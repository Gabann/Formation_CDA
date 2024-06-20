<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="medsList" type="java.util.ArrayList<org.example.entity.Meds>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Care sheet details</title>
</head>
<body>
<div class="container-fluid">
    <h3>Meds list</h3>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Meds type</th>
                <th scope="col">Duration days</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="med" items="${medsList}">
                <tr>
                    <td>
                            ${med.id}
                    </td>
                    <td>
                            ${med.medsType}
                    </td>
                    <td>
                            ${med.durationDays}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h3>Add meds</h3>
    <form method="post">
        <label for="meds-type">Meds type:
            <input type="text" id="meds-type" name="meds-type">
        </label>
        <label for="duration">Duration in days:
            <input type="number" id="duration" name="duration">
        </label>
        <button>Submit</button>
    </form>
</div>
</body>
</html>
<%@include file="../../WEB-INF/bootstrapImport.jsp" %>
