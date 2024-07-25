<%-- 
    Document   : welcome
    Created on : Jul 24, 2024, 2:24:45 PM
    Author     : kaust
--%>
<%@page import="newpackage.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% User user = (User) session.getAttribute("logUser");
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
        %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        h3 {
            color: #666;
        }
        button {
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }
        button:hover {
            background-color: #005F6B;
        }
        button a {
            color: white;
            text-decoration: none;
        }
        button a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, <%= user.getName() %></h1>
        <h3>Your Account id: <%= user.getId() %></h3>
        <h3>Your Account Email: <%= user.getEmail() %></h3>
        <h3>Your Account Password: <%= user.getPassword() %></h3>
        <h3>Your Date of Birth (YYYY-MM-DD): <%= user.getDob() %></h3>
        <h3>Your Phone: <%= user.getPhone() %></h3>
        <h3>Your Gender: <%= user.getGender() %></h3>
        <h3>Your Contact Method: <%= user.getContactMethod() %></h3>
        <h3>Account Creation: <%= user.getAccountCreatedData() %></h3>

        <button><a href="LogoutServlet">I'm Done! Log Out.</a></button>
    </div>
</body>
</html>