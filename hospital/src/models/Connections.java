package models;

import controllers.Controller;
import java.sql.*;

public class Connections {
	
	private Controller controller;
	
	Connection myConnection = null;
	String result = "";
	
	public Connection giveMeConnection() {
		
		try {
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost/hospital?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		
			result = "Se pudo conectar a la base de datos";
		} catch (SQLException e) {
			
			result = "No conecta a la base de datos";
			e.printStackTrace();
		}
		return myConnection;
	}
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
