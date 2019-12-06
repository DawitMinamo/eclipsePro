<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link  type="text/css"
       rel="stylesheet"
       href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2> CRM Customer-Relation Management</h2>
</div>

<div id="content">
<form action="savecustomer" modelAttribute="customer" method="post">
   <table>
      <tbody>
          <tr>
             <td><label>First Name</label></td>
             <td><form:input path="firstName"/></td>
          </tr>
          <tr>
             <td><label>last Name</label></td>
             <td><form:input path="lastName"/></td>
          </tr>
          <tr>
             <td><label>Email</label></td>
             <td><form:input path="email"/></td>
          </tr>

          <tr>
             <td><label>Email</label></td>
             <td><input type="text" value="Save" class="save"/></td>
          </tr>

        </tbody>
        
     </table>

</form>
</div>
</div>


</body>
</html>