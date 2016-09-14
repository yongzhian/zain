<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>

<title>struts2</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>

<a href="user/user!userInfo.do">toUserInfo</a>
	<s:form action="user/sysUserlogin.do" method="post"  >
		<s:label value="系统登陆"></s:label>
		<s:textfield name="username" label="账号" />
		<s:password name="password" label="密码" />
		<s:submit value="登录" />
	</s:form>
<a href="sysNode/SysNode_list.do">SysNodeList</a>
<a href="sysrole/sysrole!list.do">sysrole</a>
</body>
</html>