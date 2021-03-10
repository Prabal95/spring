<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <%@include file="./base.jsp" %>
</head>
<body>
<h1>Add New Employee</h1>
<form action="handle-employee" method="post">
    <table>
        <tr>
            <td>Enter Name : </td><td><input type="text" name="name" placeholder="Enter Name (Use Only Letters)" pattern="[A-Za-z\s]+" size="35" required></td>
        </tr>
        <tr>
            <td>Enter Age : </td><td><input type="text" name="age" placeholder="Enter Age (Numbers Only)" maxlength="2" pattern="[0-9]+" required></td>
        </tr>
        <tr>
            <td>Enter Salary : </td><td><input type="text" name="salary" placeholder="Enter Salary" pattern="[0-9]+" size="10" required></td>
        </tr>
        <tr>
            <td>Enter City : </td><td><input type="text" name="city" placeholder="Enter City (Use Only Letters)" pattern="[A-Za-z\s]+" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Click To Add"></td>
        </tr>

    </table>
</form>

</body>
</html>