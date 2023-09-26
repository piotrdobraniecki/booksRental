<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of books</title>
</head>
<body>
<table>
    <h1>All books</h1>
    <tr>
        <td>Id </td><td>Title </td><td>Author </td><td>publishDate </td><td>Isbn </td><td>pageNumber </td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}" /></td>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.publishDate}" /></td>
            <td><c:out value="${book.isbn}" /></td>
            <td><c:out value="${book.pageNumber}" /></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>