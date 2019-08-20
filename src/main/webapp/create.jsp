<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/create" method="post">
    <h1>Register</h1>
    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required><br><br>

    <label for="userName"><b>UserName</b></label>
    <input type="text" placeholder="Enter username" name="userName" required><br><br>

    <label for="password"><b>Enter Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br><br>
    
    <label for="phoneNo"><b>Enter Phone number</b></label>
    <input type="text" placeholder="Enter phoneNo" name="phoneNo" required><br><br>
    
    <label for="PAN"><b>Enter PAN</b></label>
    <input type="text" placeholder="PAN" name="PAN" required><br><br>
    
    
    <button type="submit">Register</button>

</form>
</body>
</html>