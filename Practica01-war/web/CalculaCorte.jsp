<%-- 
    Document   : CalculaCorte
    Created on : 01-mar-2016, 10:32:27
    Author     : ricardo_rodab
--%>

<%@page import="java.util.Date"%>
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
            int dia = Integer.parseInt(request.getParameter("dia"));
            int mes = Integer.parseInt(request.getParameter("mes"));
            int anio = Integer.parseInt(request.getParameter("anio"));
            //System.out.println(request.getParameter("dia") + " "+request.getParameter("mes")+" "+request.getParameter("anio"));       +     
            venta = new DataAccess().getVenta(anio, mes, dia);
            double iva = venta.getIva();
            double neto = venta.getTotal()-iva;                
            %>
            <div>
                <p> Total = <%= venta.getTotal() %> </p>
                <p> Iva = <%= iva %> </p>
                <p> Neto = <%= neto %> </p>
            </div>
            <a href="consultas.html">
                <button class="btn btn-primary" type="button" value="index.html">Regresar a ventas</button>
            </a>
            
    </body>
</html>
