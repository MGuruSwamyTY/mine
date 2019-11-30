<%@page import="com.tyss.tysslibrary.dto.Books"%>
<%@ page import="com.tyss.tysslibrary.dto.Librarian" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Librarian librarian = (Librarian) session.getAttribute("librarin");
Books books = (Books) session.getAttribute("bName");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body>
	<div align="right">
		<span><a href="./addbook">Update profile</a></span> 
		<span><a href= "./deletebook?bId=<%=books.getbId()%>">Delete book</a></span> 
		<span><a href="./getallbooks">GetAllBooks</a></span>
		<span><a href="./searchbooks?bName=<%=books.getbName()%>">Searchbooks</a></span>
	</div>
	<h1>Welcome <%=librarian.getName()%></h1>
	<h2>${msg}</h2>
</body>
</html>