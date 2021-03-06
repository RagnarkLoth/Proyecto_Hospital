package controllers;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import models.Connections;
import models.PatientsVo;
import models.Processes;
import models.TreatmentDao;
import models.PatientsDao;
import models.TreatmentVo;
import views.ConsultPerson;
import views.DocumentPerson;
import views.MainWindow;
import views.RegisterPerson;

public class Controller {
	
	private MainWindow mainWindow;
	private RegisterPerson registerPerson;
	private ConsultPerson consultPerson;
	private Connections connection;
	private Processes processes;
	private PatientsVo patientsVo;
	private PatientsDao patientsDao;
	private TreatmentVo treatmentVo;
	private TreatmentDao treatmentDao;
	private DocumentPerson documentPerson;

	public MainWindow getMainWindow() {
		return mainWindow;
	}


	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}



	public RegisterPerson getRegisterPerson() {
		return registerPerson;
	}



	public void setRegisterPerson(RegisterPerson registerPerson) {
		this.registerPerson = registerPerson;
	}



	public ConsultPerson getConsultPerson() {
		return consultPerson;
	}



	public void setConsultPerson(ConsultPerson consultPerson) {
		this.consultPerson = consultPerson;
	}



	public Connections getConnection() {
		return connection;
	}



	public void setConnection(Connections connection) {
		this.connection = connection;
	}



	public void giveMeConnection() {
		connection.giveMeConnection();
	}


	public Processes getProcesses() {
		return processes;
	}


	public void setProcesses(Processes processes) {
		this.processes = processes;
	}


	public void setPatientesVo(PatientsVo patientsVo) {
		this.patientsVo = patientsVo;
		
	}


	public void setQueriesDao(PatientsDao patientsDao) {
		this.patientsDao = patientsDao;
	}


	public String validateFields(String tfName, String tfDirection ,String tfDocument, String tfPhone, Object cbTypeUsed, String tfCompanyName, String tfDays, String tfDrugsCosts, Object cbTreatment, String tfCostOfTreatment, String tfTotalPay) {
		return processes.validateFields(tfName, tfDirection ,tfDocument, tfPhone, cbTypeUsed, tfCompanyName, tfDays, tfDrugsCosts, cbTreatment, tfCostOfTreatment, tfTotalPay);
	}


	public String ver() {
		return "Hola";
	}


	public void showQuery() {
		consultPerson.setVisible(true);
	}


	public void showRecord() {
		registerPerson.setVisible(true);
	}


	public Object saveData(String tfName, String tfDirection,String tfDocument, String tfPhone, Object cbTypeUsed, String tfCompanyName, String tfDays, String tfDrugsCosts, Object cbTreatment, String tfCostOfTreatment, String tfTotalPay) {
		return processes.saveData(tfName, tfDirection ,tfDocument, tfPhone, cbTypeUsed, tfCompanyName, tfDays, tfDrugsCosts, cbTreatment, tfCostOfTreatment, tfTotalPay,patientsVo);
	}


	public String calculateTotal(String tfDays, String tfDrugsCosts, String tfCostOfTreatment, Object cbTypeUsed) {
		return processes.calculateTotal(tfDays, tfDrugsCosts, tfCostOfTreatment, cbTypeUsed);
	}


	public String insertCost(Object cbTreatment) {
		return processes.insertCost(cbTreatment, treatmentVo);
	}


	public String insertCostDao(TreatmentVo treatmnetVo) {
		return 	treatmentDao.searchCost(treatmnetVo);
	}


	public Object saveDataDao(PatientsVo patientsVo) {
		return patientsDao.insert(patientsVo);
	}


	public TreatmentVo getTreatmentVo() {
		return treatmentVo;
	}


	public void setTreatmentVo(TreatmentVo treatmentVo) {
		this.treatmentVo = treatmentVo;
	}


	public void setTreatmentDao(TreatmentDao treatmentDao) {
		this.treatmentDao = treatmentDao;
		
	}


	public String[][] setDataTable() {
		return processes.setDataTable(patientsVo);
	}


	public String[][] setDataTableDao(PatientsVo patientsVo) {
		return patientsDao.checkAll(patientsVo);
	}


	public int tableSize() {
		return patientsDao.tableSize();
	}


	public void showQueryDocument() {
		documentPerson.setVisible(true);
	}


	public DocumentPerson getDocumentPerson() {
		return documentPerson;
	}


	public void setDocumentPerson(DocumentPerson documentPerson) {
		this.documentPerson = documentPerson;
	}


	public String checkFied(String tfDocument) {
		return processes.checkField(tfDocument);
	}


	public void sendDocument(String tfDocument) {
		consultPerson.sendDocument(tfDocument);//
	}


	public String checkOnes(PatientsVo patientsVo) {
		return patientsDao.checkOne(patientsVo);
	}


	public String[][] checkOne(String tfDocument) {
		return processes.sedDocument(tfDocument, patientsVo);
	}


	public String onlyNumbers(KeyEvent e) {
		return processes.onlyNumbers(e);
	}


	public void toClose() {
		documentPerson.dispose();
	}

	public String verifyDocuments(String tfDocument) {
		return processes.verifyDocuments(tfDocument);
	}
	
	public String verifyDocument(String tfDocument) {
		return patientsDao.verifyDocument(tfDocument);
	}
}




















