import java.util.ArrayList;
import java.util.List;

public class PatientList {

	private static PatientList instance;
	private List<Patient> patientList;

	private PatientList() {
		this.patientList = new ArrayList<>();
	}

	public static PatientList getInstance() {
		if (instance == null) {
			instance = new PatientList();
		}
		return instance;
	}

	public boolean addPatient(Patient patient) {
		if (patient.getCNP() == null) {
			System.err.println("Cannot add a null patient");
			return false;
		}
		return patientList.add(patient);
	}

	public void showPatients() {
		for (Patient patient : patientList) {
			System.out.println(patient);
		}
	}

	public void searchByCNP(String str) {
		for (Patient patient : patientList) {
			if (str.equals(patient.getCNP())) {
				System.out.println(patient);
				break;
			}
		}
	}

	public void searchByID(int ID) {
		for (Patient patient : patientList) {
			if (ID == patient.getID()) {
				System.out.println(patient);
				break;
			}
		}
	}

}
