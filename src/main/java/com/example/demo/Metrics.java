package com.example.demo;

import java.io.Serializable;

public class Metrics {

	private long timeStamp;
	
	private double value;

	/**
	 * @return the timestamp
	 */
	public Metrics(){
		timeStamp =1;
		value = 1;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timestamp the timestamp to set
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
