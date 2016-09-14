<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=path%>/js/jquery-1.6.4.min.js"></script>

</head>

<body>
	欢迎${username }！

	<form action="<%=path%>/fileupload!upload.action" onsubmit="checkForm()"
		enctype="multipart/form-data" method="post">
		<!--   <s:file name="upload" label="上传的文件" />  -->
		<input id="upload" type="file" value="" name="upload"> <input
			type="text" name="tt" value="123"> 
			<input type="submit" value="上传" />

	</form>
	
	<iframe name="thisPage"> 

	</iframe>
	<form id="form2" action="<%=path%>/fileupload!upload2.action"   target="thisPage"
		enctype="multipart/form-data" method="post">
		<!--   <s:file name="upload" label="上传的文件" />  -->
		<input id="upload2" type="file" value="" name="upload"> <input
			type="text" name="tt" value="123"> 
			<input type="button" value="不跳转上传" onclick="submitForm()" />

	</form>
	
	

</body>
</html>
<script type="text/javascript">
function checkForm(){
   	if($("#upload").val().length ==0){
		 alert('请选择上传文件！', '信息', 'error');
		return false;
	}  
}
//不跳转上传
function submitForm(){
	if($("#upload2").val().length ==0){
		 alert('请选择上传文件2！', '信息', 'error');
	}else{
		$("#form2").submit();
	} 
}

</script>
