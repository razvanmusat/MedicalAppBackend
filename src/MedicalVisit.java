import java.time.LocalDate;

public class MedicalVisit {
	private LocalDate visitDate;
	private String diagnostic;
	private String treatment;
	private String prescribedMedication;

	public MedicalVisit(LocalDate visitDate, String diagnostic, String treatment, String prescribedMedication) {
		this.visitDate = visitDate;
		this.diagnostic = diagnostic;
		this.treatment = treatment;
		this.prescribedMedication = prescribedMedication;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public String getTreatment() {
		return treatment;
	}

	public String getPrescribedMedication() {
		return prescribedMedication;
	}
	
	@Override
    public String toString() {
        return "Visit date: " + visitDate +
               "\t - Diagnostic: " + diagnostic +
               "\n\t\t\t\t - Tratament: " + treatment +
               "\n\t\t\t\t - Medicație prescrisă: " + prescribedMedication;
    }
	
	
}
