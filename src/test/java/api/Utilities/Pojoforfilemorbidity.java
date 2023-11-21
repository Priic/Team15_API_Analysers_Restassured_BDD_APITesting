package api.Utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pojoforfilemorbidity {
	private Object T4;	
	private Object TSH;
	private Object T3;
	public Object getT4() {
		return T4;
	}
	public void setT4(Object t4) {
		T4 = t4;
	}
	public Object getTSH() {
		return TSH;
	}
	public void setTSH(Object tSH) {
		TSH = tSH;
	}
	public Object getT3() {
		return T3;
	}
	public void setT3(Object t3) {
		T3 = t3;
	}
	

}
