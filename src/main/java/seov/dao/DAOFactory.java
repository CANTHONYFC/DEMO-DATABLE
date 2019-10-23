/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seov.dao;

import seov.mysql.MySqlDAOFactory;


/**
 *
 * @author sistem16user
 */
public abstract class DAOFactory {
	

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySqlDAOFactory();
          
            default:
                return null;
        }
    }
		
		public abstract UbigeoDAO getUbigeo();
			public abstract MenuDAO getMenu();
	public abstract UsuarioDAO getUsuario();
	public abstract AlumnoDAO getAlumno();
			 }


