<%page import="proy_ing.DBManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	DBManager db = new DbManager();
	Connection conn = db.getConnection();
	if(conn == null){
		out.print("connection failled");
	}
	else{
		out.print("connection succeded");
	}
%>
</body>
</html>