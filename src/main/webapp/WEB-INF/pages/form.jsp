<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Naushad
  Date: 5/3/2015
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <style>
    .error {
      color: red; font-weight: bold;
    }
  </style>
    <script>
        $(function() {
            var pickerOpts = {
                dateFormat: $.datepicker.ATOM
            };
            $("#dateOfBirth").datepicker(pickerOpts);
        });
    </script>
</head>
<body>
  <form:form action="/" commandName="person">
      <table>
          <tr>
              <td>First Name : </td>
              <td><form:input path="firstName"  /></td>
              <td><form:errors path="firstName" cssClass="error"/></td>
          </tr>
          <tr>
              <td>Last Name :  </td>
              <td><form:input path="lastName" /></td>
              <td><form:errors path="lastName" cssClass="error"/></td>
          </tr>

          <tr>
              <td>E-mail: </td>
              <td><form:input path="email" /></td>
              <td><form:errors path="email" cssClass="error"/></td>
          </tr>
          <tr>
              <td>Date Of Birth: </td>
              <td><form:input path ="dateOfBirth" id="dateOfBirth" /></td>
              <td><form:errors path="dateOfBirth" cssClass="error"/></td>
          </tr>

          <tr>
              <td>Address: </td>
              <td><form:input path="address" /></td>
              <td><form:errors path="address" cssClass="error"/></td>
          </tr>

          <tr>
              <td><input type="submit" value="Login"/></td>
          </tr>
      </table>
  </form:form>
</body>
</html>
</html>
