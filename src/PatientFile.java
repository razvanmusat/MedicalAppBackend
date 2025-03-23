import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientFile {

	private List<MedicalVisit> medicalHistory;

	public PatientFile() {
		this.medicalHistory = new ArrayList<>();
	}

	public void addMedicalVisit(String diagnostic, String treatment, String prescribedMedication) {
		String formattedDiagnostic = Patient.formatString(diagnostic); // Presupunând că Patient.formatString există
		String formattedTreatment = Patient.formatString(treatment);
		String formattedPrescribedMedication = Patient.formatString(prescribedMedication);
		LocalDate visitDate = LocalDate.now();
		MedicalVisit newVisit = new MedicalVisit(visitDate, formattedDiagnostic, formattedTreatment,
				formattedPrescribedMedication);
		this.medicalHistory.add(newVisit);
	}

	public void displayMedicalHistory() {
        if (medicalHistory.isEmpty()) {
            System.out.println("Medical history is empty.");
        } else {
            System.out.println("Medical history: ");
            for (MedicalVisit visit : medicalHistory) {
                System.out.println("\t" + visit);
            }
        }
    }

}
