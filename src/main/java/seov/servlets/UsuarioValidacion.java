    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.servlets;

import seov.services.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sistem16user
 */
public class UsuarioValidacion extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String accion = request.getParameter("accion");
		switch (accion) {
			case "validarUsuario":
				validarUsuario(response, request);
				break;
			case "ListarUsuarios":
				ListarUsuarios(response, request);
				break;
			case "InfoUsuario":
				InfoUsuario(response, request);
				break;
			default:
		}
	}

	private void validarUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("application/json");
		try (PrintWriter out = response.getWriter()) {
			UsuarioService servicio = new UsuarioService();
			int valor = 0;
			int estadoLogeo = 0;
			String usuario =request.getParameter("txt_usuario").toString();
			String password = request.getParameter("txt_contrasena");
			JSONObject jsonUsuario = new JSONObject()
				.put("dni", usuario)
				.put("password", password);
			String jsonString = jsonUsuario.toString();
			JSONObject json = new JSONObject(jsonString);
			JSONObject jsonlistado = servicio.validarUsuario(json);
			JSONArray jsonArray = jsonlistado.getJSONArray("data");
			JSONObject jsonImprimir = new JSONObject();
			if (jsonArray.length() == 0) {
				jsonImprimir.put("data", 0);
			} else {
				System.out.println("json usuario mysql" + jsonArray.getJSONObject(0));
				JSONObject jsons = jsonArray.getJSONObject(0);
				valor = jsons.getInt("1");
				estadoLogeo = jsons.getInt("5");
				PrintWriter pw = response.getWriter();
				if (valor == 0) {
					jsonImprimir.put("data", valor);
				} else if (valor == 1) {
//					if (estadoLogeo == 0) {
//						//aqui se enviara el correo por primera vez a dirage
////						MailSender mail = new MailSender();
//						Date date = new Date();
//						DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
//						String Mensaje = "<html><body><p>El usuario ha iniciado sesión exitosamente.</p>"
//							+ "<p>DNI :" + usuario + "</p>"
//							+ "<p>USUARIO: " + jsons.getString("2")+"</p>"
//							+ "<P>FECHA: "+hourdateFormat.format(date)+"</P>"
//							+ "</body></html>";
//						JSONObject body = new JSONObject()
//							.put("destino","coordinador.academico@sacooliveros.edu.pe" )
//							.put("asunto","[Trismegisto Académico - Inicio de Sesión] " )
//							.put("mensaje", Mensaje);
//						MailSender.enviarCorreo(body);
////						mail.send("canchivilca.ti@sacooliveros.edu.pe", "[Trismegisto Académico - Inicio de Sesión] ", Mensaje);
//						servicio.actualizarEstadoLogeo(jsonUsuario);
//					} else {
//					}
					int estadoC = jsons.getInt("4");
					if (estadoC == 0) {
						jsonImprimir.put("data", valor);
						jsonImprimir.put("estadoC", estadoC);
					} else {
						HttpSession session_actual = request.getSession(true);
						session_actual.setAttribute("dni", usuario);
						session_actual.setAttribute("NombreCompleto", jsons.getString("2"));
						session_actual.setAttribute("TipoUsu", jsons.getInt("3"));
						
						session_actual.setMaxInactiveInterval(10 * 60 * 60); // 10 horas
						jsonImprimir.put("data", valor);
					}
				}

			}
			out.println(jsonImprimir);

		}

	}
	
		private void InfoUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("application/json");
		HttpSession session_actual = request.getSession(true);
		String Apellidos = session_actual.getAttribute("NombreCompleto").toString();
		JSONObject jsonImprimir = new JSONObject();
		jsonImprimir.put("Apellidos", Apellidos);
		try (PrintWriter out = response.getWriter()) {
			out.println(jsonImprimir);

		}

	}
		
		
			private void ListarUsuarios(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("application/json");
		try (PrintWriter out = response.getWriter()) {

	UsuarioService serv = new UsuarioService();
			String dibujar = request.getParameter("draw");
			String jsonString = request.getParameter("json");

			JSONObject json = new JSONObject(jsonString)
				.put("length", Integer.parseInt(request.getParameter("length")))
				.put("start", Integer.parseInt(request.getParameter("start")));

			int cantidadRegistros = 0;
			JSONObject jsonlistado = serv.ListarUsuarios(json);
			JSONObject jsonImprimir = new JSONObject();

			cantidadRegistros = serv.contarUsuarios(json);
			
			jsonImprimir.put("data", jsonlistado.get("data"));
			jsonImprimir.put("draw", dibujar);
			jsonImprimir.put("recordsFiltered", cantidadRegistros);
			jsonImprimir.put("recordsTotal", cantidadRegistros);
			out.println(jsonImprimir);
		}
	}
		
		
		
}