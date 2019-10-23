
var idSedes = []

//$('#txtNumDocumento').tooltip();
$('[data-toggle="tooltip"]').tooltip();

const httpRequest = {
	listarDepartamentos()
	{
		return new Promise((resolve, reject) => {
			$.ajax({
				type: 'POST',
				url: '../Ubigeo?accion=listarDepartamento',
				success: function (data, textStatus, jqXHR) {
				$("#departamento").select2({
			placeholder: "SELECCIONÉ"
		});
					resolve(data)
					let printJson = ""
					printJson += "<option value=''>SELECCIONÉ</option>";
					for (var i in data.data) {
					
						printJson += "<option value='" + data.data[i].idDepa + "'>" + data.data[i].departamento + "</option>";
					}
					$("#departamento").html(printJson);
				},
				error: function (jqXHR, textStatus, errorThrown) {
					reject('Error en la petición')
				}, complete: function () {

					var config = {
						'.chosen-select': {},
						'.chosen-select-deselect': {allow_single_deselect: true},
						'.chosen-select-no-single': {disable_search_threshold: 10},
						'.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
						'.chosen-select-width': {width: "100%"}
					}
//					for (var selector in config) {
//						$(selector).chosen(config[selector]);
//					}
				}
			})
		})
	},BloqueoCombox(){
	
		 $("#provincia").attr('disabled', 'disabled');
		$("#distrito").attr('disabled', 'disabled');
	},cargarSelect() {
		$("#departamento").select2()
		$("#provincia").select2()
		$("#distrito").select2()
	}  
}
const SetElements = {
	init() {
		this.setToolTip();
	},
	setToolTip() {
		$('[data-toggle="tooltip"]').tooltip();
		
	}

}
$( "#departamento" ).change(function() {
let json={
	"idDep":$("#departamento").val()}
	$.ajax({
				type: 'POST',
				async: false,
				url: "../Ubigeo?accion=listarProvincia",
				dataType: 'JSON',
				data: {
					json: JSON.stringify(json)
				},beforeSend: function() {
//        cargando()
        },
				success: function (data) {
						$("#provincia").html('');
				$("#provincia").select2({
			placeholder: "SELECCIONÉ"
		});
					let printJson = ""
					printJson += "<option value=''>SELECCIONÉ</option>";
					for (var i in data.data) {
						printJson += "<option value='" + data.data[i][1] + "'>" + data.data[i][2] + "</option>";
					}
					$("#provincia").html(printJson);
				},complete(){
					var config = {
						'.chosen-select': {},
						'.chosen-select-deselect': {allow_single_deselect: true},
						'.chosen-select-no-single': {disable_search_threshold: 10},
						'.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
						'.chosen-select-width': {width: "100%"}
					}
					$("#provincia").removeAttr('disabled');
					$("#distrito").attr('disabled', 'disabled');
					$("#distrito").html('');
					$("#distrito").select2({
			placeholder: ""});
					
         }
			   })
});

$( "#provincia" ).change(function() {
let json={
	"idProv":$("#provincia").val()}
	$.ajax({
				type: 'POST',
				async: false,
				url: "../Ubigeo?accion=listarDistrito",
				dataType: 'JSON',
				data: {
					json: JSON.stringify(json)
				},beforeSend: function() {
//        cargando()
        },
				success: function (data) {
				$("#distrito").select2({
			placeholder: "SELECCIONÉ"
		});
		
					let printJson = ""
					printJson += "<option value=''>SELECCIONÉ</option>";
					for (var i in data.data) {
						printJson += "<option value='" + data.data[i][1] + "'>" + data.data[i][2] + "</option>";
					}
					$("#distrito").html(printJson);
				},complete(){
					var config = {
						'.chosen-select': {},
						'.chosen-select-deselect': {allow_single_deselect: true},
						'.chosen-select-no-single': {disable_search_threshold: 10},
						'.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
						'.chosen-select-width': {width: "100%"}
					}
					$("#distrito").removeAttr('disabled');
         }
			   })
});

init = () => {

httpRequest.listarDepartamentos();
httpRequest.cargarSelect();
SetElements.init();
httpRequest.BloqueoCombox();
	
}


init()




