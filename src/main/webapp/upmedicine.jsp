<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@page import="com.medmg.model.*"%>
    <%@page import="java.util.*" %>
    <%@page import="java.io.PrintWriter" %>
    <%@ page import="java.io.IOException" %>
   
    <%
    // pass the id of the medicine who we want update
    String upmid = request.getParameter("upmid");
    //request.setAttribute("upmid", upmid);

    // recive role and define user roles
    User user = (User) session.getAttribute("auth");
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

                                        
          <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Update Medicine</h3></div>
                                    <div class="card-body">
                                        <form  action="/MedMg/UpdateMedicine" method="post">
                                            
                                            
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputName" type="text" placeholder="Enter Medicine Name" name="new-medname"/>
                                                        <label for="inputName">Medicine Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inpuType" type="text" placeholder="Enter the Type" name=new-medtype />
                                                        <label for="inpuType">Type</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                                                                        
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputCategory" type="text" placeholder="Enter the Category" name="new-medcategory"/>
                                                        <label for="inputCategory">Category</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputPrDate" type="text" placeholder="Enter the Production Date" name="new-medprodate" />
                                                        <label for="inputPrDate">Production Date</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputExpDate" type="text" placeholder="Enter the Expiration Date" name="new-medexpdate"/>
                                                        <label for="inputExpDate">Expiration Date</label>
                                                    </div>
                                                </div>
                                                
                      							<div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputQuantity" type="text" placeholder="Enter Quantity" name="new-medquantity" />
                                                        <label for="inputQuantity">Quantity</label>
                                                    </div>
                                                </div>
                                                <input type="hidden" name="id" value="<%= upmid %>" />
                                                </div>
               
                                            
                       
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block">Update Medicine</button></div>
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