<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="careSheetList" type="java.util.ArrayList<org.example.entity.CareSheet>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Patient details</title>
</head>
<body>
<div class="container-fluid">
    <h3>Care sheet list</h3>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Care Type</th>
                <th scope="col">Duration days</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="careSheet" items="${careSheetList}">
                <tr>
                    <td>
                            ${careSheet.id}
                    </td>
                    <td>
                            ${careSheet.careType}
                    </td>
                    <td>
                            ${careSheet.durationDays}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/careSheetDetails?id=${careSheet.id}">
                            <button>Care sheet details</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h3>Add care sheets</h3>
    <form method="post">
        <label for="care-type">Care type:
            <input type="text" id="care-type" name="care-type">
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
