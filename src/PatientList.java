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
		patientList.add(newPatient);
		System.out.println("Patient " + newPatient.getFullName() + " has been added successfully!");
	}

	public void showPatients() {
		for (Patient patient : patientList) {
			System.out.println(patient.getFullName());
		}
	}

	public Patient searchByCNP(String CNP) {
		for (Patient patient : patientList) {
			if (CNP.equals(patient.getCNP())) {					
				return patient;
			}
		}
		return null;
	}

	public Patient searchByID(int ID) {
		for (Patient patient : patientList) {
			if (ID == patient.getID()) {
				return patient;
			}
		}
		return null;
	}
	
	public void searchByName (String lastName, String firstName) {
		String fullName = lastName.trim() + " " + firstName.trim();
		boolean found = false;
		
		for (Patient patient : patientList) {
			if (fullName.equalsIgnoreCase(patient.getFullName())) {
				System.out.println(patient.getFullName());
				found = true;
			}
		}
		if (!found) {
	        System.out.println("No patients found with this name.");
	    }
	}

	public void searchByPhoneNumber(String phoneNumber) {
		boolean found = false;	    

	    for (Patient patient : patientList) {
	        if (phoneNumber.equals(patient.getPhoneNumber())) {
	            System.out.println(patient.getFullName());
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No patients found with this phone number.");
	    }
	}

}
