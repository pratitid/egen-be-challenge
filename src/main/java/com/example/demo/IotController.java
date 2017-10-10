package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Metrics;
import com.data.SuccessResponse;
import com.example.demo.IotService;

@RestController
@RequestMapping(value = "/iotService")
public class IotController {
	
	@Autowired
	private IotService iotService;
	
	/**
	 * Entry Point of reading all Metric data
	 * URL: http://localhost:8080/iotService/readMetric
	 */	
	@RequestMapping(value = "/readMetric", method = RequestMethod.GET, 
            produces = "application/json")
	public List<Metrics> read() {
		return iotService.readMetrics();
	}
	
	
	/**
	 * Entry Point of reading data between a mandatory start and end timestamp
	 * URL: http://localhost:8080/iotService/readMetricByRange?start=1458062848775&end=1458062848785
	 */	
	@RequestMapping(value = "/readMetricByRange", method = RequestMethod.GET, 
    produces = "application/json")
	public List<Metrics> readMetricsByTimeRange(@RequestParam(value = "start", required = true) long start,
			@RequestParam(value = "end", required = true)long  end) {
		return iotService.readMetricsByTimeRange(start, end);
	}
	
	
	
	/**
	 * Entry Point of posting  Metric data
	 * URL For sensor: http://localhost:8080/iotService/create
	 */	
	@RequestMapping(value = "/create", method = RequestMethod.POST, 
		    consumes = "application/json")
	public SuccessResponse createMetrics(
		 @RequestBody Metrics newMetrics) {
		SuccessResponse s= new SuccessResponse();
		try {
		   iotService.createMetrics(newMetrics);		   
		}catch(RuntimeException e) {
			s.setMessage(e.getMessage());
		}
		return s;
		
	}
	
	
	/**
	 * Entry Point of reading all Alerts
	 * URL: http://localhost:8080/iotService/readAlerts
	 */
	@RequestMapping(value = "/readAlerts", method = RequestMethod.GET, 
            produces = "application/json")
	public List<Alerts> readAlerts() {
		return iotService.readAlerts();
	}
	
	
	/**
	 * Entry Point of reading all Alerts
	 * URL: http://localhost:8080/iotService/readAlertByRange?start=1458062848775&end=1458062848805
	 */
	@RequestMapping(value = "/readAlertByRange", method = RequestMethod.GET,  
			produces = "application/json")
	public List<Alerts> readAlertsbyRange(@RequestParam(value = "start", required = true) long start,
			@RequestParam(value = "end", required = true)long  end) {
		return iotService.readAlertsByTimeRange(start, end);
	}
	
	
	

}
