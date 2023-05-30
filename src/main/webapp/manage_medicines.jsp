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
		
		//medicines
		MediDao md = new MediDao(DbCnx.getConnection());
		List<Medicine> medicines = md.getAllMedicines();
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
		
		else {





%>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Charts - SB Admin</title>
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
                        <h1 class="mt-4">Medicine</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">All Medicine</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <h4>Click here to add a medicine</h4><a class="btn btn-primary" href="addmedicine.jsp">Add medicine</a>
                                <h4>Click here to export medicines as excel file</h4><a class="btn btn-primary" href="/MedMg/ExportData">Export</a>
                                .
                         </div>
                         </div>




						<div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                The newest medicine
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Type</th>
                                            <th>Category</th>
                                            <th>Production Date</th>
                                            <th>Expiration Date</th>
                                            <th>Quantity</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Type</th>
                                            <th>Category</th>
                                            <th>Production Date</th>
                                            <th>Expiration Date</th>
                                            <th>Quantity</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </tfoot>
                                      <tbody>      
            <% 	if (!medicines.isEmpty()) {
				for (Medicine m : medicines) {
			%>
                                <!-- upmid == null  -->  
                                    
                                        <tr>
                                            <td><%=m.getName() %></td>
                                            <td><%=m.getType() %></td>
                                            <td><%=m.getCategory() %></td>
                                            <td><%=m.getProduction_date() %></td>
                                            <td><%=m.getExpiration_date() %></td>
                                            <td><%=m.getQuantity() %></td>
                                            
                                            <td><form id="myForm" action="/MedMg/DeleteMedicine" method="post">
    										<input type="hidden" name="del-mid" value="<%=m.getId() %>" />
    										<button class="btn btn-primary">Delete</button>
											</form></td>
                                            <td><a class="btn btn-primary" href="/MedMg/upmedicine.jsp?upmid=<%=m.getId() %>">Update</a></td>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
    <% } %>
</html>
