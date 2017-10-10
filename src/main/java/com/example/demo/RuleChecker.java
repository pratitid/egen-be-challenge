package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rules.AbstractWeightRule;
import com.rules.OverWeightRule;
import com.rules.UnderWeightRule;
import com.example.demo.Metrics;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import java.util.ArrayList;
import java.util.List;

import org.easyrules.api.RulesEngine;

@Component
public class RuleChecker {
	

	private List<AbstractWeightRule> rules = new ArrayList<AbstractWeightRule>();
	
	private MongoDBUtility databasereference;
	
	public void fireRules() {
		RulesEngine rulesEngine = aNewRulesEngine().build();
		for(AbstractWeightRule rule : rules) {
		  rulesEngine.registerRule(rule); 
		}
		rulesEngine.fireRules();
		
	}
	
	  public void addRule(Metrics metric) {
		rules.clear();
		AbstractWeightRule underweightRule = new UnderWeightRule(metric, databasereference);
		rules.add(underweightRule);
		AbstractWeightRule overweightRule = new OverWeightRule(metric, databasereference);
		rules.add(overweightRule);
	}

	/**
	 * @param databasereference the databasereference to set
	 */
	public void setDatabasereference(MongoDBUtility databasereference) {
		this.databasereference = databasereference;
	}
	  
	 
	

}
