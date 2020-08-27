<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.08.2020
  Time: 21:20
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
<div class="container">

    <h2>User Register Form</h2>
    <div class="col-md-6 col-md-offset-3">
        <div class="alert alert-success center" role="alert">
            <p>${NOTIFICATION}</p>
        </div>

        <form action="<%=request.getContextPath()%>/register" method="post">

            <div class="form-group">
                <label for="firstname">First Name:</label> <input type="text" class="form-control" id="firstname" placeholder="First Name" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="lastname">Last Name:</label> <input type="text" class="form-control" id="lastname" placeholder="last Name" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="username">User Name:</label> <input type="text" class="form-control" id="username" placeholder="User Name" name="userName" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
