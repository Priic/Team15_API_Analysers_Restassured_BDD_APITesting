package api.RequestBody;

import java.io.IOException;

import api.Pojo.UserLoginPayload;
import api.Utilities.restUtils;

public class UserLoginRequestBody extends restUtils{
	
	//body data to generate token
	public static UserLoginPayload UserLoginPostBody() throws IOException {
		
		userLoginPayload.setUserLoginEmail(xlUtils.getCellData("AllDieticianLogins", 1, 0));
		userLoginPayload.setPassword(xlUtils.getCellData("AllDieticianLogins", 1, 1));
		
		return userLoginPayload;
		
	}

}
