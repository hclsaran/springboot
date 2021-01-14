<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>


<h1> Add New Employee</h1>

   <form:form modelAttribute="form">
     <form:errors path="" element="div"/>
     <div>
           <form:label path="name">Employee Name</form:label>
           <form:input path="name"/>
           <form:errors path="name"/>     
                 
     </div>
     
     <div>
         <input type="submit" value="Add Employee"/>
     </div>
   
   </form:form>
</body>
</html>