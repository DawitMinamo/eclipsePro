<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list</title>
<link  type="text/css"
       rel="stylesheet"
       href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
<div id="wrapper">
<div id="header">
<h2> CRM Customer-Relation Management</h2>
</div>
</div>
<div id="content">
<table>
<tr>
<th>First Name</th>
<th>last Name</th>
<th>Email</th>
<th>Action</th>
</tr>

<c:forEach var="myCustomer" items="${customers}">

<c:url var="updateLink" value="customer/showformforupdate">
<c:param name="customerId" value="${myCustomer.Id}"/>
</c:url>

<tr>
<td>${myCustomer.firstName}</td>
<td>${myCustomer.lastName}</td>
<td>${myCustomer.email}</td>
<td> 
    <a href="${updateLink}"> Update </a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>