<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Cookie[] ac = request.getCookies();
            if(ac == null){
                out.println("No hay cookies");
                Cookie c = new Cookie("saludo", "HOLA");
                Cookie color = new Cookie("color", "red");
                
                response.addCookie(c);   
                response.addCookie(color); 
                
            }else{
                out.println("Cookie crada<br>");
                for (Cookie c : ac){
                out.println(c.getName() + ": " + c.getValue());
                if(c.getName().equals("color")){
                    out.println("<body style = \"background-color: " + c.getValue() +";\">");
                }
               // out.println("<body style = \"background-color: " + c.getValue() +";\">");
                }
            }
        %>
    </body>
</html>