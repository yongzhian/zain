<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();

    Map<String, Object> attributes = principal.getAttributes();
    for (String key : attributes.keySet()) {
        System.out.println(key + "/" + attributes.get(key));
    }
%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
