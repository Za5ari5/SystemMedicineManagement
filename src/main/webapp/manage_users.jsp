<!DOCTYPE html>
<html lang="en">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
    <%@page import="com.medmg.model.*"%>
    <%@page import="com.medmg.db.*"%>
    <%@page import="com.medmg.dao.*"%>
    <%@page import="java.util.*" %>
    <%@page import="java.io.PrintWriter" %>
    <%@ page import="java.io.IOException" %>
    
    <%User user = (User) session.getAttribute("auth");


		String role = (String) session.getAttribute("role");
		if (user == null) {
	    	role = "";
			}
		//users selection
		UserDao ud = new UserDao(DbCnx.getConnection());
		List<User> users = ud.getAllUsers();
		//
		if (role.equals("")) {
		    try {
		        // Redirect to the specified page
		        String redirectURL = "log.jsp";
		        response.sendRedirect(redirectURL);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }	

		    
		}
		else if (role.equals("pharmacien")||role.equals("subordinate")){
		    try {
		        // Redirect to the specified page
		        String redirectURL = "admin_error.jsp";
		        response.sendRedirect(redirectURL);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		else if (role.equals("admin")){
	  
		
		%>

























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
                                <h4>Click here to add a user</h4><a class="btn btn-primary" href="adduser.jsp">Add user</a>
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
                                            <th>First name</th>
                                            <th>Last name</th>
                                            <th>Hospital</th>
                                            <th>Service</th>
                                            <th>Email</th>
                                            <th>Role</th>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>First name</th>
                                            <th>Last name</th>
                                            <th>Hospital</th>
                                            <th>Service</th>
                                            <th>Email</th>
                                            <th>Role</th>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </tfoot>
                                    
                                    
                                    <tbody>
            <% 	if (!users.isEmpty()) {
				for (User u : users) {
			%>                                    
                                    
                                        <tr>
                                            <td><%=u.getFirst_name() %></td>
                                            <td><%=u.getLast_name() %></td>
                                            <td><%=u.getMedical_facility_name() %></td>
                                            <td><%=u.getService() %></td>
                                            <td><%=u.getEmail() %></td>
                                            <td><%=u.getRole() %></td>
                                            <td><%=u.getUsername() %></td>
                                            <td><%=u.getPassword() %></td>
                                            <td><form id="myForm" action="/MedMg/DeleteUser" method="post">
    										<input type="hidden" name="del-uid" value="<%=u.getId() %>" />
    										<button class="btn btn-primary">Delete</button>
											</form></td>
                                            <td><a class="btn btn-primary" href="/MedMg/upuser.jsp?upuid=<%=u.getId() %>">
                                                Update</a></td>
                                            
                                        </tr>
                                        
                                        
                                                    <%                                        
			}
			} else {
			%>   
			
			<h1>
			<%out.println("There is no medicines");
			}
			%>  
            </h1>  
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
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
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        
    </body>
    
    <% } %>
</html>
