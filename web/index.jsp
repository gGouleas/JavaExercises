<%-- 
    Document   : index
    Created on : Apr 24, 2020, 2:13:15 PM
    Author     : JohnG;
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <%
        if (request.getMethod().equals("GET")) {
            RequestDispatcher rd = request.getRequestDispatcher("User");
            rd.forward(request, response);
        }
        %>
    </head>
        

        
    
</body>
</html>
