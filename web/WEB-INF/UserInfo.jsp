<%-- 
    Document   : UserInfo
    Created on : Apr 24, 2020, 2:51:05 PM
    Author     : JohnG;
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
                <%= ((models.User) session.getAttribute("user"))%>
    </body>
</html>
