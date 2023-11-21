package api.RequestBody;

import java.io.IOException;

import api.Pojo.PatientPayload;
import api.Utilities.restUtils;

public class PatientRequestBody extends restUtils{
	
	public static PatientPayload CreatePatientPostBody() throws IOException {
		
		patientPayload.setPatientInfo(xlUtils.getCellData("PostPatients", 1, 1));
		patientPayload.setPatientInfoValue(xlUtils.getCellData("PostPatients", 1, 0));
		return patientPayload;		
	}
	
public static PatientPayload UpdatePatientPutBody() throws IOException {
		
		patientPayload.setPatientInfo(xlUtils.getCellData("PutPatients", 1, 1));
		patientPayload.setPatientInfoValue(xlUtils.getCellData("PutPatients", 1, 0));
		return patientPayload;
		
	}

}
