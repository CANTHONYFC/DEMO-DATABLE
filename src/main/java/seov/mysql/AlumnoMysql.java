/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.mysql;

import seov.dao.MenuDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;
import seov.dao.UbigeoDAO;
import seov.mysql.MySqlDAOFactory;
import seov.utilities.DAOHelper;
import seov.utilities.OsUtils;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.DriverManager;
import java.sql.Statement;
import seov.dao.AlumnoDAO;

/**
 *
 * @author sistem16user
 */
public class AlumnoMysql implements AlumnoDAO {

    @Override
    public JSONObject RegistraRespTest(JSONObject obj) throws Exception {
        JSONObject response = new JSONObject();
        boolean status = true;

        JSONArray lista;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String dni = obj.getString("dni");
            JSONArray respuestas = obj.getJSONArray("respuestas");
            System.out.println(respuestas);
            for (int i = 0; i < respuestas.length(); i++) {

                JSONObject jsonRespuesta = respuestas.getJSONObject(i);

                String query = "{call PRO_REG_PUNTAJE_PREGUNTA(?,?,?)}";
                JSONArray params = new JSONArray()
                        .put(dni)
                        .put(jsonRespuesta.get("id"))
                        .put(jsonRespuesta.get("resp"));

                lista = DAOHelper.queryProcedure(cn, query, true, params);

                response.put("data", lista);

                response.put("message", "Se listaron correctamente");
            }

        } catch (Exception e) {
            e.printStackTrace();
            status = false;
            response.put("message", "Error en el proceso");
        }

        response.put("status", status);
        return response;
    }

    public JSONObject RegistrarAlumno(JSONObject obj) {
        JSONObject response = new JSONObject();
        boolean status = true;

        JSONArray lista;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String query = "{call PRO_REGISTRAR_ALUMNO(?,?,?,?,?,?,?,?,?)}";
            JSONArray params = new JSONArray()
                    .put(obj.get("documento"))
                    .put(obj.get("apellidoPat"))
                    .put(obj.get("apellidomMat"))
                    .put(obj.get("nombre"))
                    .put(obj.get("sexo"))
                    .put(obj.get("fechaNaci"))
                    .put(obj.get("distrito"))
                    .put(obj.get("email"))
                    .put(obj.get("telefono"));

            lista = DAOHelper.queryProcedure(cn, query, true, params);

            response.put("data", lista);

            response.put("message", "Se listaron correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
            response.put("message", "Error en el proceso");

        }

        response.put("status", status);
        return response;
    }

    public JSONObject ListarEncuesta(JSONObject obj) {
        JSONObject response = new JSONObject();
        boolean status = true;

        JSONArray lista;
        JSONArray puntajes;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String query = "{call PRO_LISTAR_ENCUESTA(?)}";
            JSONArray params = new JSONArray()
                    .put(obj.get("documento"));

            lista = DAOHelper.queryProcedure(cn, query, true, params);

            response.put("data", lista);

            String queryPuntajes = "{call PRO_LISTAR_PUNTAJES()}";
            JSONArray puntajesparams = new JSONArray();

            puntajes = DAOHelper.queryProcedure(cn, queryPuntajes, true, puntajesparams);

            response.put("puntajes", puntajes);

            response.put("message", "Se listaron correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
            response.put("message", "Error en el proceso");

        }

        response.put("status", status);
        return response;
    }

}
