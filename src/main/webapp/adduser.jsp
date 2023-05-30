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
                      <div id="layoutSidenav_content">
                <main>  
<h1>this is add users page</h1>
                                        
          <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Add a New User</h3></div>
                                    <div class="card-body">
                                        <form  action="/MedMg/Adduser" method="post">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputFirstName" type="text" placeholder="Enter First name" name="new-fname"/>
                                                        <label for="inputFirstName">First name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputLastName" type="text" placeholder="Enter Last name" name="new-lname" />
                                                        <label for="inputLastName">Last name</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputFirstName" type="text" placeholder="Enter the hospital" name="new-mfn"/>
                                                        <label for="inputFirstName">Hospital</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputLastName" type="text" placeholder="Enter the service" name="new-service" />
                                                        <label for="inputLastName">Service</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputEmail" type="Email" placeholder="Enter Email" name="new-email"/>
                                                        <label for="inputEmail">Email</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputRole" type="text" placeholder="Enter Role" name="new-role"/>
                                                        <label for="inputRole">Role</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputUsername" type="text" placeholder="Enter Username" name="new-username" />
                                                        <label for="inputUsername">Username</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputPassword" type="password" placeholder="Enter Password" name="new-password" />
                                                        <label for="inputPassword">Password</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block">Add New User</button></div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
                                        
                                        
                                        
                                       <% } %>                                        
</html>