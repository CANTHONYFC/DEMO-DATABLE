/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.dao;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sistem16user
 */
public interface UsuarioDAO {

	public JSONObject ObtenerUsuario(JSONObject obj);
	public JSONObject ListarUsuarios(JSONObject obj);

	public int contarUsuarios(JSONObject json);

	
}
