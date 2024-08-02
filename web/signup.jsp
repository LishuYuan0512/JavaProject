
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - Food Waste Reduction Platform</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="main">
        <div class="card p-4">
            <h2 class="text-center">Sign Up</h2>
            <form id="signupForm" action="../FinalProject/SignUpController" method="post">
                <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger">
                        <%= request.getAttribute("error") %>
                    </div>
                <% } %>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" required>
                </div>
                <div class="form-group">
                    <label for="retypePassword">Retype Password</label>
                    <input type="password" class="form-control" name="retypePassword" id="retypePassword" placeholder="Retype your password" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter your phone number" required>
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <select class="form-control" id="type" name="type" required>
                        <option value="Customer">Customer</option>
                        <option value="Retailer">Retailer</option>
                        <option value="Charity">Charity</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="location">Location</label>
                    <select class="form-control" id="location" name="location" required>
                        <option value="1">Ottawa</option>
                        <option value="2">Toronto</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-custom btn-block">Sign Up</button>
                <div class="text-center mt-3">
                    <span>Already have an account? <a href="login.jsp">Login</a></span>
                </div>
            </form>
        </div>
    </div>
    
    <%@ include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // Basic front-end validation for password matching
        $('#signupForm').on('submit', function(e) {
            var password = $('#password').val();
            var retypePassword = $('#retypePassword').val();

            if (password !== retypePassword) {
                e.preventDefault();
                alert("Passwords do not match!");
            }

            // Further validation checks can be added here
        });
    </script>
</body>
</html>
