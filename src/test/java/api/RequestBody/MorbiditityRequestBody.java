package api.RequestBody;

import java.io.IOException;

import api.Pojo.MorbidityPayload;
import api.Utilities.restUtils;

public class MorbiditityRequestBody extends restUtils{
	
	
public static MorbidityPayload getMorbidityDetails() throws IOException {
		
	morbidityPayload.setMorbidityName(xlUtils.getCellData("Morbidity", 1, 0));
		System.out.println("MorbidityName"+ morbidityPayload.getMorbidityName());
		return morbidityPayload;
		
	}

}
