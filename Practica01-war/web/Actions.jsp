<%-- 
    Document   : Actions
    Created on : 01-mar-2016, 1:35:24
    Author     : ricardo_rodab
--%>

<%@page import="fciencias.riesgotec.javaee.Capturista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        
            String nombre = request.getParameter("nombre");
            String apellidoPaterno = request.getParameter("apellidoP");
            String apellidoMaterno = request.getParameter("apellidoM");
            Capturista cap = new Capturista();
            cap.setNombre(nombre);
            cap.setApellidoMaterno(apellidoMaterno);
            cap.setApellidoPaterno(apellidoPaterno);
            cap.agrega();            
        %>
        
    </body>
</html>
