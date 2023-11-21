package api.Pojo;

import api.Utilities.restUtils;

public class PatientPayload extends restUtils{
	
	private String FirstName;	
	private String LastName;	
	private String Email;	
	private String DateOfBirth;
	private String Allergy;	
	private String FoodCategory;
	private String DieticianId;	
	private String patientId;
	private String patientInfo;
	private String patientInfoValue;
	private String ContactNumber;
	

	
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getPatientInfoValue() {
		return patientInfoValue;
	}
	public void setPatientInfoValue(String patientInfoValue) {
		this.patientInfoValue = patientInfoValue;
	}
	public String getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(String patientInfo) {
		this.patientInfo = patientInfo;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
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
	public String getDieticianId() {
		return DieticianId;
	}
	public void setDieticianId(String dieticianId) {
		DieticianId = dieticianId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
}
