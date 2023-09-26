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
<%--@elvariable id="opinion" type="java"--%>
<form:form method="post" modelAttribute="opinion">



    <h1>Add opinion</h1>
<%--    <form:hidden path="id" />--%>
    <br>
    <form:select path="book">
<%--        <form:option value="" label="-- select book --"/>--%>
        <form:options items="${books}" itemValue="id" itemLabel="title"/>
    </form:select>
    <form:errors path="book"/>
    <form:select path="user">
<%--        <form:option value="" label="-- select user --"/>--%>
        <form:options items="${users}" itemValue="id" itemLabel="fullName"/>

    </form:select>
    <form:errors path="user"/>
    <form:select path="rating">
<%--        <form:option value="" label=" 1-10"/>--%>
        <form:option value="1" label=" 1"/>
        <form:option value="2" label=" 2"/>
        <form:option value="3" label=" 3"/>
        <form:option value="4" label=" 4"/>
        <form:option value="5" label=" 5"/>
        <form:option value="6" label=" 6"/>
        <form:option value="7" label=" 7"/>
        <form:option value="8" label=" 8"/>
        <form:option value="9" label=" 9"/>
        <form:option value="10" label=" 10"/>

    </form:select>
    <form:errors path="rating"/>
    <form:input path="text"/>
    <form:errors path="text"/>
    <input type="submit" value="Add">



</form:form>


</body>
</html>
