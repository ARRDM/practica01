<%-- 
    Document   : Ventas
    Created on : 01-mar-2016, 2:59:03
    Author     : ricardo_rodab
--%>

<%@page import="dao.DataAccess"%>
<%@page import="fciencias.riesgotec.javaee.Capturista"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <!-- AQUÃ VA EL TÃTULO DE LA PÃGINA -->
        <title>MTY Store</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        
        <link href="style.css" rel="stylesheet">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        
        <script src="docs/assets/js/ie-emulation-modes-warning.js"></script>
        
    </head>
      
    <!-- EMPIEZA EL DISEÃO 
      ========================================= -->
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
        
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Busca por id de venta">
                            </div>
                            <button type="submit" class="btn btn-default">Buscar</button>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Inicia sesiÃ³n</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
        <br>
        <!-- Termina NAVBAR -->
    
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="well">
                        <ul class="nav nav-tabs nav-justified">
                            <li class="active"> <a href="#Venta">Nueva venta</a></li>
                            <li><a href="consultas.html">Consulta ventas</a></li>
                            <li><a href="capturista.html">Registrar capturista</a></li>
                        </ul>
                        <br>
                        <br>
                        <h1 class="text-center">Registra una nueva venta</h1>
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                <body onload="form1.submit();">                                   
                                <form action="PostVenta.jsp" method="post">   
                                                                        <h5>Capturista que hizo la venta</h5>
                                    <select class="form-control" id="sel1" name="IdCapturista">
                                    <% 
                                        LinkedList<Capturista> all = new DataAccess().getAllCapturista();
                                        if(all.isEmpty()){
                                            %>
                                            <option value="null">FAVOR DE DAR DE ALTA UN CAPTURISTA</option>
                                            <%
                                        }else{
                                            for(int i = 0; i < all.size(); i++){                                     
                                                %> 
                                                <option value="<%= all.get(i).getId() %>">
                                                    <%= all.get(i).getId() %>,<%= all.get(i).getNombre()%> <%= all.get(i).getApellidoPaterno() %>
                                                </option>
                                                
                                                <% 
                                            } 
                                        }
                                        %> 
                                            </select>  
                                    <br>
                                    <h5>Fecha:</h5>
                                    <div class="row">
                                        <div class="col-md-3">
                                            <h5>Día</h5>
                                            <select class="form-control" id="sel1" name="dia">
                                                 <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                                <option value="11">11</option>
                                                <option value="12">12</option>
                                                <option value="13">13</option>
                                                <option value="14">14</option>
                                                <option value="15">15</option>
                                                <option value="16">16</option>
                                                <option value="17">17</option>
                                                <option value="18">18</option>
                                                <option value="19">19</option>
                                                <option value="20">20</option>
                                                <option value="21">21</option>
                                                <option value="22">22</option>
                                                <option value="23">23</option>
                                                <option value="24">24</option>
                                                <option value="25">25</option>
                                                <option value="26">26</option>
                                                <option value="27">27</option>
                                                <option value="28">28</option>
                                                <option value="29">29</option>
                                                <option value="30">30</option>
                                                <option value="31">31</option>
                                            </select>
             
                                        </div>
                                        <div class="col-md-3">
                                            <h5>Mes</h5>
                                            <select class="form-control" id="sel1" name="mes">
                                                <option value="1">Enero</option>
                                                <option value="2">Febrero</option>
                                                <option value="3" selected>Marzo</option>
                                                <option value="4">Abril</option>
                                                <option value="5">Mayo</option>
                                                <option value="6">Junio</option>
                                                <option value="7">Julio</option>
                                                <option value="8">Agosto</option>
                                                <option value="9">Septiembre</option>
                                                <option value="10">Octubre</option>
                                                <option value="11">Noviembre</option>
                                                <option value="12">Diciembre</option>
                                            </select>
                                        </div>
                                        <div class="col-md-3">
                                            <h5>Año</h5>
                                            <select class="form-control" id="sel1" name="anio">
                                                 <option value="1990">1990</option>
                                                <option value="1991">1991</option>
                                                <option value="1992">1992</option>
                                                <option value="1993">1993</option>
                                                <option value="1994">1994</option>
                                                <option value="1995">1995</option>
                                                <option value="1996">1996</option>
                                                <option value="1997">1997</option>
                                                <option value="1998">1998</option>
                                                <option value="1999">1999</option>
                                                <option value="2000">2000</option>
                                                <option value="2001">2001</option>
                                                <option value="2002">2002</option>
                                                <option value="2003">2003</option>
                                                <option value="2004">2004</option>
                                                <option value="2005">2005</option>
                                                <option value="2006">2006</option>
                                                <option value="2007">2007</option>
                                                <option value="2008">2008</option>
                                                <option value="2009">2009</option>
                                                <option value="2010">2010</option>
                                                <option value="2011">2011</option>
                                                <option value="2012">2012</option>
                                                <option value="2013">2013</option>
                                                <option value="2014">2014</option>
                                                <option value="2015" selected>2015</option>
                                                <option value="2016">2016</option>
                                                <option value="2017">2017</option>
                                                <option value="2018">2018</option>
                                                <option value="2019">2019</option>
    
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <h5>Total de venta</h5>
                                    <input type="text"  name="total" class="form-control" placeholder="Venta bruta">
                                    <br>
                                    <button class="btn btn-primary" type="submit" value="submit">Registrar venta</button>
                                </form>
                                </body>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      
        <div class="container">
            <br>
            <br>
            <div class="col-md-12 text-center">
                <p>MTY Store 2016. Todos los derechos reservados.</p>
            </div>
        </div>
    
    
        <!-- JAVASCRIPT -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="docs/assets/js/ie10-viewport-bug-workaround.js"></script>
        
    </body>
</html>