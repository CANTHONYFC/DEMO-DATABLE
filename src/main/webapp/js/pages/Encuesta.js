/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const httpRequestRegistrarTestKunder = {
    ListarEncuesta(){
	let json={}
		$.ajax({
			type: 'POST',
			url: "../Alumno?accion=ListarEncuesta",
			dataType: 'JSON',
			data:  {
					json: JSON.stringify(json)
				},
			success: function (data) {
				//aqui el status
//				debugger;
				var encuesta=" "
				//recorrer el for de dataa.puntaje
//				for()
				for(var i in data.data){
					
		    encuesta+=`<div class="ibox float-e-margins">
                        <div class="ibox-title  back-change">
                        <h5>${data.data[i][2]}</h5>
                        <span class="text-danger"> (*)</span>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                           
                            </div>
                        </div>
                        <div class="ibox-content">
                           	<div style="width: 80%">
	                   <div class="i-checks" ><label> <input type="radio" id="${data.data[i][1]}" name="${data.data[i][1]}"  value="1" checked> <i></i>ME DESAGRADA MUCHO</label></div>
			   <div class="i-checks" ><label> <input type="radio" id="${data.data[i][1]}" name="${data.data[i][1]}"  value="2" > <i></i>NO ME GUSTA</label></div>
                           <div class="i-checks" ><label> <input type="radio" id="${data.data[i][1]}" name="${data.data[i][1]}"  value="3" > <i></i>ME ES INDIFERENTE</label></div>
                           <div class="i-checks" ><label> <input type="radio" id="${data.data[i][1]}" name="${data.data[i][1]}"  value="4" > <i></i>ME GUSTA</label></div>
                           <div class="i-checks" ><label> <input type="radio" id="${data.data[i][1]}" name="${data.data[i][1]}"  value="5" > <i></i>ME GUSTA MUCHO</label></div>
			</div>
                           
                        </div>
                    </div>`
				}
			$( "#listaEncuesta" ).html(encuesta);
			
			  $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
				
				
			}})
	
	
	
	
	
		
},
    RegistrarTestKunder(){
        $("#btnRegistrarTestKunder").click(function () {
            jQuery.validator.addMethod("lettersonly", function (value, element) {
				return this.optional(element) || /^[a-zAZ_áéíóúñ\s]+$/i.test(value);
			}, "");  
            var validator = $("#formularioTestKunder").validate({
                rules:{
                    1: { required: true },
                    2: { required: true },
                    3: { required: true },
                    4: { required: true },
                    5: { required: true },
                    6: { required: true },
                    7: { required: true },
                    8: { required: true },
                    9: { required: true },
                    10: { required: true },
                    11: { required: true },
                    12: { required: true },
                    13: { required: true },
                    14: { required: true },
                    15: { required: true },
                    16: { required: true },
                    17: { required: true },
                    18: { required: true },
                    19: { required: true },
                    20: { required: true },
                    22: { required: true },
                    23: { required: true },
                    24: { required: true },
                    25: { required: true },
                    26: { required: true },
                    27: { required: true },
                    28: { required: true },
                    29: { required: true },
                    30: { required: true },
                    31: { required: true },
                    32: { required: true },
                    33: { required: true },
                    34: { required: true },
                    35: { required: true },
                    36: { required: true },
                    37: { required: true },
                    38: { required: true },
                    39: { required: true },
                    40: { required: true },
                    41: { required: true },
                    42: { required: true },
                    43: { required: true },
                    44: { required: true },
                    45: { required: true },
                    46: { required: true },
                    47: { required: true },
                    48: { required: true },
                    49: { required: true },
                    50: { required: true },
                    51: { required: true },
                    52: { required: true },
                    53: { required: true },
                    54: { required: true },
                    55: { required: true },
                    56: { required: true },
                    57: { required: true },
                    58: { required: true },
                    59: { required: true },
                    60: { required: true }
                }
            });
            var validador = validator.form()
//            $('#1').parent().parent().parent().parent().append(document.getElementById('1-error'))
            
            for (let i = 1; i <= 60; i++){
               $('#'+i+'').parent().parent().parent().parent().append(document.getElementById(''+i+'-error')) 
            }
            
            if (validador) {
		    EventTestKunder.RegistrarTestKunder()
	    }
        });
    }
}

const EventTestKunder = {
    RegistrarTestKunder(){
        
                let dni = '2'
//                let respPreguntas = new Array()
                let jsonRespPreguntas = []
		for (let i = 0; i < 60; i++){
                    let arr = $('[name="'+(i+1)+'"]:checked').map(function () {
			return this.value;
		    }).get();
		    let respuesta = parseInt(arr.join(''));
//                    respPreguntas[i] = respuesta
                    let json = {id: (i+1), resp: respuesta}
                    jsonRespPreguntas[i] = json
                }
		let json = {		
			"respuestas": jsonRespPreguntas,
			"dni": dni
		}
                json = JSON.stringify(json)
		$.ajax({
			type: 'POST',
			url: "../Alumno?accion=RegistrarTest",
			dataType: 'JSON',
			data:  {
					json: json
				},
			success: function (data) {
				//aqui el status
			}})
    }
}

init = () => {
httpRequestRegistrarTestKunder.ListarEncuesta()
httpRequestRegistrarTestKunder.RegistrarTestKunder()
//EventTestKunder.RegistrarTestKunder()
}

init()



