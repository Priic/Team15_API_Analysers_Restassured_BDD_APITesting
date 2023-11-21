package api.Pojo;

import api.Utilities.restUtils;

public class MorbidityPayload extends restUtils{
	
	private String morbidityId;
	private String morbidityMarkerMaxVal;
	private String morbidityMarkerMinVal;
	private String morbidityNameRegex;
	private String morbidityTestId;
	private String morbidityTestUnit;
	private String morbidityName;
	
	public String getMorbidityName() {
		return morbidityName;
	}
	public void setMorbidityName(String morbidityName) {
		this.morbidityName = morbidityName;
	}
	

	
	public String getMorbidityId() {
		return morbidityId;
	}
	public void setMorbidityId(String morbidityId) {
		this.morbidityId = morbidityId;
	}
	public String getMorbidityMarkerMaxVal() {
		return morbidityMarkerMaxVal;
	}
	public void setMorbidityMarkerMaxVal(String morbidityMarkerMaxVal) {
		this.morbidityMarkerMaxVal = morbidityMarkerMaxVal;
	}
	public String getMorbidityMarkerMinVal() {
		return morbidityMarkerMinVal;
	}
	public void setMorbidityMarkerMinVal(String morbidityMarkerMinVal) {
		this.morbidityMarkerMinVal = morbidityMarkerMinVal;
	}
	public String getMorbidityNameRegex() {
		return morbidityNameRegex;
	}
	public void setMorbidityNameRegex(String morbidityNameRegex) {
		this.morbidityNameRegex = morbidityNameRegex;
	}
	public String getMorbidityTestId() {
		return morbidityTestId;
	}
	public void setMorbidityTestId(String morbidityTestId) {
		this.morbidityTestId = morbidityTestId;
	}
	public String getMorbidityTestUnit() {
		return morbidityTestUnit;
	}
	public void setMorbidityTestUnit(String morbidityTestUnit) {
		this.morbidityTestUnit = morbidityTestUnit;
	}
	

}
