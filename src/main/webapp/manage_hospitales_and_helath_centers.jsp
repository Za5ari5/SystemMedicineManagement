<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@page import="com.medmg.model.*"%>
    <%@page import="java.util.*" %>
    <%@page import="java.io.PrintWriter" %>
    <%@ page import="java.io.IOException" %>
   
    <%User user = (User) session.getAttribute("auth");
		String role = (String) session.getAttribute("role");
		if (user == null) {
	    	role = "";
			}
		if (role.equals("")) {
		    try {
		        // Redirect to the specified page
		        String redirectURL = "log.jsp";
		        response.sendRedirect(redirectURL);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		else if (role.equals("user")){
			try {
		        // Redirect to the specified page
		        String redirectURL = "admin_error.jsp";
		        response.sendRedirect(redirectURL);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }		
		}
		
		else if (role.equals("admin")){%>
		
		
		<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
       
       
         <%@ include file = "navbar.jsp" %>
         <div id="layoutSidenav">
         <%@include file = "sidebar.jsp" %>       
       
       <h1>This is manage hospitales page</h1>
       
       
       
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Users</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Users</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <h4>Click here to add a user</h4><a class="btn btn-primary" href="#">Add user</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>User</th>
                                            <th>Post</th>
                                            <th>Email</th>
                                            <th>Password</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>User</th>
                                            <th>Post</th>
                                            <th>Email</th>
                                            <th>Password</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>Tiger Nixon</td>
                                            <td>System Architect</td>
                                            <td>Edinburgh</td>
                                            <td>61</td>
                                            <td><a class="btn btn-primary" href="#">Delete</a></td>
                                            <td><a class="btn btn-primary" href="#">Update</a></td>
                                        </tr>
                                        <tr>
                                            <td>Garrett Winters</td>
                                            <td>Accountant</td>
                                            <td>Tokyo</td>
                                            <td>63</td>
                                            <td><a class="btn btn-primary" href="#">Delete</a></td>
                                            <td><a class="btn btn-primary" href="#">Update</a></td>
                                        </tr>
                                        
                                        
                                        
                                        
                                        
                                        
                                       <% } %>      
                                  <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
                                       

                               
</html>