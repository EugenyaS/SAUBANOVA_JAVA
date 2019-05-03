<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form action="/users" method="post">
        <input type="text" name="firstName">
        <input type="text" name="lastName">
        <input type="submit" value="Add">
    </form>
</div>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>First name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
