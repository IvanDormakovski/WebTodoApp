<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.08.2020
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://webtodoapp.com" class="navbar-brand">Web Todo App</a>
        </div>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%= request.getContextPath() %>/login" class="nav-link">Log in</a> </li>
            <li><a href="<%= request.getContextPath() %>/register" class="nav-link">Sign in</a> </li>
        </ul>
    </nav>
</header>
</body>
</html>