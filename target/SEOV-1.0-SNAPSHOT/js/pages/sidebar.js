


let getUrl = (pathname, caracter) => {
    let position = 0;
    for (let i = pathname.length - 1; i > 0; i--) {
        if (pathname[i] === caracter) {
            position = i;
            break;
        }
    }
    return position;
};
const httpRequest1 = {
    ListarMenu()
    {
        let location = window.location;
        let position = getUrl(location.pathname, "/");
        let path = location.pathname.substring(position + 1);//obtiene el nombre de la vista jsp para activar la clase .active
        let menu = document.getElementById("side-menu");
        let html = "";
        let active = "";
        let mod = -1;
        let cate = -1;
        let json = {
            "idProv": ""}
        let Menu = "";
        $.ajax({
            type: 'POST',
            async: false,
            url: "../Menu?accion=listarMenu",
            dataType: 'JSON',
            data: {
                json: JSON.stringify(json)
            }, beforeSend: function () {
//        cargando()
            },
            success: function (data) {

                let printJson = ""
                for (var i in data) {
                    let subMenu = data[i].data
                    let Menu = data[i].data1
                    let oli = data[i].data1[5]
                    if (data[i].data1[5] == 1) {

                        printJson += `<li><a href="` + data[i].data1[8]
                                + `"><i class="fa fa-globe"></i> <span class="nav-label">` + data[i].data1[6]`</span></a></li>`
                    } else {
                        let DibujarSubMenu = ""
                        for (var a = 0; a < subMenu.length; a++) {
                            if (path === subMenu[a][3]) {
                                active = 'active';
                            } else {
                                active = '';
                            }
                            DibujarSubMenu += `<li class="${active}" ><a href='` + subMenu[a][3] + `'>` + subMenu[a][6] + `</a></li>`
                        }
                        printJson += `<li class="${active}">
                    <a href="index.jsp"><i class="fa fa-th-large"></i> 
                    <span class="nav-label">` + data[i].data1[6]
                                + `</span> <span class="fa arrow"></span></a>
                   <ul class="nav nav-second-level collapse">`
                                + DibujarSubMenu +
                                `</ul>
            </li>`
                    }
//						printJson += "<option value='" + data.data[i][1] + "'>" + data.data[i][2] + "</option>";
                }
                menu.innerHTML += printJson;
            }, complete() {
            }
        })
        $('#side-menu').metisMenu();
    }
}
init = () => {

    httpRequest1.ListarMenu();

}




init()