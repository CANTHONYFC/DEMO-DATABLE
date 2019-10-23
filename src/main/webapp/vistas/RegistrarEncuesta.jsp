<%-- 
    Document   : RegistrarEncuesta
    Created on : 04-oct-2019, 14:15:06
    Author     : sistem16user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="es-PE">
    <head>

        <%
            //Billy Larru
            response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
            response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
            response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
        %>
        <%
            HttpSession session_actual = request.getSession();

            if (session_actual.getAttribute("dni") != null) {

            } else {
                response.sendRedirect("../vistas/index.jsp");
            }

        %>	
        <%@include file="templates/header.jsp" %>
        <style>
            .resaltar{background-color:#FF0;}
        </style> 
    </head>
    <body>
        <%@include file="templates/header-body.jsp" %>
        <form id="formularioTestKunder" class="animated">
            <div id="listaEncuesta">
            </div>
        </form>
        <div class="row">
            <div class="col-lg-12">

                <div class="ibox">

                    <div class="ibox-content">



                        <br>
                        <!--<div class="row text-center">-->
                        <div class="col-3" style="margin: auto">
                            <button type="submit" name="submit" style="background: #33B77F;border:#33B77F" value="Registrar" class="btn btn-success botones" id="btnRegistrarTestKunder">
                                <i class="fa fa-check bigger-10"></i>&nbsp; Registrar </button>
                            <button data-bb-handler="no" type="button" style="background: #f8ac59;border:#33B77F" class="btn btn-danger" id="btnLimpiar">
                                <i class="fa fa-eraser bigger-110 "></i>&nbsp; Limpiar
                            </button>
                        </div>	
                    </div>
                </div>
            </div>

        </div>
    </div>

    <%@include file="templates/footer-body.jsp"%>

    <script src="../js/pages/general.js" type="text/javascript"></script>
    <script src="../js/pages/Encuesta.js" type="text/javascript"></script>
</body>
</html>