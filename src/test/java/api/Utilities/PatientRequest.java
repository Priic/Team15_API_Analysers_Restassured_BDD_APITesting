//package api.Utilities;
//
//public class PatientRequest {
//	
//	package api.Utilities;
//
//	import static io.restassured.RestAssured.given;
//
//	import java.io.FileNotFoundException;
//
//	import api.Pojo.PatientPayload;
//	import api.Pojo.UserLoginPayload;
//	import api.Utilities.restUtils;
//	import io.restassured.RestAssured;
//	import io.restassured.http.ContentType;
//	import io.restassured.response.Response;
//	import io.restassured.specification.RequestSpecification;
//
//	public class PatientRequest extends restUtils {
//
//		// CreatePatient Post request
//
//		public static Response patientPostRequest() throws FileNotFoundException {
//
//			String patientInfoBody="{\r\n"
//					+ "\"FirstName\": \"Chrs\",\r\n"
//					+ " \"LastName\": \"Mark\",\r\n"
//					+ "  \"ContactNumber\": \"4024503303\",\r\n"
//					+ "  \"Email\": \"chis@gmail.com\",\r\n"
//					+ "  \"Allergy\": \"Egg\",\r\n"
//					+ "  \"FoodCategory\": \"Vegan\",\r\n"
//					+ "  \"DateOfBirth\": \"2010-05-12\"\r\n"
//					+ "}";
//			
//			
//			request = given().accept(ContentType.MULTIPART).queryParam("patientInValue", "Thyroid")
//					.multiPart("patientInfo", patientInfoBody).log().all();
//					//.queryParam("patientInValue", patientPayload.getPatientInfoValue())
//					//.body(payload);
//		//	.accept(ContentType.MULTIPART)
//					System.out.println(patientPayload.getPatientInfoValue());
//			response = request.header("Authorization", "Bearer " + DieticianPritoken)
//					.post(path.getString("Patient_Post"));
//			
//			response.prettyPrint();
//			return response;
//		}
//
//		//Get request
//		// GetALLPatient Get request
//
//		public static Response getALLPatientRequest() throws FileNotFoundException {
//
//			request = given().spec(requestSpecification()).log().all();
//			response = request.header("Authorization", "Bearer " + DieticianPritoken).get(path.getString("Patient_GetALL"));
//			response.prettyPrint();
//			return response;
//		}
//
//		// Get Patients Morbidity Details
//
//		//Retrieve Patient file by FileId
//		
//		//Delete patient by ID
//		
//		public static Response deletePatientRequest() throws FileNotFoundException {
//
//			request = given().spec(requestSpecification()).log().all();
//			response = request.header("Authorization", "Bearer " + DieticianPritoken).delete(path.getString("Pateint_Delete")+PriPatientId);
//			response.prettyPrint();
//		
//			return response;
//	}
//		
//		
//
//	}
//
//}
