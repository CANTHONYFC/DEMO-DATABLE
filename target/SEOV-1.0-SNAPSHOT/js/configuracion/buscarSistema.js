var bandera = 0;

$("#top-search").keypress(function (e) {

    if (e.which == 13) {
			        var busqueda = $("#top-search").val();
        localStorage.setItem("busqueda", busqueda);
				window.location.href = 'BuscarPersonal.jsp'
	}
});

