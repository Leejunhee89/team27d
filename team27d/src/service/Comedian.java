//team27d [¹æ¹Î¿µ]

package service;

public class Comedian {

	private int comedianId;
	private String comedianName;
	private int comedianAge;
	public int getComedianId() {
		return comedianId;
	}
	public void setComedianId(int comedianId) {
		this.comedianId = comedianId;
	}
	public String getComedianName() {
		return comedianName;
	}
	public void setComedianName(String comedianName) {
		this.comedianName = comedianName;
	}
	public int getComedianAge() {
		return comedianAge;
	}
	public void setComedianAge(int comedianAge) {
		this.comedianAge = comedianAge;
	}
	@Override
	public String toString() {
		return "Comedian [comedianId=" + comedianId + ", comedianName=" + comedianName + ", comedianAge=" + comedianAge + "]";
	}
	
}
