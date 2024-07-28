<%-- 
    Document   : index
    Created on : Jul 27, 2024, 12:37:41 PM
    Author     : tangy
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <a href="login.jsp" class="text-white">login</a>
    </div>
    <div class="main">
        <div class="text-center">
            <h1>Welcome to xxx website!</h1>
            <button class="btn btn-custom" onclick="window.location.href='login.jsp'">Login</button>
            <button class="btn btn-custom" onclick="window.location.href='signup.jsp'">Sign up</button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
