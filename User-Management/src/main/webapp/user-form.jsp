<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
<link rel="stylesheet" type="text/css" href="formStyle.css">
</head>
<body>
      <div class="form-container">
           <h2>New User Form</h2>
           <br>
           <form action="form" method="post">
           
                <div class="id-label">
                     <label>Id :</label>
                     <br>
                     <input type="text" name="id1" placeholder="Enter User Id" size="31"/>
                     <br><br>
                </div>
                
                <div class="name-label">
                     <label>Name :</label>
                     <br>
                     <input type="text" name="name1" placeholder="Enter Username" size="31"/>
                     <br><br>
                </div>
                
                <div class="email-label">
                     <label>Email :</label>
                     <br>
                     <input type="text" name="email1" placeholder="Enter User Email" size="31"/>
                     <br><br>
                </div>
                
                <div class="country-label">
                     <label>Country :</label>
                     <br>
                     <input type="text" name="country1" placeholder="Enter User Country" size="31"/>
                     <br><br><br>
                </div>
                
                <input type="submit" class="btn" value="Add" />
       </form>
      </div>
</body>
</html>