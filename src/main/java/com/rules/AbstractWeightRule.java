package com.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;

import com.data.AlertData;
import com.example.demo.Metrics;
import com.example.demo.MongoDBUtility;


public abstract class AbstractWeightRule {
	
	final protected double baseweight = 150;
	
	protected Metrics metric;
	
	

	protected MongoDBUtility databasereference;
	
	
	
	public AbstractWeightRule(Metrics metric, MongoDBUtility databasereference) {
		this.metric = metric;
		this.databasereference = databasereference;
	}
	
	
	
	
	public AlertData createAlertData(String alertString) {
		AlertData alert = new AlertData();
		alert.setTimeStamp(metric.getTimeStamp());
		alert.setValue(metric.getValue());
		alert.setAlertString(alertString);
		return alert;
	}
	
	@Condition
    abstract public boolean checkInputWeight(); 
	
	
	@Action
    abstract public void setAlert() throws Exception;

}
