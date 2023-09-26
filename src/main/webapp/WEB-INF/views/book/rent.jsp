<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 25.09.2023
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form"

           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rent a book</title>
</head>
<body>
<%--@elvariable id="book" type="java"--%>
<%--@elvariable id="borrowedBook" type="java"--%>
<form:form method="post" modelAttribute="borrowedBook">


    <h1>Rent a book</h1>

    <form:hidden path="id" />
    <br>
    <form:select path="book">
        <form:option value="" label="-- select book --"/>
        <form:options items="${AvailableBook}" itemValue="id" itemLabel="title"/>
    </form:select>
    <form:select path="user">
        <form:option value="" label="-- select user --"/>
        <form:options items="${users}" itemValue="id" itemLabel="fullName"/>
    </form:select>
    <input type="submit" value="Rent">
</form:form>
</body>
</html>
