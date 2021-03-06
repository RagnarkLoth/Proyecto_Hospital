package models;

import controllers.Controller;

public class PatientsVo {
	private int idPatient;
	private String namee;
	private String document;
	private String direction;
	private String telephone;
	private String operator;
	private int daysHospitalization;
	private double drugCost;
	private double totalPay;
	private String companyName;
	private Double costOfTreatment;
	private int idTreatmentFK;
	private Controller controller;
	
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getNamee() {
		return namee;
	}
	public void setNamee(String namee) {
		this.namee = namee;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getDaysHospitalization() {
		return daysHospitalization;
	}
	public void setDaysHospitalization(int daysHospitalization) {
		this.daysHospitalization = daysHospitalization;
	}
	public double getDrugCost() {
		return drugCost;
	}
	public void setDrugCost(double drugCost) {
		this.drugCost = drugCost;
	}
	public double getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}
	public int getIdTreatmentFK() {
		return idTreatmentFK;
	}
	public void setIdTreatmentFK(int idTreatmentFK) {
		this.idTreatmentFK = idTreatmentFK;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getCostOfTreatment() {
		return costOfTreatment;
	}
	public void setCostOfTreatment(Double costOfTreatment) {
		this.costOfTreatment = costOfTreatment;
	}
	
}
