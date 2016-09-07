<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">

    <title>struts1范例</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
</head>
<body>
<h1>
    <bean:message key="hello.struts1.title"/>
</h1>
<div style="border-left: 20px;font-size: 20px;">
    <html:errors property="err_msg"/>
    <html:form action="/login.do">
        <label style="color: #006600;margin-right: 3px">用户名</label><html:text property="userName"></html:text>
        <br/><br>
        <label style="color: #006600;margin-right: 3px">密码</label><html:password property="password"></html:password>
        <html:submit property="submit" value="提交"></html:submit>
    </html:form>
</div>
<div style="border-left: 20px;font-size: 24px;">
    <a href="userinfo.do?username=struts1">userinfo<br><br>
</div>

<div style="border-left: 20px;font-size: 24px;">
    <a href="changelog.html"><bean:message key="hello.struts1.changelog"/></a><br><br>
    Copyrights for zain
</div>

</body>
</html>
