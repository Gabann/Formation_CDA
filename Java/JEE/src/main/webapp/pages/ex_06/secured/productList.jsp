<%@ page import="org.example.jee.ex_06.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="productList" type="java.util.ArrayList<org.example.jee.ex_06.entity.Product>" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product list</title>
</head>
<body>
<%
    if (productList.isEmpty())
    { %>
There are no products in the list
<% }
else
{ %>
<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Brand</th>
            <th scope="col">Reference</th>
            <th scope="col">Purchase date</th>
            <th scope="col">Price</th>
            <th scope="col">Stock</th>
            <th scope="col">Image</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Product product : productList)
            {%>
        <tr>
            <th scope="row"><%= product.getId()%>
            </th>
            <td><%= product.getBrand()%>
            </td>
            <td><%= product.getReference()%>
            </td>
            <td><%= product.getPurchaseDate()%>
            </td>
            <td><%= product.getPrice()%>
            </td>
            <td><%= product.getStock()%>
            </td>
            <td><img style="max-width: 100%; max-height: 20vh" src="${pageContext.request.contextPath}/assets/images/<%=
            product.getImagePath()%>"
                     alt="product visual">
            </td>
            <% } %>
            <% } %>
        </tr>
    </tbody>
</table>
</body>
</html>
<%@include file="../../../WEB-INF/bootstrapImport.jsp" %>
