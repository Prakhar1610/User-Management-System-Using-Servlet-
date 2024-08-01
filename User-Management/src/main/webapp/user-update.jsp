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
<title>Update Form</title>
<link rel="stylesheet" type="text/css" href="formStyle.css">
</head>
<body>
      <%
      String id = request.getParameter("id1");
      
      try
      {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb" , "root" , "mysql@123");
		  PreparedStatement ps = con.prepareStatement("select Id,Name,Email,Country from users where Id=?");
          ps.setString(1 , id);
          
		  ResultSet rs = ps.executeQuery();
		  if(rs.next())
		  {
			  request.setAttribute("id" , rs.getString("Id"));
			  request.setAttribute("name" , rs.getString("Name"));
			  request.setAttribute("email" , rs.getString("Email"));
			  request.setAttribute("country" , rs.getString("Country"));
		  }
		  else
		  {
			  response.setContentType("text/html");
			  out.print("<h3 style='color:red'>User of this id doesn't exist in the database</h3>");
		  }
      }
      catch (Exception e) 
	  {
		  e.printStackTrace();
	  }
      %>
      <div class="form-container">
           <h2>Update User Form</h2>
           <br>
           
           <form action="update" method="post">
                
            <div class="id-label">
                 <label>Id :</label>
                 <br>
                 <input type="text" name="id2" value="${id}" size="31" readonly/>
                 <br><br>
            </div>
            
            <div class="name-label">
                 <label>Name :</label>
                 <br>
                 <input type="text" name="name2" value="${name}" size="31"/>
                 <br><br>
            </div>
            
            <div class="email-label">
                 <label>Email :</label>
                 <br>
                 <input type="text" name="email2" value="${email}" size="31"/>
                 <br><br>
            </div>
            
            <div class="country-label">
                 <label>Country :</label>
                 <br>
                 <input type="text" name="country2" value="${country}" size="31"/>
                 <br><br><br>
            </div>
            
            <input type="submit" class="btn" value="Update" />
            </form>
      </div> 
</body>
</html>