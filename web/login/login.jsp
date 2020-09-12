<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.08.2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">

        <div class="form-group">
            <label for="userName">User Name:</label> <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
        </div>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
