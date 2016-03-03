<%-- 
    Document   : PostVenta
    Created on : 01-mar-2016, 2:59:03
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
            int idCapturista = Integer.parseInt(request.getParameter("IdCapturista"));
            double total = Double.parseDouble(request.getParameter("total"));
             int dia = Integer.parseInt(request.getParameter("dia"));
            int mes = Integer.parseInt(request.getParameter("mes"));
            int anio = Integer.parseInt(request.getParameter("anio"));
            Capturista cap = new DataAccess().getCapturista(idCapturista);
            System.out.println(cap.getId());
            Venta vent = new Venta();
            vent.setTotal(total);
            vent.setMes(mes);
            vent.setDia(dia);
            vent.setAnio(anio);
            new DataAccess().agregaVenta(cap, vent);
            response.sendRedirect("/Practica01-war/ventas.jsp");
        %>
    </body>
</html>
