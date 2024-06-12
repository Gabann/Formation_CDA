<%@ page import="org.example.jee.ex_04.Cat" %>
<%@ page import="org.example.jee.ex_05.entity.Dog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dogList" type="java.util.ArrayList<org.example.jee.ex_05.entity.Dog>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <h1>Dog list</h1>

    <%
        if (dogList.size() < 1)
        { %>
    There are no dogs in the list
    <% }
    else
    { %>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Species</th>
                <th scope="col">DoB</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Dog dog : dogList)
                {%>
            <tr>
                <th scope="row"><%= dog.getId()%>
                </th>
                <td><%= dog.getName()%>
                </td>
                <td><%= dog.getBreed()%>
                </td>
                <td><%= dog.getDateOfBirth()%>
                </td>
                <td>

                    <a href="<%= request.getContextPath() %>/dogDetailsServlet/<%= dog.getId() %>">
                        <button class="btn-info" type="submit">Details</button>
                    </a>
                </td>
                <% } %>
            </tr>
        </tbody>
    </table>
    <% } %>
    <form name="dogForm" id="dogForm" method="post">
        <div>
            <label for="name">Name</label><input type="text" name="name" id="name">
            <label for="breed">Breed</label><input type="text" name="breed" id="breed">
            <label for="dob">Dob</label><input type="date" name="dob" id="dob">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>

</body>
</html>
<%@include file="../WEB-INF/bootstrapImport.jsp" %>
