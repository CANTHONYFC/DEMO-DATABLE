package seov.mysql;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import seov.dao.AlumnoDAO;
import seov.dao.DAOFactory;
import seov.dao.UsuarioDAO;
import seov.dao.MenuDAO;
import seov.dao.UbigeoDAO;
import seov.utilities.OsUtils;





public class MySqlDAOFactory extends DAOFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection obtenerConexion(String base) {
		Dotenv dotenv = Dotenv
			.configure()
			.directory(OsUtils.getDotEnvPath("seov"))
			.load();

		Connection connection = null;

		if (base=="seov") {
			String host = dotenv.get("UBIGEO_DB_HOST");
			String port = dotenv.get("UBIGEO_DB_PORT");
			String databaseName = dotenv.get("UBIGEO_DB_NAME");
			String userSgbd = dotenv.get("UBIGEO_DB_USER");
			String passwordSgbd = dotenv.get("UBIGEO_DB_PASS");
			try {
				connection = DriverManager.getConnection(
					"jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&noAccessToProcedureBodies=true",
					userSgbd,
					passwordSgbd);
//				System.out.println("se conecto");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	


	public UbigeoDAO getUbigeo() {
return new UbigeoMysqlDao();
	}

	@Override
	public MenuDAO getMenu() {
		return new MenuMysqlDao();
	}

	public UsuarioDAO getUsuario() {
		return new UsuarioMysqlDao();
	}
	public  AlumnoDAO getAlumno(){
	return new AlumnoMysql();
	
	}
	









}



