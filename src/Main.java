
public class Main {

	public static void main(String[] args) {
		PatientList work = PatientList.getInstance();
		
		Patient a = new Patient("musat", "razvan", "1880920100111", "0765985010");
		Patient b = new Patient("ion", "claudiu", "1901002100055", "0723185066");
		Patient c = new Patient("gheorghe", "vasile", "1600329100015", "0766524122");
		Patient d = new Patient(null, null, null, null);
		
		
		
		work.addPatient(a);
		work.addPatient(b);
		work.addPatient(c);		
		work.addPatient(d);
		
		work.showPatients();		
		//work.searchByCNP("1901002100055");
		//work.searchByID(100002);
	}

}
