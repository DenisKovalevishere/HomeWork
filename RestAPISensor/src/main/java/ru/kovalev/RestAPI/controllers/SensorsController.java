package ru.kovalev.RestAPI.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.kovalev.RestAPI.dto.SensorDTO;
import ru.kovalev.RestAPI.models.Sensor;
import ru.kovalev.RestAPI.services.SensorsService;
import ru.kovalev.RestAPI.util.SensorValidator;
import ru.kovalev.RestAPI.util.ValueSensorErrorResponse;
import ru.kovalev.RestAPI.util.ValueSensorException;

import static ru.kovalev.RestAPI.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

	private final SensorsService sensorsService;
	private final ModelMapper modelMapper;
	private final SensorValidator sensorValidator;
	
	public SensorsController(SensorsService sensorsService, ModelMapper modelMapper, SensorValidator sensorValidator) {
		this.sensorsService = sensorsService;
		this.modelMapper = modelMapper;
		this.sensorValidator = sensorValidator;
	}
	
	@GetMapping()
	public List<SensorDTO> getSensors(){
		return sensorsService.findAll().stream().map(this::convertToSensorDTO).collect(Collectors.toList());
	}
	
	@PostMapping("/registration")
	public ResponseEntity<HttpStatus> addSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
		
		Sensor sensorConverted = convertToSensor(sensorDTO);
		
		sensorValidator.validate(sensorConverted, bindingResult);
		
		if(bindingResult.hasErrors()) {
			returnErrorsToClient(bindingResult);
		}
		
		sensorsService.saveSensor(sensorConverted);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public SensorDTO getSensor(@PathVariable("id") int id) {
		return convertToSensorDTO(sensorsService.findOne(id));
	}
	
	@ExceptionHandler
	private ResponseEntity<ValueSensorErrorResponse> handleException(ValueSensorException e){
		ValueSensorErrorResponse response = new ValueSensorErrorResponse(
				e.getMessage(), 
				System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	private Sensor convertToSensor(SensorDTO sensorDTO) {
		return modelMapper.map(sensorDTO, Sensor.class);
	}
	
	private SensorDTO convertToSensorDTO(Sensor sensor) {
		return modelMapper.map(sensor, SensorDTO.class);
	}
	
}
