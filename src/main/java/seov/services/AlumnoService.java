/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.services;

import org.json.JSONObject;
import seov.dao.DAOFactory;
import org.json.JSONArray;
import seov.dao.AlumnoDAO;

/**
 *
 * @author sistem16user
 */
public class AlumnoService {

    DAOFactory factoryMysql = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    AlumnoDAO daoAlumno = factoryMysql.getAlumno();

    public JSONObject RegistrarRespTest(JSONObject obj) {
        JSONObject retorno = null;
        try {
          retorno = daoAlumno.RegistraRespTest(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public JSONObject RegistrarAlumno(JSONObject obj) {
        JSONObject retorno = null;
        try {
//			System.out.println(obj);
            retorno = daoAlumno.RegistrarAlumno(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public JSONObject ListarEncuesta(JSONObject obj) {
        JSONObject retorno = null;
        try {
//			System.out.println(obj);
            retorno = daoAlumno.ListarEncuesta(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

}
