import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Patient {
	private static int globalID = 100000;
	private int ID;
	private String firstName;
	private String lastName;
	private String CNP;
	private String phoneNumber;
	private PatientFile patientFile;

	public static String formatString(String word) {
		if (word == null || word.isEmpty()) {
			return word;
		}
		word = word.trim();
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}

	public Patient(String lastName, String firstName, String CNP, String phoneNumber) {
		this.lastName = formatString(lastName);
		this.firstName = formatString(firstName);
		this.CNP = CNP.trim();
		this.phoneNumber = phoneNumber;
		this.ID = globalID++;
		this.patientFile = new PatientFile();
	}

	public int getID() {
		return ID;
	}

	public PatientFile getPatientFile() {
		return patientFile;
	}

	public String getFullName() {
		return lastName + " " + firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Patient " + lastName + " " + firstName + " has " + getAge() + ". His phone number is : " + phoneNumber;
	}

	public String getAge() {
		int year = Integer.parseInt(CNP.substring(1, 3));
		int month = Integer.parseInt(CNP.substring(3, 5));
		int day = Integer.parseInt(CNP.substring(5, 7));
		int centuryIndicator = Integer.parseInt(CNP.substring(0, 1));

		if (centuryIndicator == 1 || centuryIndicator == 2) {
			year += 1900;
		} else if (centuryIndicator == 5 || centuryIndicator == 6) {
			year += 2000;
		}
		LocalDate birthDate = LocalDate.of(year, month, day);
		LocalDate currentDate = LocalDate.now();

		Period period = Period.between(birthDate, currentDate);
		year = period.getYears();
		month = period.getMonths();
		day = period.getDays();

		return year + " years and " + month + " months";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CNP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(CNP, other.CNP);
	}

	public void showPatientFile() {

	}

	public void newVisit() {
		this.patientFile = new PatientFile();
	}

}
