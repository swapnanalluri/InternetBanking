<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/create">Register New User</a>
<table border="1">
    <tr>
        <th>Name</th>
        <th> Phone Number</th>
        <th>Pan</th>


    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.phoneNo}</td>
            <td>${customer.PAN}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>