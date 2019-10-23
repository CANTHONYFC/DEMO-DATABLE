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
import seov.dao.MenuDAO;


/**
 *
 * @author sistem16user
 */
public class MenuService {

DAOFactory factoryMysql = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	MenuDAO daoMenu = factoryMysql.getMenu();
	

	
public JSONObject ListarMenu(JSONObject obj) {
		JSONObject retorno = null;
		try {
//			System.out.println(obj);
			retorno = daoMenu.ListarMenu(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
public JSONObject ListarCategoria(JSONObject obj) {
		JSONObject retorno = null;
		try {
//			System.out.println(obj);
			retorno = daoMenu.ListarCategoria(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	

}
