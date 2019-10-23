/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import seov.services.AlumnoService;
import seov.services.UbigeoService;

/**
 *
 * @author sistem16user
 */
public class Alumno extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "RegistrarAlumno":
                RegistrarAlumno(response, request);
                break;
            case "ListarEncuesta":
                ListarEncuesta(response, request);
                break;

            case "RegistrarTest":
                RegistrarTest(response, request);
                break;

            default:
        }
    }

    private void RegistrarTest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session_actual = request.getSession(true);
            int dni = Integer.parseInt(session_actual.getAttribute("dni").toString());
            String jsonString = request.getParameter("json");
            JSONObject json = new JSONObject(jsonString);
            System.out.println(json);
            AlumnoService srv = new AlumnoService();
            JSONObject jsonResp =  srv.RegistrarRespTest(json);
        }
    }

    private void RegistrarAlumno(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            AlumnoService srv = new AlumnoService();
            String dibujar = request.getParameter("draw");
            String jsonString = request.getParameter("json");
            JSONObject json = new JSONObject(jsonString);
            JSONObject jsonlistado = srv.RegistrarAlumno(json);
            JSONObject jsonImprimir = new JSONObject();
            jsonImprimir.put("data", jsonlistado.get("data"));
            jsonImprimir.put("draw", dibujar);
            out.println(jsonImprimir);
        }
    }

    private void ListarEncuesta(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session_actual = request.getSession(true);
            int dni = Integer.parseInt(session_actual.getAttribute("dni").toString());
            AlumnoService srv = new AlumnoService();
            String dibujar = request.getParameter("draw");
            String jsonString = request.getParameter("json");
            JSONObject json = new JSONObject(jsonString)
                    .put("documento", dni);
            JSONObject jsonlistado = srv.ListarEncuesta(json);
            JSONObject jsonImprimir = new JSONObject();
            jsonImprimir.put("data", jsonlistado.get("data"));
            jsonImprimir.put("puntaje", jsonlistado.get("puntajes"));
            out.println(jsonImprimir);
        }
    }

}
