package my.vaadin.first_app;
//import java.sql.Date;

public class OrderInformation {
	
    public enum Type {
        Raw, Processed
    }
    public enum Quality {
        Low, High
    }
	
    // private Date date;
	private String startTime = "";
	private int duration = 1;
	private Type type;
	private Quality quality;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Quality getQuality() {
		return quality;
	}
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	
	

}
