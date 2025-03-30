import java.util.Scanner;

public class Main {

	final static Scanner sc = new Scanner(System.in);

	private static boolean isValidCNP(String CNP) {
		if (CNP.length() != 13) {
			return false;
		}
		if (!CNP.matches("\\d+")) {
			return false;
		}
		char firstDigit = CNP.charAt(0);
		if (firstDigit != '1' && firstDigit != '2' && firstDigit != '5' && firstDigit != '6') {
			return false;
		}
		return true;
	}

	private static boolean isValidPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() != 10) {
			return false;
		}
		if (!phoneNumber.matches("\\d+")) {
			return false;
		}
		if (!phoneNumber.startsWith("07")) {
			return false;
		}
		return true;
	}

	private static void showCommands() {
		System.out.println("help         - Show command list");
		System.out.println("add          - Add new patient");
		System.out.println("search       - Search patient");
		System.out.println("update       - Actualizeaza detaliile unei persoane");
		System.out.println("guests       - Lista de persoane care participa la eveniment");
		System.out.println("waitlist     - Persoanele din lista de asteptare");
		System.out.println("available    - Numarul de locuri libere");
		System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
		System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
		System.out.println("subscribe_no - Numarul total de persoane inscrise");
		System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
		System.out.println("save         - Salveaza lista cu invitati");
		System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
		System.out.println("reset        - Sterge informatiile salvate despre invitati");
		System.out.println("quit         - Inchide aplicatia");
	}

	private static void addNewPatient(PatientList patientRecords) {
		System.out.print("Insert last name: ");
		String lastName = sc.nextLine();
		System.out.print("Insert first name: ");
		String firstName = sc.nextLine();
		System.out.print("Insert CNP: ");
		String CNP = sc.nextLine().trim();
		while (!isValidCNP(CNP)) {
			System.out.print("Wrong CNP! Insert again: ");
			CNP = sc.nextLine().trim();
		}
		System.out.print("Insert phoneNumber: ");
		String phoneNumber = sc.nextLine().trim();
		while (!isValidPhoneNumber(phoneNumber)) {
			System.out.print("Wrong phoneNumber! Insert again: ");
			phoneNumber = sc.nextLine().trim();
		}

		if (lastName.trim().isEmpty() || firstName.trim().isEmpty() || CNP.trim().isEmpty()
				|| phoneNumber.trim().isEmpty()) {
			System.out.println("All fields must be filled!");
			return;
		}

		Patient existingPatient = patientRecords.searchByCNP(CNP);
		if (existingPatient != null) {
			System.out.println(lastName + " " + firstName + " is already registered with CNP " + CNP);
			return;
		}
		Patient patient = new Patient(lastName, firstName, CNP, phoneNumber);
		patientRecords.addPatient(patient);

	}

	private static void search(PatientList patientRecords) {
		System.out.println("1. Search by full name: ");
		System.out.println("2. Search by CNP: ");
		System.out.println("3. Search by ID: ");
		System.out.print("4. Search by phone number: \nInsert option: ");
		int option = sc.nextInt();
		sc.nextLine();
		switch (option) {
		case 1:
			System.out.println("Insert last name: ");
			String lastName = sc.nextLine();
			System.out.println("Insert first name: ");
			String firstName = sc.nextLine();
			patientRecords.searchByName(lastName, firstName);
			break;
		case 2:
			System.out.print("Insert CNP: ");
			String CNP = sc.nextLine().trim();
			while (!isValidCNP(CNP)) {
				System.out.print("Wrong CNP! Insert again: ");
				CNP = sc.nextLine().trim();
			}
			Patient patient = patientRecords.searchByCNP(CNP);
			if (patient == null) {
				System.out.println("No patient found.");
			} else {
				System.out.println(patient.getFullName());
			}
			break;
		case 3:
			System.out.print("Insert ID: ");
			int ID = sc.nextInt();
			while (ID < 100000) {
				System.out.print("No such ID! Insert again: ");
				ID = sc.nextInt();
			}
			break;
		case 4:
			System.out.print("Insert phoneNumber: ");
			String phoneNumber = sc.nextLine().trim();
			while (!isValidPhoneNumber(phoneNumber)) {
				System.out.print("Wrong phoneNumber! Insert again: ");
				phoneNumber = sc.nextLine().trim();
			}
			patientRecords.searchByPhoneNumber(phoneNumber);
			break;
		default:
			System.out.println("Wrong option!");
			break;
		}

	}

	private static void showPatients(PatientList patientRecords) {
		patientRecords.showPatients();

	}

	public static void main(String[] args) {

		PatientList patientRecords = PatientList.getInstance();
		boolean run = true;

		while (run) {
			String command = sc.nextLine().toLowerCase();

			switch (command) {
			case "help":
				showCommands();
				break;
			case "add":
				addNewPatient(patientRecords);
				break;
			case "search":
				search(patientRecords);
				break;
			case "show":
				showPatients(patientRecords);
				break;
			default:
				System.out.println("Comanda introdusa nu este valida.");
				System.out.println("Incercati inca o data.");

			}
		}

	}

}
