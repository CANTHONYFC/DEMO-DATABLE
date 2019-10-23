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

import seov.dao.UsuarioDAO;
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
public class UsuarioMysqlDao implements UsuarioDAO {
		
	public JSONObject ObtenerUsuario(JSONObject obj) {
		JSONObject response = new JSONObject();
		boolean status = true;
		JSONArray lista;
		try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
			String query = "{call PRO_VALIDAR_USUARIO(?,?)}";

			JSONArray params = new JSONArray()
				.put(obj.get("dni"))
				.put(obj.get("password"));

			lista = DAOHelper.queryProcedure(cn, query, true, params);
			response.put("data", lista);
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			response.put("message", "Error en el proceso");

		}

		response.put("status", status);
		return response;
	}
	public JSONObject ListarUsuarios(JSONObject obj) {
		JSONObject response = new JSONObject();
		boolean status = true;
		JSONArray lista;
		try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
			String query = "{call PRO_LISTAR_USUARIOS(?,?,?,?)}";

			JSONArray params = new JSONArray().put(obj.get("start"))
                    .put(obj.get("length"))
                    .put(obj.get("cbfiltro"))
                    .put(obj.get("busqueda"));

			lista = DAOHelper.queryProcedure(cn, query, true, params);
			response.put("data", lista);
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			response.put("message", "Error en el proceso");

		}

		response.put("status", status);
		return response;
	}
	public int contarUsuarios(JSONObject obj) {
		JSONObject response = new JSONObject();
		boolean status = true;
		int cantidad=0;
		JSONArray lista;
		try (Connection cn = MySqlDAOFactory.obtenerConexion("seov")) {
			String query = "{call PRO_CONTAR_USUARIOS()}";

			JSONArray params = new JSONArray();

			lista = DAOHelper.queryProcedure(cn, query, true, params);
			
			
			  if (lista.length() != 0) {
                cantidad = lista.getJSONObject(0).getInt("1");
            } else {
                System.out.println("no ay registros disponibles");
            }
			response.put("data", lista);
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			response.put("message", "Error en el proceso");

		}

		response.put("status", status);
		return cantidad;
	}

}
