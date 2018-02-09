//team27d [유국화]
package service;

public class Rapper { 
	private int rapperId;
	private String rapperName;
	private int rapperAge;
	public int getRapperId() {
		return rapperId;
	}
	public void setRapperId(int rapperId) {
		this.rapperId = rapperId;
	}
	public String getRapperName() {
		return rapperName;
	}
	public void setRapperName(String rapperName) {
		this.rapperName = rapperName;
	}
	public int getRapperAge() {
		return rapperAge;
	}
	public void setRapperAge(int rapperAge) {
		this.rapperAge = rapperAge;
	}
	@Override
	public String toString() { //세팅값 확인을 위한 toString메서드 (Source - Generate toString() 클릭)
		return "Rapper [rapperId=" + rapperId + ", rapperName=" + rapperName + ", rapperAge=" + rapperAge + "]";
	}	
}
