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

/**
 *
 * @author sistem16user
 */
public class MenuMysqlDao implements MenuDAO {
	@Override
	public JSONObject ListarMenu(JSONObject obj) {
		 JSONObject response = new JSONObject();
        boolean status = true;
		
        JSONArray lista;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String query = "{call PRO_LISTAR_MENU(?)}";
            JSONArray params = new JSONArray()
                    .put(obj.get("tipoUsuario"));

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
	public JSONObject ListarCategoria(JSONObject obj) {
		 JSONObject response = new JSONObject();
        boolean status = true;
		
        JSONArray lista;
        try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
            String query = "{call PRO_LISTAR_CATEGORIA(?)}";
            JSONArray params = new JSONArray()
                    .put(obj.get("tipoUsuario"));

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
