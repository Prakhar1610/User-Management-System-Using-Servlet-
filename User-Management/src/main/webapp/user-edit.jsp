<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Edit</title>
<link rel="stylesheet" type="text/css" href="uidForm.css">
</head>
<body>
      <h1>Edit User</h1>
      <div class="user-id-form">
           <form action="user-update.jsp" method="post">
             <h2>User Id</h2>
             <br><br><br>
             <input type="text" class="input-box" id="user-id" name="id1" placeholder="Enter User Id" size="31">
             <br><br><br>
             <input type="submit" class="button" value="Enter">
           </form>
      </div>
</body>
</html>