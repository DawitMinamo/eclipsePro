<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List-Customers</title>

<link type="text/css"
      rel = "stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"/>
     
</head>
<body>
    <div id="wrapper">
        <div id="header">
           <h2>CRM-Customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
       <div id="content">
       <!-- add input butten for adding customer -->
       <input type="button" value="Add Customer"
            onClick="window.location.href='showFormForAdd'; return false"
            class="add-button"/>
            
       <form:form action="search" method="GET">
       Search Customer:<input type="text" name="searchCustomer">
       <input type="submit" value="Search" class="add-button" />
       </form:form>
          <table>
          <!-- add html header -->
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Action</th>
             </tr>
             <!-- retrive the file and add on the table -->
             <c:forEach var="temp" items="${customers}">
             
             <!-- construct an update link with customerId -->
             <c:url var="updateLink" value="/customer/showFormForUpdate">
             <c:param name="customerId" value="${temp.id}" />
             </c:url>
             
             <c:url var="deleteLink" value="/customer/delete">
               <c:param name="customerId" value="${temp.id}"/>
             </c:url>
                <tr>
                  <td>${temp.firstName}</td>
                  <td>${temp.lastName}</td>
                   <td>${temp.email}</td>
                   <td>
                   <!-- display the update link -->
                   <a href="${updateLink}">Update</a>
                   |
                   <!-- constracte the delete link -->
                   <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                   </td>
                   </tr>
             </c:forEach>
          </table>
       </div>
    
    </div>
</body>
</html>