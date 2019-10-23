const httpRequestAlumnos = {
	RegistrarAlumno() {
		$("#btnRegistrar").click(function () {

			jQuery.validator.addMethod("lettersonly", function (value, element) {
				return this.optional(element) || /^[a-zAZ_áéíóúñ\s]+$/i.test(value);
			}, "");
			var validator = $("#formulaAlumno").validate({
				rules: {txtNumDocumento: {
						required: true
					},
					txtApePaterno: {
						required: true,
						lettersonly: true
					}, txtApeMaterno: {
						required: true,
						lettersonly: true
					}, txtNombres: {
						required: true,
						lettersonly: true
					}, departamento: {
						required: true
					}, provincia: {
						required: true
					}, distrito: {
						required: true
					}
					, fechaNacimiento: {
						required: true
					}
					, sexo: {
						required: true
					}
					, telefono: {
						required: true
					}, email: {
						required: true
					}
				}
			});
			var validador = validator.form()
			var cboSede = $("#selSedes").val();
			$('#departamento').parent().append(document.getElementById('departamento-error'))
			$('#distrito').parent().append(document.getElementById('distrito-error'))
			$('#distrito').parent().append(document.getElementById('distrito-error'))
			$('#provincia').parent().append(document.getElementById('provincia-error'))
			$('#sexo').parent().parent().parent().parent().append(document.getElementById('sexo-error'))
//		if (validador && $("#selSedes").val() != null) {   
			if (validador) {
				EventAlumno.Registrar()
			}
		});
	}
}

const EventAlumno = {
	Registrar() {
		
		let Documento = document.getElementById("txtNumDocumento").value
		let ApellidoPat = document.getElementById("txtApePaterno").value
		let ApellidoMat = document.getElementById("txtApeMaterno").value
		let distrito = document.getElementById("distrito").value
		let fechaNaci = $('#fechaNacimiento').val().split("/").reverse().join("-")
		
		let arr = $('[name="sexo"]:checked').map(function () {
			return this.value;
		}).get();
		var nombre=document.getElementById("txtNombres").value
		var sexo = arr.join('');
		let telefono = document.getElementById("telefono").value
		let Email = document.getElementById("email").value
		let json = {
			"documento": Documento,
			"apellidoPat": ApellidoPat,
			"apellidomMat": ApellidoMat,
			"nombre": nombre,
			"distrito": distrito,
			"fechaNaci": fechaNaci,
			"sexo": sexo,
			"telefono": telefono,
			"email": Email
		}
		$.ajax({
			type: 'POST',
			url: "../Alumno?accion=RegistrarAlumno",
			dataType: 'JSON',
			data:  {
					json: JSON.stringify(json)
				},
			success: function (data) {
				//aqui el status
			}})
		
	},textoMayusculasApePaterno() {
		$("#txtApePaterno").focusout(() => {
			let txtApePaterno = document.getElementById("txtApePaterno").value
//			toUpperCase
			let apellido_mayusculas = txtApePaterno.toUpperCase()
			$("#txtApePaterno").val(apellido_mayusculas)
		})
	},
	textoMayusculasApeMaterno() {
		$("#txtApeMaterno").focusout(() => {
			let txtApeMaterno = document.getElementById("txtApeMaterno").value
			let apellido_mayusculas = txtApeMaterno.toUpperCase()
			$("#txtApeMaterno").val(apellido_mayusculas)
			let txtDni = document.getElementById("txtApeMaterno").value
			
		})
	},
	textoMayusculasNombres() {
		$("#txtNombres").focusout(() => {
			let txtNombres = document.getElementById("txtNombres").value
			let nombre_mayusculas = txtNombres.toUpperCase()
			$("#txtNombres").val(nombre_mayusculas)
		})
	},
	validarSoloNumeros() {
			$('#txtNumDocumento').on('input', function () {
			this.value = this.value.replace(/[^0-9]/g, '');

		});
			$('#telefono').on('input', function () {
			this.value = this.value.replace(/[^0-9]/g, '');

		});

	},
	validarSoloLetras() {
		
			$('#txtApePaterno').on('input', function () {
			this.value = this.value.replace(/[^A-Za-z-ñÑ\s]/g, '');

		});

		$('#txtApeMaterno').on('input', function () {
			this.value = this.value.replace(/[^A-Za-z-ñÑ\s]/g, '');

		});
		$('#txtNombres').on('input', function () {
			this.value = this.value.replace(/[^A-Za-z\s]/g, '');

		});
		$('#txtCargo').on('input', function () {
			this.value = this.value.replace(/[^A-Za-z\s]/g, '');

		});

	}
}




init = () => {
	httpRequestAlumnos.RegistrarAlumno()
	EventAlumno.textoMayusculasApePaterno()
	EventAlumno.textoMayusculasApeMaterno()
	EventAlumno.textoMayusculasNombres()
	EventAlumno.validarSoloLetras()
	EventAlumno.validarSoloNumeros()

}

init()


function soloNumeros(input) {
	$('#' + input).on('keypress keyup blur', function (e) {
		$(this).val($(this).val().replace(/[^\d].+/, ""));
		if ((e.which < 48 || e.which > 57)) {
			e.preventDefault();
		}
	});
}

