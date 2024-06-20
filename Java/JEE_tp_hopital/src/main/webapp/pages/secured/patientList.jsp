<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="patientList" type="java.util.ArrayList<org.example.entity.Patient>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Patient list</title>
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Birth date</th>
                <th scope="col">Photo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${patientList}">
                <tr>
                    <td>
                            ${patient.id}
                    </td>
                    <td>
                            ${patient.firstName}
                    </td>
                    <td>
                            ${patient.lastName}
                    </td>
                    <td>
                            ${patient.birthDate}
                    </td>
                    <td>
                        <img style="max-width: 100%; max-height: 20vh"
                             src="${pageContext.request.contextPath}/assets/images/${patient.imagePath}" alt="patient photo">
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
<%@include file="../../WEB-INF/bootstrapImport.jsp" %>
