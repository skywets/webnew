<%--
  Created by IntelliJ IDEA.
  User: ozodbek
  Date: 25.12.2021
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>ID</th>
    <th>Имя</th>
    <th>Адрес</th>
    <th>количество страниц</th>
    <th>Дата выпуска</th>
    <th>Автор</th>
    <th>Число</th>
    <th> </th>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.getnumId()}</td>
            <td>${item.getTitle()}</td>
            <td>${item.getPublishingHouse()}</td>
            <td>${item.getNumbeOfPages()}</td>
            <td>${item.getDataOfIssue()}</td>
            <td>${item.getAuthor()}</td>
            <td>${item.getNumber()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
