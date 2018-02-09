/*team27d[³ªÀ±ÁÖ]*/
package service;

public class Singer { //³ªÀ±ÁÖ
	private int singerId;
	private String singerName;
	private int singerAge;
	public int getSingerId() {
		return singerId;
	}
	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public int getSingerAge() {
		return singerAge;
	}
	public void setSingerAge(int singerAge) {
		this.singerAge = singerAge;
	}
	@Override
	public String toString() {
		return "Singer [singerId=" + singerId + ", singerName=" + singerName + ", singerAge=" + singerAge + "]";
	}

}
