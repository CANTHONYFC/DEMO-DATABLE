/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.servlets;

import seov.services.MenuService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.ws.rs.client.Entity.json;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sistem16user
 */
public class Menu extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listarMenu":
                listarMenu(response, request);
                break;
            case "paginaMenuSession":
                paginaMenuSession(response, request);
                break;
            default:
        }
    }

    private void listarMenu(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<JSONObject> listResults = new ArrayList<JSONObject>();
            MenuService srv = new MenuService();
            String dibujar = request.getParameter("draw");
            String jsonString = request.getParameter("json");

            HttpSession session_actual = request.getSession(true);
            int tipoUsuario = Integer.parseInt(session_actual.getAttribute("TipoUsu").toString());
            JSONObject json = new JSONObject(jsonString);
            json.put("tipoUsuario", tipoUsuario);
            JSONObject jsonlistado = srv.ListarMenu(json);
            JSONObject jsonlistadoCategoria = srv.ListarCategoria(json);

            JSONArray jsonArray = jsonlistado.getJSONArray("data");
            JSONArray jsonArray1 = jsonlistadoCategoria.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject conjuntoCategorias = new JSONObject();
                JSONObject jsons = jsonArray.getJSONObject(i);
                conjuntoCategorias.put("data1", jsons);
                ArrayList<JSONObject> submenu = new ArrayList<JSONObject>();
                for (int a = 0; a < jsonArray1.length(); a++) {
                    JSONObject jsons2 = jsonArray1.getJSONObject(a);
                    if (jsons.getInt("4") == jsons2.getInt("1")) {
                        submenu.add(jsons2);
                    } else {
                    }
                    conjuntoCategorias.put("data", submenu);
                }
                listResults.add(conjuntoCategorias);
            }
            JSONObject[] jsonsFinally = new JSONObject[listResults.size()];
            listResults.toArray(jsonsFinally);
            System.out.println("" + listResults);
            out.println(listResults);
        }
    }

//		
//	private void MenuLateral(HttpServletResponse response, HttpServletRequest request) throws IOException {
//   response.setContentType("application/json");
//				try(PrintWriter out = response.getWriter()){
//				 HttpSession session_actual = request.getSession(true);
//					 int Dni=Integer.parseInt(session_actual.getAttribute("dni").toString());
//					
//					ArrayList<JSONObject> listResults = new ArrayList<JSONObject>();
//        TabletService  srv = new TabletService ();
//				JSONObject jsonTablet=new JSONObject()
//					.put("dniUsuario", Dni);
//        String jsonString = jsonTablet.toString();
//        JSONObject json = new JSONObject(jsonString);
//     
//        JSONObject jsonlistado = srv.RutasTablet(json);
//				JSONArray jsonArray =jsonlistado.getJSONArray("data");
//	 for(int i=0;i<jsonArray.length();i++){
//            JSONObject jsons = jsonArray.getJSONObject(i);
//           JSONObject jsonPadre=new JSONObject()
//						   .put("Acceso", jsons.getInt("5"))
//					     .put("dniUsuario", Dni);
//							 JSONObject jsonlistadoCategorias = srv.CategoriaRutasTablet(jsonPadre);
//							jsonlistadoCategorias.put("nombre",jsons.getString("4"));
//					 	jsonlistadoCategorias.put("iddet",jsons.getInt("6"));
//							listResults.add(jsonlistadoCategorias);
//	 }
//	 JSONObject[] jsonsFinally= new JSONObject[listResults.size()];
//listResults.toArray(jsonsFinally);
//					System.out.println(listResults);
//	out.println(listResults);  
//	}
//}
    private void paginaMenuSession(HttpServletResponse response, HttpServletRequest request) {
//        String codTitulo = request.getParameter("codTit");
//        String codModulo = request.getParameter("codMod");
//        String codCategoria = request.getParameter("codCat");
//        String codSubCategoria = request.getParameter("codSub");
//        String CategoriaEstado = request.getParameter("estado");
//        HttpSession session_actual = request.getSession(true);
//        
//        Menu menu = new Menu();
//        menu.setCodigoTitulo(codTitulo);
//        menu.setCodigoModulo(codModulo);
//        menu.setCodigoCategoria(codCategoria);
//        menu.setCodigoSubCategoria(codSubCategoria);
//        menu.setEstadoCategoria(CategoriaEstado);
//        
//        session_actual.setAttribute("menu",menu);
    }
}
