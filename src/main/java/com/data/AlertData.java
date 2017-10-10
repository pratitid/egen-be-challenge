package com.data;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class AlertData extends BaseEntity  {
	
	private String alertString;
	
    private long timeStamp;
	
	private double value;

	/**
	 * @return the alertString
	 */
	public String getAlertString() {
		return alertString;
	}

	/**
	 * @param alertString the alertString to set
	 */
	public void setAlertString(String alertString) {
		this.alertString = alertString;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
