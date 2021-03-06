package models;

import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import controllers.Controller;

public class Processes {
	private Controller controller;
	
	public String validateFields(String tfName, String tfDirection ,String tfDocument, String tfPhone, Object cbTypeUsed,
			String tfCompanyName, String tfDays, String tfDrugsCosts, Object cbTreatment, String tfCostOfTreatment,
			String tfTotalPay) {
		String result = "";
		if(tfName.equals("") || tfDirection.equals("") || tfDocument.equals("") || tfPhone.equals("") || cbTypeUsed.equals("TIPO") || tfCompanyName.equals("") || tfDays.equals("") || tfDrugsCosts.equals("") || cbTreatment.equals("TRATAMIENTO") || tfCostOfTreatment.equals("")) {
			result = "error";
		}else if (tfTotalPay.equals("")) {
			result = "error_dos";	
		}else {
			result = "ok";
		}
		return result;
	}


	public Object saveData(String tfName, String tfDirection ,String tfDocument, String tfPhone, Object cbTypeUsed, String tfCompanyName,
			String tfDays, String tfDrugsCosts, Object cbTreatment, String tfCostOfTreatment, String tfTotalPay,
			PatientsVo patientsVo) {
		patientsVo.setIdPatient(0);
		patientsVo.setNamee(tfName);
		patientsVo.setDocument(tfDocument);
		patientsVo.setDirection(tfDirection);
		patientsVo.setTelephone(tfPhone);
		patientsVo.setOperator((String)cbTypeUsed);
		patientsVo.setCompanyName(tfCompanyName);
		patientsVo.setDaysHospitalization(Integer.parseInt(tfDays));
		patientsVo.setDrugCost(Double.parseDouble(tfDrugsCosts));
		if(cbTreatment.equals("Neumoconiosis")) {
			patientsVo.setIdTreatmentFK(1);
		}else if(cbTreatment.equals("V?rtigo")) {
			patientsVo.setIdTreatmentFK(2);
		}else if(cbTreatment.equals("Problemas Respiratorios")) {
			patientsVo.setIdTreatmentFK(3);
		}
		patientsVo.setCostOfTreatment(Double.parseDouble(tfCostOfTreatment));
		patientsVo.setTotalPay(Double.parseDouble(tfTotalPay));
		return controller.saveDataDao(patientsVo);
	}

	public String calculateTotal(String tfDays, String tfDrugsCosts, String tfCostOfTreatment, Object cbTypeUsed) {
		double totalDay = 0.0;
		double total = 0.0;
		double descuento = 0.2;
		if(cbTypeUsed.equals("Operario")) {
			totalDay = Double.parseDouble(tfDays)*80000;
			total = totalDay+Double.parseDouble(tfDrugsCosts)+Double.parseDouble(tfCostOfTreatment);
		}else if(cbTypeUsed.equals("Minero")) {
			totalDay = Double.parseDouble(tfDays)*80000;
			total = totalDay+Double.parseDouble(tfDrugsCosts)+Double.parseDouble(tfCostOfTreatment);
			total = total-((totalDay+Double.parseDouble(tfDrugsCosts)+Double.parseDouble(tfCostOfTreatment))*descuento);
		}
		return total+"";
	}

	public String insertCost(Object cbTreatment, TreatmentVo treatmentVo) {
		if(cbTreatment.equals("Neumoconiosis")) {
			treatmentVo.setIdTreatment(1);
		}else if(cbTreatment.equals("V?rtigo")) {
			treatmentVo.setIdTreatment(2);
		}else if(cbTreatment.equals("Problemas Respiratorios")) {
			treatmentVo.setIdTreatment(3);
		}
		return controller.insertCostDao(treatmentVo);
	}

	public String[][] setDataTable(PatientsVo patientsVo) {
		return controller.setDataTableDao(patientsVo);
	}
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}


	public String checkField(String tfDocument){
		String result= "";
		if(tfDocument.equals("")) {
			result = "error";
		}else {
			result = "ok";
		}
		return result;
	}


	public String[][] sedDocument(String tfDocument, PatientsVo patientsVo) {
		patientsVo.setDocument(tfDocument);
		String result = controller.checkOnes(patientsVo);
		String[][] dataTable = new String[1][10];
		if(result.equals("ok")) {
			dataTable[0][0] = patientsVo.getNamee();
			dataTable[0][1] = patientsVo.getDocument();
			dataTable[0][2] = patientsVo.getDirection();
			dataTable[0][3] = patientsVo.getTelephone();
			dataTable[0][4] = patientsVo.getOperator();
			dataTable[0][5] = patientsVo.getDaysHospitalization() + "";
			dataTable[0][6] = patientsVo.getDrugCost() + "";
			dataTable[0][7] = patientsVo.getCompanyName();
			dataTable[0][8] = patientsVo.getCostOfTreatment() + "";
			dataTable[0][9] = patientsVo.getTotalPay() + "";
		}else if(result.equals("error")) {
		}
		return dataTable;
	}


	public String onlyNumbers(KeyEvent e) {
		char caracter = e.getKeyChar();
		String result = "";
		if(((caracter < '0') || (caracter > '9') ) && (caracter != '\b')) {
			result = "error";
		}else {
			result = "ok";
		}
		return result;
	}


	public String verifyDocuments(String tfDocument) {
		return controller.verifyDocument(tfDocument);
	}
}
















