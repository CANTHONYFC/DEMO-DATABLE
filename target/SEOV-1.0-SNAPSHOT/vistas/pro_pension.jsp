<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="es-PE">
    <head>
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
            <div class="ibox float-e-margins">
                <div class="ibox-content text-center p-md">

									<h2><span class="text-navy" style="color: red">Área de </span><span class="text-navy" style="color: blue">TIC</span>
									 preparar a los estudiantes para su futuro y  no para nuestro pasado</h2>

                


                </div>
            </div>
        </div>
    </div>
<div class="col-lg-12">

                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>Ubicacion<small></small></h5>
                        </div>
                        <div class="ibox-content">

                            <div class="row">
															<div class="col-lg-4 col-md-4 "><!--------Label de Cargo---------------->
										<div class="form-group">
											<label>Selecciona Departamento</label> <span class="text-danger">(*)</span> 
											<div id="divresponsable" style="width: 100%">
												<select class="js-example-basic-multiple" style="width: 100%" name="account"   id="departamento" required>
														
                                    </select>
											</div>
										</div>
									</div>
																<div class="col-lg-4 col-md-4 "><!--------Label de Cargo---------------->
										<div class="form-group">
											<label>Seleccione Provincia:</label> <span class="text-danger">(*)</span> 
											<div id="divresponsable" style="width: 100%">
												<select class="js-example-basic-multiple" style="width: 100%" name="account"   id="provincia" required>
														
                                    </select>
											</div>
										</div>
									</div>
																<div class="col-lg-4 col-md-4 "><!--------Label de Cargo---------------->
										<div class="form-group">
											<label>Seleccione Distrito:</label> <span class="text-danger">(*)</span> 
											<div id="divresponsable" style="width: 100%">
												<select class="js-example-basic-multiple" style="width: 100%" name="account"   id="distrito" required>
														
                                    </select>
											</div>
										</div>
									</div>
															
															
                            </div>
                        </div>
                    </div>
                </div>
</div>


        <%@include file="templates/footer-body.jsp"%>
       
				<script src="../js/pages/personal.js" type="text/javascript"></script>
		
    </body>
</html>
