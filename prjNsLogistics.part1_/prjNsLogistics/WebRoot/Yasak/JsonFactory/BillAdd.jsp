<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.struts.form.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'BillAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>&nbsp; 
    <%
		String state= request.getAttribute("Yasak_BillAdd").toString();
		String Json="{success:";
		if(state.equals("true")){
			Json+="true";
		}else{
			Json+="false";
		}
		Json+="}";
		System.out.println(Json);
		response.getWriter().write(Json);
		response.getWriter().close();
	 %>
  </body>
</html>
