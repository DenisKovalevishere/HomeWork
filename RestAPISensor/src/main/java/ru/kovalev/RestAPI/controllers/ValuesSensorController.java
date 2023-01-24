package ru.kovalev.RestAPI.controllers;


import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ru.kovalev.RestAPI.dto.ValueSensorDTO;
import ru.kovalev.RestAPI.dto.ValueSensorResponse;
import ru.kovalev.RestAPI.models.ValueSensor;
import ru.kovalev.RestAPI.services.ValuesSensorService;
import ru.kovalev.RestAPI.util.ValueSensorErrorResponse;
import ru.kovalev.RestAPI.util.ValueSensorException;
import ru.kovalev.RestAPI.util.ValueSensorValidator;
import static ru.kovalev.RestAPI.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/measurements")
public class ValuesSensorController {

	private final ValuesSensorService valuesSensorService;
	private final ModelMapper modelMapper;
	private final ValueSensorValidator valueSensorValidator;

	public ValuesSensorController(ValuesSensorService valuesSensorService, ModelMapper modelMapper, ValueSensorValidator valueSensorValidator) {
		this.valuesSensorService = valuesSensorService;
		this.modelMapper = modelMapper;
		this.valueSensorValidator = valueSensorValidator;
	}
	
	@GetMapping()
	public ValueSensorResponse getValuesSensor(){
		return new ValueSensorResponse(valuesSensorService.findAll().stream().map(this::convertToValueSensorDTO)
				.collect(Collectors.toList()));
	}
	
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> addValueSensor(@RequestBody @Valid ValueSensorDTO valueSensorDTO, BindingResult bindingResult) {
		ValueSensor convertedValueSensor = convertToValueSensor(valueSensorDTO);
		
		valueSensorValidator.validate(convertedValueSensor, bindingResult);
		
		if(bindingResult.hasErrors()) {
			returnErrorsToClient(bindingResult);
		}
		
		valuesSensorService.saveValueSensor(convertedValueSensor);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
	
	@GetMapping("/rainyDaysCount")
	public int getRainyDays() {
		return valuesSensorService.countRainDays();
	}
	
	@ExceptionHandler
	private ResponseEntity<ValueSensorErrorResponse> handleException(ValueSensorException e){
		ValueSensorErrorResponse response = new ValueSensorErrorResponse(
				e.getMessage(), 
				System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	
	private ValueSensor convertToValueSensor(ValueSensorDTO valueSensorDTO) {
		return modelMapper.map(valueSensorDTO, ValueSensor.class);
	}
	
	private ValueSensorDTO convertToValueSensorDTO(ValueSensor valueSensor) {
		return modelMapper.map(valueSensor, ValueSensorDTO.class);
	}
	
	
	
}
