package controllers;

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

public class Relations {
	public void startSystem() {
		MainWindow mainWindow = new MainWindow();
		Controller controller = new Controller();
		ConsultPerson consultPerson = new ConsultPerson(true, mainWindow);
		RegisterPerson registerPerson = new RegisterPerson(true, mainWindow);
		Connections connection = new Connections();
		Processes processes = new Processes();
		PatientsVo patientsVo = new PatientsVo();
		PatientsDao queriesDao = new PatientsDao();
		TreatmentVo treatmentVo = new TreatmentVo();
		TreatmentDao treatmentDao = new TreatmentDao();
		DocumentPerson documentPerson = new DocumentPerson(true, consultPerson);
		
		mainWindow.setController(controller);
		consultPerson.setController(controller);
		registerPerson.setController(controller);
		connection.setController(controller);
		processes.setController(controller);
		patientsVo.setController(controller);
		queriesDao.setController(controller);
		treatmentVo.setController(controller);
		treatmentDao.setController(controller);
		documentPerson.setController(controller);
		
		controller.setMainWindow(mainWindow);
		controller.setConsultPerson(consultPerson);
		controller.setRegisterPerson(registerPerson);
		controller.setConnection(connection);
		controller.setProcesses(processes);
		controller.setPatientesVo(patientsVo);
		controller.setQueriesDao(queriesDao);
		controller.setTreatmentVo(treatmentVo);
		controller.setTreatmentDao(treatmentDao);
		controller.setDocumentPerson(documentPerson);
		
		mainWindow.setVisible(true);
	}
}
