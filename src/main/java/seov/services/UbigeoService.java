/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.services;


import org.json.JSONObject;
import seov.dao.DAOFactory;
import seov.dao.UbigeoDAO;
import org.json.JSONArray;


/**
 *
 * @author sistem16user
 */
public class UbigeoService {

DAOFactory factoryMysql = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UbigeoDAO daoUbigeo = factoryMysql.getUbigeo();
	

	public JSONObject ListarDepartamento() {
				JSONObject retorno = null;
		try {
//			System.out.println(obj);
			retorno = daoUbigeo.ListarDepartamento();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
public JSONObject ListarProvincia(JSONObject obj) {
		JSONObject retorno = null;
		try {
//			System.out.println(obj);
			retorno = daoUbigeo.ListarProvincia(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
public JSONObject listarDistrito(JSONObject obj) {
		JSONObject retorno = null;
		try {
//			System.out.println(obj);
			retorno = daoUbigeo.listarDistrito(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
}
