<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/login" method="post">
        UserName: <input type="text" name="username" placeholder="Enter your username">
        Password: <input type="password" name="password" placeholder="Enter your password">

        <button type="submit">Login</button>
    </form>
</body>
</html>