<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 26.09.2023
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of  Opinions</title>
</head>
<body>
<table>
  <h1>All opinion</h1>
  <tr>
    <td>Id </td><td>Text </td><td>Book </td><td>User </td><td>Rating </td>
  </tr>

  <c:forEach items="${opinions}" var="opinion">
    <tr>
      <td><c:out value="${opinion.id}" /></td>
      <td><c:out value="${opinion.text}" /></td>
      <td><c:out value="${opinion.book.title}" /></td>
      <td><c:out value="${opinion.user.fullName}" /></td>
      <td><c:out value="${opinion.rating }" /></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
