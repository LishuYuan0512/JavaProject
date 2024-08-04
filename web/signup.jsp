
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
    <style>
        .error-message {
            color: red;
            font-size: 0.9em;
            margin-top: 5px;
        }
        .form-control.error {
            border-color: red;
        }
    </style>
</head>
<body>
    <!-- Include Header -->
    <div class="header navbar navbar-expand-lg">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Food Waste Reduction Platform</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    </div>
    <div class="main">
        <div class="card p-4">
            <h2 class="text-center">Sign Up</h2>
            <form id="signupForm" action="${pageContext.request.contextPath}/SignUpController" method="post" novalidate>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                    <div id="nameError" class="error-message"></div>
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                    <div id="emailError" class="error-message"></div>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" required>
                    <div id="passwordError" class="error-message"></div>
                </div>
                <div class="form-group">
                    <label for="retypePassword">Re-type Password</label>
                    <input type="password" class="form-control" name="retypePassword" id="retypePassword" placeholder="Retype your password" required>
                    <div id="retypePasswordError" class="error-message"></div>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter your phone number" required>
                    <div id="phoneError" class="error-message"></div>
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <select class="form-control" id="type" name="type" required>
                        <option value="">Select a user type</option>
                        <option value="Customer">Customer</option>
                        <option value="Retailer">Retailer</option>
                        <option value="Charity">Charity</option>
                    </select>
                    <div id="typeError" class="error-message"></div>
                </div>
                <div class="form-group">
                    <label for="location">Location</label>
                    <select class="form-control" id="location" name="location" required>
                        <option value="">Select a location</option>
                        <option value="1">Ottawa</option>
                        <option value="2">Toronto</option>
                    </select>
                    <div id="locationError" class="error-message"></div>
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
        document.getElementById('signupForm').addEventListener('submit', function(e) {
            e.preventDefault();
            var isValid = validateForm();
            if (isValid) {
                this.submit();
            }
        });

        function validateForm() {
            var isValid = true;

            // Clear previous errors
            $('.error-message').text('');
            $('.form-control').removeClass('error');

            // Validate name
            var name = $('#name').val();
            if (name === '' || name.length > 20) {
                $('#nameError').text('User name should be non-empty, and within 20 characters long.');
                $('#name').addClass('error');
                isValid = false;
            }

            // Validate email
            var email = $('#email').val();
            var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            if (email === '' || !emailPattern.test(email)) {
                $('#emailError').text('Email address should be non-empty with the format xyz@xyz.xyz.');
                $('#email').addClass('error');
                isValid = false;
            }

            // Validate password
            var password = $('#password').val();
            var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
            if (password === '' || !passwordPattern.test(password)) {
                $('#passwordError').text('Password should be at least 6 characters: 1 uppercase, 1 lowercase.');
                $('#password').addClass('error');
                isValid = false;
            }

            // Validate retype password
            var retypePassword = $('#retypePassword').val();
            if (retypePassword === '' || retypePassword !== password) {
                $('#retypePasswordError').text('Please retype password.');
                $('#retypePassword').addClass('error');
                isValid = false;
            }

            // Validate phone
            var phone = $('#phone').val();
            if (phone === '') {
                $('#phoneError').text('Phone number is required.');
                $('#phone').addClass('error');
                isValid = false;
            }

            // Validate user type
            var type = $('#type').val();
            if (type === '') {
                $('#typeError').text('Please select a user type.');
                $('#type').addClass('error');
                isValid = false;
            }

            // Validate location
            var location = $('#location').val();
            if (location === '') {
                $('#locationError').text('Please select a location.');
                $('#location').addClass('error');
                isValid = false;
            }

            return isValid;
        }
    </script>
</body>
</html>