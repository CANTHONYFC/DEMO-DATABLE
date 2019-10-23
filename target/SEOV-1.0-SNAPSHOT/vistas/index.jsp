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

		<%@include file="templates/header.jsp" %>
		<style>
			.resaltar{background-color:#FF0;}
		</style> 
	</head>
	<body>
		<%@include file="templates/header-body.jsp" %>
		<div class="row wrapper border-bottom blue-bg page-heading"style="background-color:#2c986f ; " >
			<div class="col-lg-9" style="background-color:#2c986f ; ">
				<ol class="breadcrumb"style="background-color:#2c986f; " >
					<li class="active">
						<a href="registroPersonal.jsp">
							<i class="fa fa-home"></i> Inicio
						</a>
					</li>
					<li class="active">
						<strong>Listado de usuarios</strong>
					</li>
				</ol>
			</div>
		</div>
		<!-----------------------fin sub titulo---------------->
<div class="wrapper wrapper-content animated fadeInRight">
	<form  id="formulariolistado"  class="animated" >
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-7">
                <div class="ibox float-e-margins shadow-material">
                    <div class="ibox-title" class="animated">
                        <h5>Listado de usuarios</h5>
                        <div class="ibox-tools">
                            <span class="text-danger">(*)</span>: <em>Campos Obligatorios</em>
                        </div>
                    </div>
                  <div class="ibox-content">
                        <form id="formulario">
                            <div class="row">                                            
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="form-group">
                                            <label>Filtro </label> <span class="text-danger">(*)</span> 
                                            <div id="divFiltro">
                                                <select class="form-control" id="cbFiltro" name="cbFiltro" >
                                                    <option value="3">N° DOCUMENTO</option> 
                                                    <option  value="1">APELLIDOS</option>
                                                    <option  selected="selected" value="0">TODOS</option>

                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                <div  class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="form-group" id="divInputFiltro">
                                        <label>Todos</label> 
                                        <div id="divInputFiltroTxt">
                                            <input  disabled="" type="text" id="txtInputFiltro" name="txtNombres" placeholder="" value="" onchange="" class="form-control">
                                        </div>

                                        </div>
                                    </div>
																</form>
                                </div>
								</div>

                     <div class="ibox-footer">
                            <div class="text-center">                                       
                                <button type="button" class="btn btn-success" onclick="javascript:validarcamposdefiltro();"><i class="fa fa-search"></i> Buscar</button> 
                                <button type="button" class="btn btn-warning" onclick="javascript:limpiartrabajadores();"><i class="fa fa-eraser"></i> Limpiar</button>
																
                            </div>

                        </div>
								
</div>
</div>
						
						<div class="col-lg-3"></div>
						</div>
	<div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins shadow-material">
                    <div class="ibox-title" >
                        <h5>Listado de Trabajadores</h5>
                        
                    </div>
	<!--Ver Listado de Pendientes-->
								<div class="ibox-content" style="padding: 0px 0px 0px 0px !important;">
                        <div class="table-responsive">
										<table id="tbListadoUsuarios" class="table table-striped table-bordered table-hover cell-border" >
											<thead>
												<tr >
													<th class="cabecera"  style="text-align: center" >N°</th>
													<th class="cabecera"  style="text-align: center" >DNI</th>
													<th class="cabecera"  style="text-align: center" >CORREO</th>
													<th class="cabecera" style="text-align: center">APELLIDOS Y NOMBRES</th>
													<th class="cabecera"  style="text-align: center">CONTRASEÑA</th>
													<th class="cabecera all"  style="text-align: center">  ACCIÓN </th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
                    </div>
                </div>
            </div>
        </div>            
    </div>  

	<%@include file="templates/footer-body.jsp"%>
	<script src="../js/pages/listadoUsuarios.js"></script>
	<script src="../plantilla/assets/js/plugins/validate/jquery.validate.min.js" type="text/javascript"></script>
</body>
</html>
