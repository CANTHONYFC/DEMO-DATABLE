/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.services;

import org.json.JSONObject;
import seov.dao.DAOFactory;
import seov.dao.UsuarioDAO;
import seov.mysql.UsuarioMysqlDao;
import org.json.JSONArray;


/**
 *
 * @author sistem16user
 */
public class UsuarioService {

DAOFactory factoryMysql = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO daoUsuario=new UsuarioMysqlDao();
	

	public JSONObject validarUsuario(JSONObject obj) {
			JSONObject retorno = null;
		try {
//			System.out.println(obj);
			retorno = daoUsuario.ObtenerUsuario(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	
	public JSONObject ListarUsuarios(JSONObject obj) {
		JSONObject retorno = null;
		try {

//daoPersonaWebMysql.listadoPersonalWeb(obj).getJSONArray("data")
			retorno = daoUsuario.ListarUsuarios(obj);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public int contarUsuarios(JSONObject json) {
			int contador=0;
		try {

//daoPersonaWebMysql.listadoPersonalWeb(obj).getJSONArray("data")
			contador = daoUsuario.contarUsuarios(json);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contador;
	}
	
	
}
