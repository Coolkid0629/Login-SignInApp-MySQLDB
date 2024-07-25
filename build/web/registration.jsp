<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 400px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .container h1 {
            text-align: center;
            color: #333;
        }
        .container form {
            text-align: center;
        }
        .container form input[type="text"],
        .container form input[type="password"],
        .container form input[type="date"],
        .container form input[type="tel"],
        .container form input[list],
        .container form select {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .container form input[type="submit"] {
            width: 100%;
            background-color: #008CBA;
            color: white;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .container form input[type="submit"]:hover {
            background-color: #005F6B;
        }
        .container p {
            text-align: center;
            margin-top: 10px;
        }
        .container a {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #008CBA;
            text-decoration: none;
        }
        .container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Register Account!</h1>
        <form action="RegisterServlet" method="post" id='registration_form' autocomplete="off">
            <p>Username</p>
            <input type="text" placeholder="Username" name="name" required>
            <p>Email</p>
            <input type="text" placeholder="Email" name="email" required>
            <p>Date of Birth</p>
            <input type='date' name='dateofbirth' required><br><br>
            <p>Phone Number</p>
            <input type='tel' name='phone' placeholder='123-456-7890' pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"><br><br>
            <small>Format: 123-456-7890</small><br><br>
            <p>Gender</p>
            <select name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</<option>
                <option value="Other">Other</option>
            </select>
            <br><br>
            <p>Contact Method</p>
            <select name="contact">
                <option value="Email">Email</option>
                <option value="Phone">Phone</option>
            </select>
            <p>Password</p>
            <input type="password" placeholder="Password" name="password" id='password' required>
            <p>Cofirm Password</p>
            <input type="password" placeholder="Confirm Password" id='confirm_password' required>
            <span id='password_error' style='color: red;'></span>
            <br><br>
            <input type="submit" value="Register">
            <p></p>
        </form>
        <a href="index.jsp">Already have an account?</a>
    </div>
    
    <script>
        debugger;
        document.addEventListener("DOMContentLoaded", function() {
            const form = document.getElementById('registration_form');
            const passwordInput = document.getElementById('password');
            const confirmPasswordInput = document.getElementById('confirm_password');
            const passwordError = document.getElementById('password_error');

            form.addEventListener('submit', function(event) {
                if (passwordInput.value !== confirmPasswordInput.value) {
                    passwordError.textContent = "Passwords do not match";
                    event.preventDefault(); // Prevent form submission
                } else {
                    passwordError.textContent = "";
                    // Passwords match, continue with form submission
                }
            });
        });
    </script>

</body>
</html>
