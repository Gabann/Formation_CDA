<%@ page import="org.example.jee.ex_04.Cat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="catList" type="java.util.ArrayList<org.example.jee.ex_04.Cat>" scope="request"/>
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
                <th scope="col">Name</th>
                <th scope="col">Species</th>
                <th scope="col">Favorite Meal</th>
                <th scope="col">DoB</th>
            </tr>
        </thead>
        <tbody>
            <%
                int index = 1;
                for (Cat cat : catList)
                {%>
            <tr>
                <th scope="row"><%= index%>
                </th>
                <td><%= cat.getName()%>
                </td>
                <td><%= cat.getSpecies()%>
                </td>
                <td><%= cat.getFavoriteMeal()%>
                </td>
                <td><%= cat.getBirthDate()  %>
                </td>

            </tr>
            <%
                    index++;
                }
            %>
        </tbody>
    </table>

    <form name="catForm" id="catForm" method="post">
        <div>
            <label for="name">Name</label><input type="text" name="name" id="name">
            <label for="species">Species</label><input type="text" name="species" id="species">
            <label for="favorite-meal">Favorite meal</label><input type="text" name="favorite-meal" id="favorite-meal">
            <label for="dob">Dob</label><input type="date" name="dob" id="dob">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
<%@include file="../../WEB-INF/bootstrapImport.jsp" %>
