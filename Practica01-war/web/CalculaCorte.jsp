<%-- 
    Document   : CalculaCorte
    Created on : 01-mar-2016, 10:32:27
    Author     : ricardo_rodab
--%>

<%@page import="fciencias.riesgotec.javaee.Venta"%>
<%@page import="dao.DataAccess"%>
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
            Venta venta = new Venta();
            int id = Integer.parseInt(request.getParameter("fecha2"));
            venta.setId(id);
            venta = new DataAccess().getVenta(venta.getId());
            double iva = venta.getIva();
            double neto = venta.getTotal()-iva;            
            System.out.println(venta.getTotal());
            System.out.println(iva);
            System.out.println(neto);
            response.sendRedirect("/Practica01-war/faces/index.xhtml");
            %>
            
    </body>
</html>
