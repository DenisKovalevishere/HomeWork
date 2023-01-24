package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import app.dto.ValueSensorDTO;
import app.dto.ValueSensorResponse;

public class DrawChart {

	public static List<Double> getTempSensorFromServer() {
		final RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:8080/measurements";

		ValueSensorResponse valueSensorResponse = restTemplate.getForObject(url, ValueSensorResponse.class);

		if (valueSensorResponse == null || valueSensorResponse.getValues() == null) {
			return Collections.emptyList();

		}

		return valueSensorResponse.getValues().stream().map(ValueSensorDTO::getTemp).collect(Collectors.toList());
	}

	public static void drawTemp(List<Double> temps) {

		List<Integer> xData = new ArrayList<>();
		List<Double> yData = new ArrayList<>();

		for (int i = 0; i < temps.size(); i++) {
			xData.add(i);
			yData.add(temps.get(i));
		}

		XYChart chart = QuickChart.getChart("Temp", "X", "Y", "temp", xData, yData);

		new SwingWrapper(chart).displayChart();

	}
}
