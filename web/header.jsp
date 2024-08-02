<%-- 
    Document   : header
    Created on : Aug 2, 2024, 3:00:07 PM
    Author     : rosal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<div class="header navbar navbar-expand-lg">
    <a class="navbar-brand" href="index.jsp">Food Waste Reduction Platform</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <%
                    String userType = (String) session.getAttribute("userType");
                    if (userType != null) {
                %>
                    <a class="nav-link" href="logout.jsp">Logout</a>
                <% } else { %>
                    <a class="nav-link" href="login.jsp">Login</a>
                <% } %>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
