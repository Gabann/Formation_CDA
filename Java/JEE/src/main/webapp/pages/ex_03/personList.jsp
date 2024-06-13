<%@ page import="org.example.jee.ex_03.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="personList" type="java.util.ArrayList<org.example.jee.ex_03.Person>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Age</th>
            </tr>
        </thead>
        <tbody>
            <%
                int index = 1;
                for (Person person : personList)
                {%>
            <tr>
                <th scope="row"><%= index%>
                </th>
                <td><%= person.getFirstName()%>
                </td>
                <td><%= person.getLastName()%>
                </td>
                <td><%= person.getAge()%>
                </td>

            </tr>
            <%
                    index++;
                }
            %>
        </tbody>
    </table>
</div>
</body>
</html>
<%@include file="../../WEB-INF/bootstrapImport.jsp" %>
