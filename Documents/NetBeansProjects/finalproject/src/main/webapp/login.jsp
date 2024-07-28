<%-- 
    Document   : login
    Created on : Jul 27, 2024, 12:38:09 PM
    Author     : tangy
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <div>
            <a href="login.jsp" class="text-white">login</a>
        </div>
    </div>
    <div class="main">
        <div class="card p-4">
            <h2 class="text-center">Login</h2>
            <form>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password">
                </div>
                <button type="button" class="btn btn-custom btn-block" onclick="window.location.href='customer.jsp'">Login</button>
                <!--in real requirement the type should use submit-->
                <!--<button type="submit" class="btn btn-custom btn-block" onclick="window.location.href='customer.jsp'">Login</button>-->
                <div class="text-center mt-3">
                    <span>Don't have an account? <a href="signup.jsp">Sign Up</a></span>
                </div>
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
