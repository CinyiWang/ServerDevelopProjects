<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>景区网站管理员登录</title>
</head>

<body>
<c:if test="${!empty error}">
    <font color="red"><pre style="font-size:16px"><c:out value="${error.getMessage()}"/></pre></font>
</c:if>
<form action="<c:url value="/admin/loginCheck.html"/>" method="post" commandName="LoginInfo">
    用户名：
    <input type="text" name="userName">
    <br>
    密 码：
    <input type="password" name="password">
    <br>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
