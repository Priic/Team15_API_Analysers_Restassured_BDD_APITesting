package api.Utilities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filemorbiditypojo {
	private Object fileId;	
	private Object fileName;
	private Object uploadDate;
	private Object morbidConditions;
	private Object morbidConditionStr;
	public Object getFileId() {
		return fileId;
	}
	public void setFileId(Object fileId) {
		this.fileId = fileId;
	}
	public Object getFileName() {
		return fileName;
	}
	public void setFileName(Object fileName) {
		this.fileName = fileName;
	}
	public Object getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Object uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Object getMorbidConditions() {
		return morbidConditions;
	}
	public void setMorbidConditions(Object morbidConditions) {
		this.morbidConditions = morbidConditions;
	}
	public Object getMorbidConditionStr() {
		return morbidConditionStr;
	}
	public void setMorbidConditionStr(Object morbidConditionStr) {
		this.morbidConditionStr = morbidConditionStr;
	}
	
}
