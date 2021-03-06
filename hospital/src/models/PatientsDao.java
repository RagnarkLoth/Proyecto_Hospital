package models;

import java.sql.*;
import controllers.Controller;

public class PatientsDao {
	private Controller controller;
	//INSERT
	public String insert(PatientsVo patientsVo) {
		String result="";
		
		Connection connection = null;
		Connections connections = new Connections();
		PreparedStatement preStatement = null;
		
		connection=connections.giveMeConnection();
		String query="INSERT INTO patients VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(query);
			preStatement.setInt(1,0);
			preStatement.setString(2, patientsVo.getNamee());
			preStatement.setString(3, patientsVo.getDocument());
			preStatement.setString(4, patientsVo.getDirection());
			preStatement.setString(5, patientsVo.getTelephone());
			preStatement.setString(6, patientsVo.getOperator());
			preStatement.setInt(7, patientsVo.getDaysHospitalization());
			preStatement.setDouble(8, patientsVo.getDrugCost());
			preStatement.setDouble(9, patientsVo.getTotalPay());
			preStatement.setString(10, patientsVo.getCompanyName());
			preStatement.setDouble(11, patientsVo.getCostOfTreatment());
			preStatement.setInt(12, patientsVo.getIdTreatmentFK());
			preStatement.execute();
			
			result="ok";
		}catch(SQLException e) {
			System.out.println("No se pudo registrar el dato: "+ e.getMessage());
			e.printStackTrace();
			result="error";
		}
		
		return result;
	}
	

	//CHECK ALL
	public String[][] checkAll(PatientsVo patientsVo) {
		Connection connection = null;
		Connections connections = new Connections();
		PreparedStatement preStatement = null;
		int size = 0;
		connection = connections.giveMeConnection();
		String[][] dataTable = new String[controller.tableSize()][10];
		String query="SELECT namee,document, direction, telephone, operator, daysHospitalization, drugCost, companyName, costOfTreatment, totalPay  FROM patients";
		try {
			preStatement = connection.prepareStatement(query);
			ResultSet resultTwo = preStatement.executeQuery();
			while(resultTwo.next()) {
				patientsVo.setNamee(resultTwo.getString(1));
				dataTable[size][0] = patientsVo.getNamee();
				
				patientsVo.setDocument(resultTwo.getString(2));
				dataTable[size][1] = patientsVo.getDocument();
							
				patientsVo.setDirection(resultTwo.getString(3));
				dataTable[size][2] = patientsVo.getDirection();

				patientsVo.setTelephone(resultTwo.getString(4));
				dataTable[size][3] = patientsVo.getTelephone();

				patientsVo.setOperator(resultTwo.getString(5));
				dataTable[size][4] = patientsVo.getOperator();

				patientsVo.setDaysHospitalization(resultTwo.getInt(6));
				dataTable[size][5] = patientsVo.getDaysHospitalization() + "";
				
				patientsVo.setDrugCost(resultTwo.getDouble(7));
				dataTable[size][6] = patientsVo.getDrugCost() + "";
				
				patientsVo.setCompanyName(resultTwo.getString(8));
				dataTable[size][7] = patientsVo.getCompanyName();
				
				patientsVo.setCostOfTreatment(resultTwo.getDouble(9));
				dataTable[size][8] = patientsVo.getCostOfTreatment() + "";
				
				patientsVo.setTotalPay(resultTwo.getDouble(10));
				dataTable[size][9] = patientsVo.getTotalPay() + "";

				size++;
			}
		}catch(SQLException e) {
			System.out.println("No se pudo consultar los datos: "+ e.getMessage());
			e.printStackTrace();
		}
		
		return dataTable;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}


	public int tableSize() {
		int result = 0;
		
		Connection connection = null;
		Connections connections = new Connections();
		PreparedStatement preStatement = null;

		connection = connections.giveMeConnection();
		String query="SELECT COUNT(*)  FROM patients";
		try {
			preStatement = connection.prepareStatement(query);
			ResultSet resultTwo = preStatement.executeQuery();
			while(resultTwo.next()) {
				result = resultTwo.getInt(1);
			}
			resultTwo.close();
		}catch(SQLException e) {
			System.out.println("No se pudo consultar los datos: "+ e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	//CHECK ONE
	public String checkOne(PatientsVo patientsVo){
		String result = "";
		Connection connection = null;
		Connections connections = new Connections();
		PreparedStatement preStatement = null;
		connection = connections.giveMeConnection();
		String query="SELECT namee,document, direction, telephone, operator, daysHospitalization, drugCost, companyName, costOfTreatment, totalPay  FROM patients WHERE document=?";
		try {
			preStatement = connection.prepareStatement(query);
			preStatement.setString(1, patientsVo.getDocument());
			ResultSet resultTwo = preStatement.executeQuery();
			while(resultTwo.next()) {
				patientsVo.setNamee(resultTwo.getString(1));				
				patientsVo.setDocument(resultTwo.getString(2));							
				patientsVo.setDirection(resultTwo.getString(3));
				patientsVo.setTelephone(resultTwo.getString(4));
				patientsVo.setOperator(resultTwo.getString(5));
				patientsVo.setDaysHospitalization(resultTwo.getInt(6));			
				patientsVo.setDrugCost(resultTwo.getDouble(7));				
				patientsVo.setCompanyName(resultTwo.getString(8));				
				patientsVo.setCostOfTreatment(resultTwo.getDouble(9));				
				patientsVo.setTotalPay(resultTwo.getDouble(10));
			}
			result = "ok";
		}catch(SQLException e) {
			System.out.println("No se pudo consultar los datos: "+ e.getMessage());
			e.printStackTrace();
			result = "error";
		}
		return result;
	}
	
	//CHECK DOCUMENT
	public String verifyDocument(String tfDocument) {
		String result = "";
		Connection connection = null;
		Connections connections = new Connections();
		PreparedStatement preStatement = null;
		connection = connections.giveMeConnection();
		String query="SELECT namee  FROM patients WHERE document=?";
		try {
			preStatement = connection.prepareStatement(query);
			preStatement.setString(1, tfDocument);
			ResultSet resultTwo = preStatement.executeQuery();
			while(resultTwo.next()) {
				String document = resultTwo.getString(1);
				if(document.equals("")) {
					result = "error";
				}else{
					result = "ok";
				}
			}
		}catch(SQLException e) {
			System.out.println("No se pudo consultar los datos: "+ e.getMessage());
			e.printStackTrace();
			result = "error";
		}
		return result;
	}
}
