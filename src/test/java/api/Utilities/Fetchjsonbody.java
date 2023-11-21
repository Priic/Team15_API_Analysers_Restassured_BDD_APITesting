package api.Utilities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fetchjsonbody {
		private int patientId;
		private String FirstName;	
		private String LastName;
		private String ContactNumber;
		private String Email;	
		private String Allergy;	
		private String FoodCategory;
		List<List<Pojoforfilemorbidity>> FileMorbidity;
		List<Object> FileMorbidityCondition;
		private String DateOfBirth;
		private int DieticianId;	
		
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		public String getContactNumber() {
			return ContactNumber;
		}
		public void setContactNumber(String contactNumber) {
			ContactNumber = contactNumber;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getAllergy() {
			return Allergy;
		}
		public void setAllergy(String allergy) {
			Allergy = allergy;
		}
		public String getFoodCategory() {
			return FoodCategory;
		}
		public void setFoodCategory(String foodCategory) {
			FoodCategory = foodCategory;
		}
		public String getDateOfBirth() {
			return DateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			DateOfBirth = dateOfBirth;
		}
		public int getDieticianId() {
			return DieticianId;
		}
		public void setDieticianId(int dieticianId) {
			DieticianId = dieticianId;
		}
		
		public List<List<Pojoforfilemorbidity>> getFileMorbidity() {
			return FileMorbidity;
		}
		public void setFileMorbidity(List<List<Pojoforfilemorbidity>> fileMorbidity) {
			FileMorbidity = fileMorbidity;
		}
		public List<Object> getFileMorbidityCondition() {
			return FileMorbidityCondition;
		}
		public void setFileMorbidityCondition(List<Object> fileMorbidityCondition) {
			FileMorbidityCondition = fileMorbidityCondition;
		}
		
	
		
		
		
}