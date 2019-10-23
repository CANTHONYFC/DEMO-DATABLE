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
public interface UbigeoDAO {
	

	public JSONObject ListarDepartamento()throws Exception;;

	public JSONObject ListarProvincia(JSONObject obj);
	public JSONObject listarDistrito(JSONObject obj);
	



		
		
	
}
