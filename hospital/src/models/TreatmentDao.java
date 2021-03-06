package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.Controller;

public class TreatmentDao {
	
	private Controller controller;
	
	//QUERY ONE
	public String searchCost(TreatmentVo treatmentVo) {
		String result="";
		
		Connection connection = null;
		Connections connections = new Connections();
		PreparedStatement preStatement = null;
		
		connection=connections.giveMeConnection();
		String query="SELECT treatmentValue FROM treatment WHERE idTreatment = ?";
		
		try {
			preStatement = connection.prepareStatement(query);
			preStatement.setInt(1, treatmentVo.getIdTreatment());
			ResultSet resultTwo = preStatement.executeQuery();
			while(resultTwo.next()) {
				treatmentVo.setTreatmenValue(resultTwo.getDouble(1));
			}
			resultTwo.close();
			result="ok";
		}catch(SQLException e) {
			System.out.println("No se pudo registrar el dato: "+ e.getMessage());
			e.printStackTrace();
			result="error";
		}
		
		return treatmentVo.getTreatmenValue() + "";
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
