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
	

	public void addPatient(Patient newPatient) {
		for (Patient patient : patientList) {
			if (newPatient.equals(patient)) {
				System.out.println("Patient " + newPatient.getFullName() + " is allready registered and has ID " + patient.getID());
				return;
			}
		}
		patientList.add(newPatient);
		System.out.println("Patient " + newPatient.getFullName() + " has been added succesfully!");
	}

	public void showPatients() {
		for (Patient patient : patientList) {
			System.out.println(patient);
		}
	}

	public void searchByCNP(String str) {
		for (Patient patient : patientList) {
			if (str.equals(patient.getCNP())) {
				System.out.println(patient.getFullName());
				break;
			}
		}
	}

	public void searchByID(int ID) {
		for (Patient patient : patientList) {
			if (ID == patient.getID()) {
				System.out.println(patient.getFullName());
				break;
			}
		}
	}

	public void searchByPhoneNumber(String phoneNumber) {
		for (Patient patient : patientList) {
			if (phoneNumber.equals(patient.getPhoneNumber())) {
				System.out.println("ID: " + patient.getID() + " - " + patient.getFullName());
				break;
			}
		}
	}

}
