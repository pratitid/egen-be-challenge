package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Metrics;

@Component
public class IotService {
	
	
	
	@Autowired
	private MongoDBUtility mongoDB;
	
	
	@Autowired
	private RuleChecker ruleChecker;
	
	
	public void createMetrics(Metrics m) {
		mongoDB.saveMetricData(m);
		ruleChecker.setDatabasereference(mongoDB);
		ruleChecker.addRule(m);
		ruleChecker.fireRules();
	}
	
    public List<Metrics> readMetrics() {
    	return mongoDB.getMetricData();
	}
    
    public List<Metrics> readMetricsByTimeRange(long start, long end){
    	return mongoDB.getMetricDataByTimeRange(start, end);
    }
    
    
    public List<Alerts> readAlerts() {
    	return mongoDB.getAlertData();
	}
    
    public List<Alerts> readAlertsByTimeRange(long start, long end){
    	return mongoDB.getAlertDataByTimeRange(start, end);
    }

}
