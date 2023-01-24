package app;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;

import org.springframework.web.client.RestTemplate;


public class Client {
	
	private static void addRandomValues(String sensorName, double maxTemperature) {
		Random random = new Random();
		
		for(int i = 0; i < 499; i++) {
			System.out.println(i);
			
			setValueSensor(random.nextDouble() * maxTemperature, random.nextBoolean(), sensorName);
		}
	}
	
	private static void addSensor(String value) {
		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("name", value);
		final String url = "http://localhost:8080/sensors/registration";
		makePostRequestWithJSONDATA(url, jsonData);
	}
	
	private static void setValueSensor(double temp, boolean raining, String sensorName) {
		final String url = "http://localhost:8080/measurements/add";
		Map<String, Object> jsonData = new HashMap<>();
		jsonData.put("temp", temp);
		jsonData.put("raining", raining);
		jsonData.put("sensor", Map.of("name", sensorName));
		
		makePostRequestWithJSONDATA(url, jsonData);
	}
	
	
	
	private static void makePostRequestWithJSONDATA(String url, Map<String, Object> jsonData) {
		final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);
		
		try {
			restTemplate.postForObject(url, request, String.class);
			System.out.println("Ok");
		} catch (HttpClientErrorException e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	public static void main(String[] args) {
//		final String sensorName = "SensorT1000";

		final List<Double> temps = DrawChart.getTempSensorFromServer();
		
//		getSensors();
		
//		addRandomValues(sensorName, 45.0);
		
		DrawChart.drawTemp(temps);
		
		
		
		
		
		
	}
}
