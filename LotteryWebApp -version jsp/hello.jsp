<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Congratulations!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        h2 {
            color: red;
        }
        p {
            color: black;
            font-size: 18px;
        }
        a {
            color: #808080;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Hello, <%= request.getParameter("firstname") + " " + request.getParameter("lastname") %>!</h2>
    <p>Congratulations! You've won <%= Math.random() * 10 %> million dollars!</p>
    <br>
    <a href="index.jsp">Go to main page</a>
</body>
</html>
