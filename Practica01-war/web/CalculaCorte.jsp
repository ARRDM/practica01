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
        <title>MTY Store</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">


    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">

    <script src="docs/assets/js/ie-emulation-modes-warning.js"></script>
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
<div class="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">MTY Store</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Busca por id de venta">
        </div>
        <button type="submit" class="btn btn-default">Buscar</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Inicia sesión</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <br>
                <br>
                <div class="well">
                    <h1 class="text-center">Resultado de búsqueda</h1>
                    <hr>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
<ul class="list-group">
  <li class="list-group-item"><h4> Total = <%= venta.getTotal() %> </h4></li>
  <li class="list-group-item"><h4> Iva = <%= iva %> </h4></li>
  <li class="list-group-item"><h4> Neto = <%= neto %> </h4></li>
</ul>

<br>
<br>

            <a href="consultas.html">
                <button class="btn btn-primary" type="button" value="index.html">Regresar a ventas</button>
            </a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
            <div>
            </div>
           
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="docs/assets/js/ie10-viewport-bug-workaround.js"></script> 
    </body>
</html>
