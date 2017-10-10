package com.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.data.AlertData;
import com.data.MetricData;
import com.example.demo.Metrics;
import com.example.demo.MongoDBUtility;

@Rule(name = "Rule to check Underweight",
description = "Throws Alert when weight is less than 10% of base weight")
public class UnderWeightRule extends AbstractWeightRule {
	
	public UnderWeightRule(Metrics metric, MongoDBUtility databasereference) {
		super(metric,databasereference);
	}
	
	@Override
	@Condition
    public boolean checkInputWeight() {
        
		boolean retVal = (metric.getValue() < .9*baseweight);
        return retVal;
    }

	@Override
	 @Action
	    public void setAlert() throws Exception {
		AlertData alert = createAlertData("underWeight");
        databasereference.saveAlertData(alert);
	    }

}
