<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<table>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}" /></td>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.isbn}" /></td>
            <td><c:out value="${book.pageNumber}" /></td>
            <td><c:out value="${book.publishDate}" /></td>
            <td><c:out value="${book.borrowed}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>