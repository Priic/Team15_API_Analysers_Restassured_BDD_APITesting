package api.Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Requestbody extends restUtils{  
	
	public static  Map<Integer, Object> geterrormessages() {
		Map<Integer, Object> errormessage= new HashMap<Integer, Object>();
		errormessage.put(500, "Internal Server Error");
		errormessage.put(400, "INVALID_REQ_DATA");
		errormessage.put(404, "NOT_FOUND");
		return errormessage;
	}
	public static  Map<String, Object> geterrormess() {
		Map<String, Object> error= new HashMap<String, Object>();
		error.put("firstandlastname", "User First Name is Mandatory!\r\n"
				+ " User Last Name is Mandatory!\r\n"
				+ " \r\n"
				+ "");
		error.put("invalidfoodcategory", "Invalid food catgory: Must be one of the categories in {VEGAN, VEGETARIAN, JAIN, EGGETARIAN, NONVEG}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "");
//		errormessage.put(404, "NOT_FOUND");
		return error;
	}
	public static String getvalidreqbody() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 0);
		return patientInfoBody;
	}
	
	public static String getreqbodyemptynames() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 1);
		return patientInfoBody;
	} 
	public static String getreqbodyinvalidfoodcategories() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 2);
		return patientInfoBody;
	} 
	public static String getreqbodyinvalidcontactnameemail() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 3);
		return patientInfoBody;
	} 
	
	public static String getreqbodyinvalidemaildob() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 4);
		return patientInfoBody;
	} 
	public static String duplicatecontactdob() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 5);
		return patientInfoBody;
	} 
	public static String updatebody() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 6);
		return patientInfoBody;
	} 
	
	public static String updatebodynodob() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 7);
		return patientInfoBody;
	}
	public static String incorrectdobupdate() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 8);
		return patientInfoBody;
	}
	public static String emptyemail() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 9);
		return patientInfoBody;
	}
	public static String incorrectfoodcategoryput() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 10);
		return patientInfoBody;
	}
	public static String incorrectfoodallergyput() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 11);
		return patientInfoBody;
	}
	public static String emptycontactnoput() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 12);
		return patientInfoBody;
	}
	public static String getduplicate() throws IOException {
		String patientInfoBody=	xlUtils.getCellData("PatientController", 1, 13);
		return patientInfoBody;
	}
}
