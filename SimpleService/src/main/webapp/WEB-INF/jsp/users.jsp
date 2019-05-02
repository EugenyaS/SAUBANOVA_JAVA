<%@ page import="ru.saubanova.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Eugenya
  Date: 02.05.2019
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>First name</th>
            <th>Last Name</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User user : users) { %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
