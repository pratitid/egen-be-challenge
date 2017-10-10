package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.Metrics;
import com.rules.AbstractWeightRule;
import com.rules.UnderWeightRule;

@Component
public class TestObjectstub {
	
	
	
	@Autowired
	private RuleChecker ruleChecker;	
	
	public Metrics createMetricObject() {
		Metrics metric = new Metrics();
		metric.setTimeStamp(1);
		return metric;
	}
	
	
	public Metrics createOverweightMetric() {
		Metrics metric = createMetricObject();
		metric.setValue(200);
		return metric;
	}
	
	public Metrics createUnderweightMetric() {
		Metrics metric = createMetricObject();
		metric.setValue(100);
		return metric;
	}
	


}
