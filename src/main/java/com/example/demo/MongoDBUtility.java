package com.example.demo;


import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import com.data.AlertData;
import com.data.MetricData;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@Component
public class MongoDBUtility {
	
	private Datastore datastore;
	
	private Morphia morphia;
	
	MongoDBUtility(){
		createDataStore();
	}
	
	public void createDataStore() {
		String dbName = new String("bank");
	     Mongo mongo = new Mongo();
	     morphia = new Morphia();
	     datastore = morphia.createDatastore(mongo, dbName);
	     morphia.mapPackage("com.data");
	}
	
	/**
	 * Save Metric Data to Database
	 */
	public void saveMetricData(Metrics m) {
		try {
			MetricData metricdata = new MetricData();
			metricdata.setTimeStamp(m.getTimeStamp());
			metricdata.setValue(m.getValue());
			Key<MetricData> savedMetric = datastore.save(metricdata);
		}catch(RuntimeException e) {
	    	e.printStackTrace();
	  }
		
	}
	
	
	/**
	 * Retreve all Metric Data from Database
	 */
	public List<Metrics> getMetricData() {
		
		List<MetricData> metricDataList;
	    List<Metrics> retMetrics = new ArrayList<Metrics>();
		try {
		    Query<MetricData> query = getDatastore().createQuery(MetricData.class);
		    metricDataList = query.asList();
		    for( MetricData l: metricDataList) {
		    	Metrics m = new Metrics();
		    	m.setTimeStamp(l.getTimeStamp());
		    	m.setValue(l.getValue());
		    	retMetrics.add(m);
		    }
		  }catch(RuntimeException e) {
		    	e.printStackTrace();
		  }
		    
	    return retMetrics;
	}
	
	
	/**
	 * Retrieve all Metric Data from Database by timestamp Range
	 */
	public List<Metrics> getMetricDataByTimeRange(long start, long end) {
		List<MetricData> metricDataList;
	    List<Metrics> retMetrics = new ArrayList<Metrics>();
	    try {
		    Query<MetricData> query = getDatastore().createQuery(MetricData.class);
		    query.criteria("timeStamp").greaterThanOrEq(start).add(query.criteria("timeStamp").lessThan(end));
		    metricDataList = query.asList();
		    for( MetricData l: metricDataList) {
		    	Metrics m = new Metrics();
		    	m.setTimeStamp(l.getTimeStamp());
		    	m.setValue(l.getValue());
		    	retMetrics.add(m);
		    }
	    }catch(RuntimeException e) {
	    	e.printStackTrace();
	    }
	    
	    return retMetrics;
	}
	

	/**
	 * Save Alert Data Thrown by Rules to Database
	 */
	public void saveAlertData(AlertData alert) {
		Key<AlertData> savedAlert = datastore.save(alert); 
		
	}
	
	
	/**
	 * Retrieve all Alert Data from Database by timestamp Range
	 */
	public List<Alerts> getAlertDataByTimeRange(long start, long end) {
	    Query<AlertData> query = getDatastore().createQuery(AlertData.class);
	    query.criteria("timeStamp").greaterThanOrEq(start).add(query.criteria("timeStamp").lessThan(end));
	    List<AlertData> alertDataList = query.asList();
	    List<Alerts> retAlerts = new ArrayList<Alerts>();
	    for( AlertData l: alertDataList) {
	    	Alerts a = new Alerts();
	    	a.setTimeStamp(l.getTimeStamp());
	    	a.setValue(l.getValue());
	    	a.setAlertString(l.getAlertString());
	    	retAlerts.add(a);
	    }
	    
	    return retAlerts;
	}
	
	
	/**
	 * Retrieve all Alert Data from Database
	 */
	public List<Alerts> getAlertData() {
	    Query<AlertData> query = getDatastore().createQuery(AlertData.class);
	    List<AlertData> alertDataList = query.asList();
	    List<Alerts> retAlerts = new ArrayList<Alerts>();
	    for( AlertData l: alertDataList) {
	    	Alerts a = new Alerts();
	    	a.setTimeStamp(l.getTimeStamp());
	    	a.setValue(l.getValue());
	    	a.setAlertString(l.getAlertString());
	    	retAlerts.add(a);
	    }
	    
	    return retAlerts;
	}
	


	/**
	 * @return the datastore
	 */
	public Datastore getDatastore() {
		return datastore;
	}


	/**
	 * @param datastore the datastore to set
	 */
	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}

}
