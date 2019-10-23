/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.servlets;

import seov.services.UbigeoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author sistem16user
 */
public class Ubigeo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String accion = request.getParameter("accion");
		switch (accion) {
			case "listarDepartamento":
				listarDepartamento(response, request);
				break;
		case "listarProvincia":
				listarProvincia(response, request);
				break;
		case "listarDistrito":
				listarDistrito(response, request);
				break;
			default:
		}
	}

	private void listarDepartamento(HttpServletResponse response, HttpServletRequest request) throws IOException {
			response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		UbigeoService srv = new UbigeoService();
		JSONObject rs = srv.ListarDepartamento();
		out.println(rs);
	}
	
	private void listarProvincia(HttpServletResponse response, HttpServletRequest request) throws IOException {
	 response.setContentType("application/json");
				try(PrintWriter out = response.getWriter()){
        UbigeoService  srv = new UbigeoService ();
        String dibujar = request.getParameter("draw");
				   String jsonString = request.getParameter("json");
        JSONObject json = new JSONObject(jsonString);
        JSONObject jsonlistado = srv.ListarProvincia(json);
			  JSONObject jsonImprimir = new JSONObject();
        jsonImprimir.put("data", jsonlistado.get("data"));
        jsonImprimir.put("draw", dibujar);
        out.println(jsonImprimir);   
	}	
	}
	private void listarDistrito(HttpServletResponse response, HttpServletRequest request) throws IOException {
	 response.setContentType("application/json");
				try(PrintWriter out = response.getWriter()){
        UbigeoService  srv = new UbigeoService ();
        String dibujar = request.getParameter("draw");
				   String jsonString = request.getParameter("json");
        JSONObject json = new JSONObject(jsonString);
        JSONObject jsonlistado = srv.listarDistrito(json);
			  JSONObject jsonImprimir = new JSONObject();
        jsonImprimir.put("data", jsonlistado.get("data"));
        jsonImprimir.put("draw", dibujar);
        out.println(jsonImprimir);   
	}	
	}

}
