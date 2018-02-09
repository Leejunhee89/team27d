// team27d [이춘림]
package service;

public class Anaunseo {
	private int anaunseoId;
	private String anaunseoName;
	private int anaunseoAge;
	
	public int getAnaunseoId() {
		return anaunseoId;
	}
	public void setAnaunseoId(int anaunseoId) {
		this.anaunseoId = anaunseoId;
	}
	public String getAnaunseoName() {
		return anaunseoName;
	}
	public void setAnaunseoName(String anaunseoName) {
		this.anaunseoName = anaunseoName;
	}
	public int getAnaunseoAge() {
		return anaunseoAge;
	}
	public void setAnaunseoAge(int anaunseoAge) {
		this.anaunseoAge = anaunseoAge;
	}

	//단위 테스트를 하기 위해 toString()메서드를 오버라이딩 하였다.
	@Override
	public String toString() {
		return "Anaunseo [anaunseoId=" + anaunseoId + ", anaunseoName=" + anaunseoName + ", anaunseoAge=" + anaunseoAge
				+ "]";
	}
}
