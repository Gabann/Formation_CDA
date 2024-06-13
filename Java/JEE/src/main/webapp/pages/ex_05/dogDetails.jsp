<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="pathInfo" type="java.lang.String" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<% System.out.println(request.getParameter("dog "));
    if (request.getAttribute("dog") == null)
    { %>
Dog with id <%= pathInfo %> does not exist.
<% }
else
{%>
<jsp:useBean id="dog" type="org.example.jee.ex_05.entity.Dog" scope="request"/>
Id: <%= dog.getId() %><br>
Name: <%= dog.getName() %><br>
Breed: <%= dog.getBreed() %><br>
DoB: <%= dog.getDateOfBirth() %><br>
<%} %>
</body>
</html>
<%@include file="../../WEB-INF/bootstrapImport.jsp" %>
