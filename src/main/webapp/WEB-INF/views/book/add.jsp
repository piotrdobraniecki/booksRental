<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form"

           uri="http://www.springframework.org/tags/form" %>

<html>

<head>

  <title>Book add</title>

</head>

<body>



<%--@elvariable id="book" type="java"--%>
<form:form method="post"

           modelAttribute="book">
  Title

  <form:input path="title"/>

  <form:errors path="title"/><br/>
  Author

  <form:input path="author"/>

  <form:errors path="author"/><br/>
  PublishDate(yyyy-MM-dd)

  <form:input path="publishDate"/>

  <form:errors path="publishDate"/><br/>
  isbn

  <form:input path="isbn"/>

  <form:errors path="isbn"/><br/>
  PageNumber

  <form:input path="pageNumber"/>

  <form:errors path="pageNumber"/><br/>
  isBorrowed

  <form:input path="borrowed"/>

  <form:errors path="borrowed"/><br/>

  <input type="submit" value="Save">

</form:form>


</body>

</html>