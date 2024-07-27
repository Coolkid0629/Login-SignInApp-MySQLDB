<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
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
        .container form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .container form input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .container form input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container p {
            text-align: center;
            margin-top: 10px;
        }
        .container a {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #4CAF50;
            text-decoration: none;
        }
        .container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body> 
    <div class="container">
        <h1>Login Account</h1>
        <form action="LoginServlet" method="post" autocomplete="off">
            <p>User Email</p>
            <input type="text" placeholder="Email" name="email" required>
            <p>Password</p>
            <input type="password" placeholder="Password" name="password" required>
            <p></p>
            <input type="submit" value="Login">
        </form>
        <p></p>
        <a href="user_registration.jsp">Don't have an account?</a>
    </div>
</body>
</html>
