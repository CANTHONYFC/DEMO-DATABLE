const event = {
    validarUsuario() {
        var p_usuario = $('#txt_usuario').val();
        var p_password = $('#txt_contrasena').val();
        $.ajax({
            dataType: 'JSON',
            url: '../UsuarioValidacion?accion=validarUsuario',
            data: 'txt_usuario=' + p_usuario + '&txt_contrasena=' + p_password,
            beforeSend: function () {
//				cargando()
            },
            success: function (data) {

                var content = data.data
                var estadoC = data.estadoC

                if (content == 1) {
//														if(estadoC==0){
//														funciones.validarC(p_usuario)
//														}
//														else{
                    window.location = "Menu.jsp";
//															}
//                                $("#mensaje").fadeOut();
                    //ion.sound.play("cd_tray");
                } else {

                    swal({
                        title: "Error!",
                        text: "Usuario o contraseña incorrecto.",
                        type: "warning",
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "OK",
                        closeOnConfirm: true
                    }, function () {

                    });
                    $('#txt_contrasena').val("");
                    $('#txt_usuario').focus();

                }
            }, complete() {
//				cerrar_cargando()
            }
        });
    },
        ingresar(){
        $('#txt_usuario').focus();
        $("#txt_usuario").keyup(function (e) {
            if (e.keyCode == 13) {
                event.validarUsuario()
            }
        })
        $("#txt_contrasena").keyup(function (e) {
            if (e.keyCode == 13) {
                event.validarUsuario()
            }
        })

        $('#ingresar').click((e) => {

            event.validarUsuario()
        }
        )
    },
    cerrarmodal() {
        $('#cerrarmodal').click((e) => {
            $('#boton').removeClass('modal fade in');
            $('#basic_modal').addClass('modal fade');
            let elemento = document.getElementById("basic_modal")
            elemento.style.display = "none";

        })
    }, 
    validarCambio() {
        $('#confirmarCambio').click((e) => {
            var json = {
                "dni": document.getElementById('txt_usuario').value,
                "password": document.getElementById('password').value,
                "confirpassword": document.getElementById('confirmpassword').value}
            $.ajax({
                type: 'POST',
                async: false,
                url: "../UsuarioValidacion?accion=ValidarContra",
                dataType: 'JSON',
                data: {
                    json: JSON.stringify(json)
                },
                success: function (data) {
                    if (data.data == 1) {
                        window.location.href = "menu.jsp";
                    } else if (data.data == 3) {
                        alert("Tu contraseña debe ser diferente a tu usuario")

                    } else {
                        alert("Debes confirmar tu contraseña")
                    }
                }})
        })
    }}
const funciones = {
    validarC(p_usuario) {
        $('#boton').removeClass('modal fade');
        $('#basic_modal').addClass('modal fade in');
        let elemento = document.getElementById("basic_modal")
        elemento.style.display = "block";
        elemento.style.padding = "150px";
    },
    solonumero() {
    $('#txt_usuario').on('input', function () {
        this.value = this.value.replace(/[^0-9]/g, '');
    });

}
}
init = () => {
    event.ingresar()
    event.cerrarmodal()
    event.validarCambio()
} 
init()
		