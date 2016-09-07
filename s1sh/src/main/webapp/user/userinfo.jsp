<%--
  Created by IntelliJ IDEA.
  User: Zain
  Date: 2016/9/3
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user info</title>
</head>
<body style="margin: 10px;font-size: 20px ">
username: ${user.username}<br>
passwd:${user.password}<br>
${sysNode.nodeName}<br>
遍历Set:
<c:choose>
    <c:when test="${user.roles == null  }">
        null
    </c:when>
    <c:otherwise>
        <c:forEach var="entry" items="${user.roles}">
            ${entry}
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
