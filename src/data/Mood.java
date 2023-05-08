package data;

import java.util.Date;


public class Mood {
	
	private String mood;
	private int intensity;
	private Date date;
	private String description;
	
	public Mood(String mood, int intensity, Date date, String description) {
	    this.mood = mood;
	    this.intensity = intensity;
	    this.date = date;
	    this.description = description;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

