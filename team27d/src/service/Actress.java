// team27d [¿Ã¡ÿ»Ò] 
package service;

public class Actress {
	private int actressId;
	private String actressName;
	private int actressAge;
	public int getActressId() {
		return actressId;
	}
	public void setActressId(int actressId) {
		this.actressId = actressId;
	}
	public String getActressName() {
		return actressName;
	}
	public void setActressName(String actressName) {
		this.actressName = actressName;
	}
	public int getActressAge() {
		return actressAge;
	}
	public void setActressAge(int actressAge) {
		this.actressAge = actressAge;
	}
	@Override
	public String toString() {
		return "Actress [actressId=" + actressId + ", actressName=" + actressName + ", actressAge=" + actressAge + "]";
	}
	
	
}
      