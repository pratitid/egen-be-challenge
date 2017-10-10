package com.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.data.AlertData;
import com.data.MetricData;
import com.example.demo.Metrics;
import com.example.demo.MongoDBUtility;

@Rule(name = "Rule to check Overweight",
description = "Throws Alert when weight is greather than 10% of base weight")

public class OverWeightRule extends AbstractWeightRule {
	
	public OverWeightRule(Metrics metric, MongoDBUtility databasereference) {
		super(metric, databasereference);
	}

		
	@Override	
	@Condition
	    public boolean checkInputWeight() {
	        boolean retVal = (metric.getValue() > 1.1*baseweight);
	        return retVal;
	    }

	@Override	
	@Action
		    public void setAlert() throws Exception {
		         AlertData alert = createAlertData("overWeight");
		         databasereference.saveAlertData(alert);
		    }
	
}
