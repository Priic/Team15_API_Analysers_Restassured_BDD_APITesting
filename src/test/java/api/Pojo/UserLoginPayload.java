package api.Pojo;

import api.Utilities.restUtils;

public class UserLoginPayload extends restUtils {
	
	private String userLoginEmail;
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	
}
