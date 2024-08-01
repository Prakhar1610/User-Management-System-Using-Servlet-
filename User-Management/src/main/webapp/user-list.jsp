<%@page import="javax.swing.border.AbstractBorder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of User</title>
<link rel="stylesheet" type="text/css" href="user-listStyle.css">
</head>
<body>      
      <h1>USER LIST</h1>
            
      <div class="add-button">
           <button type="button" onclick="window.location.href='user-form.jsp';">Add User</button>
      </div>
      
      <div class="select-button">
           <button type="button" onclick="window.location.href='user-select.jsp';">View User</button>
      </div>
      
      <div class="delete-button">
           <button type="button" onclick="window.location.href='user-delete.jsp';">Remove User</button>
      </div>
      
      <div class="update-button">
           <button type="button" onclick="window.location.href='user-edit.jsp';">Edit User</button>
      </div>
      
      
      
      
      
            <form action="list" method="post">
            
                  
                  <table class="table" >
                   <thead>
                          <tr>
                              <th>Id</th>
                              <th>Name</th>
                              <th>Email</th>
                              <th>Country</th>
                          </tr> 
                   </thead>
                    
                    <tbody>
                    <%
                      try
                      {
                    	  Class.forName("com.mysql.cj.jdbc.Driver");
                    	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb" , "root" , "mysql@123");
                    	  PreparedStatement ps = con.prepareStatement("select * from users");
                    	  ResultSet rs = ps.executeQuery();
                          int i=1;
                    	  while(rs.next())
                    	  {
                     %>		 
                               <% 
                               if(i%2==0)
                               {
                            	%>
                            	<tr class="active-row">
                                   <td><%=rs.getString("Id") %></td>
                                   <td><%=rs.getString("Name") %></td>
                                   <td><%=rs.getString("Email") %></td>
                                   <td><%=rs.getString("Country") %></td>
                               </tr>
                               <%}
                               else
                               {
                            	%>
                            	<tr>
                                   <td><%=rs.getString("Id") %></td>
                                   <td><%=rs.getString("Name") %></td>
                                   <td><%=rs.getString("Email") %></td>
                                   <td><%=rs.getString("Country") %></td>
                               </tr>
                               
                            <% 	   
                               }
                               %>
                               
                               <%i++; %>
                     <%       
                    	  }
                     %>  
                     </tbody>
               </table>
            
                    <%
                       
                      }
                      catch (Exception e) 
            		  {
                    	  e.printStackTrace();
            		  }
                    %>
                 
                  
      </form>
      
</body>
</html>