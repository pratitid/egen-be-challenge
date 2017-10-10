package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rules.AbstractWeightRule;
import com.rules.OverWeightRule;
import com.rules.UnderWeightRule;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestApplicationTests {
	
	@Autowired
	public TestObjectstub testStub;
	
	@Autowired
	private MongoDBUtility mongoDB;
	

	@Test
	public void contextLoads() {
	}
	
	
	
	
	@Test
	public void testUnderWeightRuletrue() {
		AbstractWeightRule rule = new UnderWeightRule(testStub.createUnderweightMetric(), mongoDB);
		assert rule.checkInputWeight() == true;
		
	}
	
	
	@Test
	public void testUnderWeightRulefalse() {
		AbstractWeightRule rule = new UnderWeightRule(testStub.createOverweightMetric(), mongoDB);
		assert rule.checkInputWeight() == false;
		
	}
	
	@Test
	public void testOverWeightRuletrue() {
		AbstractWeightRule rule = new OverWeightRule(testStub.createOverweightMetric(), mongoDB);
		assert rule.checkInputWeight() == true;
		
	}
	
	@Test
	public void testOverWeightRulefalse() {
		AbstractWeightRule rule = new OverWeightRule(testStub.createUnderweightMetric(), mongoDB);
		assert rule.checkInputWeight() == false;
		
	}

}
