<%-- 
    Document   : CalculaCorte
    Created on : 01-mar-2016, 10:32:27
    Author     : ricardo_rodab
--%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Date"%>
<%@page import="fciencias.riesgotec.javaee.Venta"%>
<%@page import="dao.DataAccess"%>
<%@page import="fciencias.riesgotec.javaee.Capturista"%>
<%@page import="fciencias.riesgotec.javaee.GeneradorSVG"%>
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
     <%                         
            LinkedList<Venta> ventas = new DataAccess().getAllVenta();
            ventas.sort(new Comparator<Venta>() {

                @Override
                public int compare(Venta v1, Venta v2) {                 
                    if(v1.getAnio() > v2.getAnio()) {
                        return 1;
                    }else if(v1.getAnio() < v2.getAnio()){
                        return -1;
                    }else if(v1.getMes() > v2.getMes()){
                        return 1;
                    }else if(v1.getMes() < v2.getMes()){
                        return -1;
                    }else if(v1.getDia() > v2.getDia()){
                        return 1;
                    }
                    return -1;
                }
            });
            GeneradorSVG tabla = new GeneradorSVG(500, 500);
            double max = 0;
            for(int j = 0; j < ventas.size(); j++)
                max = ventas.get(j).getTotal() > max ? ventas.get(j).getTotal() : max;
            int tiempo = ventas.size();
            for(int i = 0; i < tiempo-1; i++){
                int x1 = (int)(((double)i/tiempo)*500);
                int x2 = (int)(((double)(i+1)/tiempo)*500);  
                int y1 = (int)((ventas.get(i).getTotal()*500.0)/max);
                int y2 = (int)((ventas.get(i+1).getTotal()*500.0)/max);
                int y1Iva = (int)((ventas.get(i).getIva()*500.0)/max);
                int y2Iva = (int)((ventas.get(i+1).getIva()*500.0)/max);
                int y1Neto = (int)(((ventas.get(i).getTotal()-ventas.get(i).getIva())*500.0)/max);
                int y2Neto = (int)(((ventas.get(i+1).getTotal()-ventas.get(i+1).getIva())*500.0)/max);
                tabla.agregaRecta(x1,y1,x2,y2,GeneradorSVG.AZUL);
                tabla.agregaRecta(x1, y1Iva, x2, y2Iva, GeneradorSVG.ROJO);
                tabla.agregaRecta(x1, y1Neto, x2, y2Neto, GeneradorSVG.VERDE);
            }
            %>
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
                    <h1 class="text-center">Tabla de ventas:</h1>
                    <hr>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
<ul class="list-group">
   <%=tabla.getSVG()%>
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



 <!--             
 <li class="list-group-item"><h4> Total = <= venta.getTotal() %> </h4></li>
  <li class="list-group-item"><h4> Iva = <= iva %> </h4></li>
  <li class="list-group-item"><h4> Neto = <= neto %> </h4></li> 
    -->