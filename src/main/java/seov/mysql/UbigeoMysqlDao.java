/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.mysql;

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

/**
 *
 * @author sistem16user
 */
public class UbigeoMysqlDao implements UbigeoDAO {

	@Override
	public JSONObject ListarDepartamento() throws Exception {
		JSONObject response = new JSONObject();
		boolean status = true;
		JSONArray listado = null;
		try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
			String query = "{call PRO_LISTAR_DEPARTAMENTOS()}";
			listado = DAOHelper.queryProcedure(cn, query, false);
			response.put("message", "Se listaron correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			response.put("message", "Error en el proceso");
		}
		response.put("data", listado);
		response.put("status", status);
		return response;
	}	

	@Override
	public JSONObject ListarProvincia(JSONObject obj) {
		 JSONObject response = new JSONObject();
        boolean status = true;
		
        JSONArray lista;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String query = "{call PRO_LISTAR_PROVINCIAS(?)}";
            JSONArray params = new JSONArray()
                    .put(obj.get("idDep"));

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
	@Override
	public JSONObject listarDistrito(JSONObject obj) {
		 JSONObject response = new JSONObject();
        boolean status = true;
		
        JSONArray lista;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String query = "{call PRO_LISTAR_DISTRITO(?)}";
            JSONArray params = new JSONArray()
                    .put(obj.get("idProv"));

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
	

}
