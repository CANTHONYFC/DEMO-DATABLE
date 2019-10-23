
const httpRequestgeneral = {
	GenerarDataSidebar(){
	$.ajax({
			type: 'POST',
			url: "../UsuarioValidacion?accion=InfoUsuario",
			dataType: 'JSON',
			success: function (data) {
	$('.ta-avatar').attr('avatar', data.Apellidos.charAt(0));
  var td=`
	<a href="javascript:void(0)" class="info" data-profile="open-menu">
	<span>${data.Apellidos}</span></a>`
	$("#nombreUsuario").html(td)							
		generarLetraCircular()
}})}
}

init = () => {
httpRequestgeneral.GenerarDataSidebar();	
}

init()




