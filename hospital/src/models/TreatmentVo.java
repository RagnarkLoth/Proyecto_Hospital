package models;

import controllers.Controller;

public class TreatmentVo {
	
	private int idTreatment;
	private String nameTreatment;
	private double treatmenValue;
	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public int getIdTreatment() {
		return idTreatment;
	}

	public void setIdTreatment(int idTreatment) {
		this.idTreatment = idTreatment;
	}

	public String getNameTreatment() {
		return nameTreatment;
	}

	public void setNameTreatment(String nameTreatment) {
		this.nameTreatment = nameTreatment;
	}

	public double getTreatmenValue() {
		return treatmenValue;
	}

	public void setTreatmenValue(double treatmenValue) {
		this.treatmenValue = treatmenValue;
	}

	
}
