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

		<div class="wrapper wrapper-content animated fadeInRight">

			<div class="row">
				<div class="col-lg-12">

					<div class="ibox">
						<div class="ibox-title">
							<h5>Registro de Alumnos<small></small></h5>
						</div>
						<div class="ibox-content">
							<form id="formulaAlumno" class="animated">
							<div class="row">
								<div class="col-lg-3 col-md-3 col-sm-3"><!------------------------Label de N°Documento---------------->
									<div class="form-group">
										<label>N°Documento </label> <span class="text-danger">(*)</span> 
										<div id="divNumDocumento">                                                                                                         <!-- soloNumeros(event)  -->
											<input type="text" id="txtNumDocumento" name="txtNumDocumento" placeholder="" value="" class="form-control"  minlength="8" maxlength="8" data-placement="top" data-toggle="tooltip" >
										</div>
									</div>


								</div>	<div class="col-lg-3 col-md-3 col-sm-3"><!------------------------Label de Apellido Paterno---------------->
									<div class="form-group">
										<label>Apellido Paterno</label> <span class="text-danger">(*)</span> 
										<input type="text" id="txtApePaterno" name="txtApePaterno" maxlength="100"  class="form-control"  data-toggle="tooltip" >
									</div>
								</div><!------------------------Fin  Label de Apellido Paterno---------------->
								<div class="col-lg-3 col-md-3 col-sm-3">
									<div class="form-group">
										<label>Apellido Materno</label> <span class="text-danger">(*)</span> 
										<input type="text" id="txtApeMaterno" name="txtApeMaterno" maxlength="100" class="form-control" data-toggle="tooltip" >
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3">
									<div class="form-group">
										<label>Nombres</label> <span class="text-danger">(*)</span> 
										<input type="text" id="txtNombres" name="txtNombres" maxlength="100" class="form-control" data-toggle="tooltip" >
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-4 col-md-4 "><!--------Label de Cargo---------------->

									<label>Selecciona Departamento</label> <span class="text-danger">(*)</span> 
									<div id="divresponsable" style="width: 100%">
										<select class="js-example-basic-multiple" style="width: 100%" name="departamento"   id="departamento" required>

										</select>
									</div>

								</div>
								<div class="col-lg-4 col-md-4 "><!--------Label de Cargo---------------->
									<div class="form-group">
										<label>Seleccione Provincia:</label> <span class="text-danger">(*)</span> 
										<div id="divresponsable" style="width: 100%">
											<select class="js-example-basic-multiple" style="width: 100%" name="provincia"   id="provincia" required>

											</select>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-4 "><!-------v class="col-lg-4 col-md-4 "><-Label de Cargo---------------->
									<div class="form-group">
										<label>Seleccione Distrito:</label> <span class="text-danger">(*)</span> 
										<div id="divresponsable" style="width: 100%">
											<select class="js-example-basic-multiple" style="width: 100%" name="account"   id="distrito" required>

											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 ">	
									  <div class="form-group" id="data_2">
                               	<label>Fecha Nacimiento:</label> <span class="text-danger">(*)</span> 
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
																		<input type="text" name="fechaNacimiento" id="fechaNacimiento"  class="form-control" value="">
                                </div>
                            </div>
</div>

								<div class="col-lg-6 col-md-6  ">
									<label>Sexo:</label> <span class="text-danger">(*)</span> 
									<div class="row ">
										<div style="width: 60%">
										<div class="i-checks" style="width: 40%;float: right;"><label> <input type="radio" id="sexo" name="sexo"  value="1" > <i></i> Masculino</label></div>
								<div class="i-checks" style="width: 40%;margin-left: 25%"><label> <input type="radio" id="sexo"  name="sexo"  value="2" > <i></i> Femenino </label></div>
								</div>
								</div>
								</div>
							</div>
							<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6">
									<div class="form-group">
										<label>Telefono </label> <span class="text-danger">(*)</span> 
										<input type="text" id="telefono" name="telefono"  minlength="8" maxlength="8"  class="form-control" data-toggle="tooltip" >
									</div>
								</div>
									<div class="col-lg-6 col-md-6 col-sm-6">
									<div class="form-group">
										<label>Email </label> <span class="text-danger">(*)</span> 
									<div class="input-group m-b"><span class="input-group-addon">@</span> <input type="email" id="email" name="email" placeholder="Email" class="form-control"></div>
									</div>
								</div>
								
							</div>
								
								</form>
								</br>
									<div class="row text-center">
							<div class="col-3" style="margin: auto">
								<button  type="submit" name="submit" style="background: #33B77F;border:#33B77F" value="Registrar" class="btn btn-success botones" id="btnRegistrar">
												<i class="fa fa-check bigger-10"></i>&nbsp; Registrar </button>
											<button data-bb-handler="no" type="button"  style="background: #f8ac59;border:#33B77F"class="btn btn-danger" id="btnLimpiar">
												<i class="fa fa-eraser bigger-110 "></i>&nbsp; Limpiar
											</button>
										</div>	
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>


		<%@include file="templates/footer-body.jsp"%>
		<script src="../js/pages/ListaUbicacion.js" type="text/javascript"></script>
		<script src="../js/pages/general.js" type="text/javascript"></script>
		<script src="../js/pages/Alumnos.js" type="text/javascript"></script>
		  <script>
            $(document).ready(function () {
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
								
							var today = new Date();
var day = today.getDate();
var month = today.getMonth() + 1;
var year = today.getFullYear();

var formatted =
    (day < 10 ? "0" : "") + day + "/"  +
    (month < 10 ? "0" : "") + month + "/"  +
    year;
								$('#fechaNacimiento').val(formatted)
								
								
								      $('#data_1 .input-group.date').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true
            });

            $('#data_2 .input-group.date').datepicker({
                startView: 1,
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                autoclose: true,
                format: "dd/mm/yyyy"
            });
            });
        </script>
				 <script>
     
    </script>
	</body>
</html>
