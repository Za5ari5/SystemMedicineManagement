<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
    <%@page import="com.medmg.model.*"%>
    <%@page import="java.util.*" %>
    



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><%User user = (User) session.getAttribute("auth");
		String role = (String) session.getAttribute("role");%> 
    Welcome, My string is: <%=user.getRole() %>
    welcome , hahahahahaha <%=role %></h1>
    
    
    <% if (role.equals("admin")) { %>
    <h1>Welcome, admin!</h1>
    <p>You have access to all pages.</p>
<% } %>

<%-- Home page for user and sub-user roles --%>
<% if (role.equals("user")) { %>
    <h1>Welcome, user!</h1>
    <p>You have access to some pages.</p>
    <ul>
        <li><a href="medmanage.jsp">Profile</a></li>

    </ul>
<% } %>
 
</body>
</html>