package com.infy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeException;
import com.infy.service.EmployeeServiceImpl;

import jakarta.validation.Valid;


@RestController
@CrossOrigin
//@RequestMapping("chandu")
@Validated
public class EmpController {

	@Autowired
	EmployeeServiceImpl service;


	//@PostMapping()
	public ResponseEntity<String> add(@Valid @RequestBody EmployeeDTO e1) {
		HttpHeaders header = new HttpHeaders();
		header.set("Method","POST");
		return new ResponseEntity<>(service.add(e1),header,HttpStatus.ACCEPTED);
	}

	//@GetMapping
	public ResponseEntity<List<EmployeeDTO>> get() throws EmployeeException {
		ResponseEntity.status(HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.get());
	}
	//@PutMapping(value="/{eId}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable("eId") Integer eId, @Valid @RequestBody EmployeeDTO empDTO) throws EmployeeException {
		HttpHeaders header = new HttpHeaders();
		header.set("Method","PUT");
		return new ResponseEntity<>(service.update(eId, empDTO),header,HttpStatus.ACCEPTED);
	}
	@DeleteMapping(value="/eId/{eId}")
	public ResponseEntity<String> delete(@PathVariable("eId") Integer eId) throws EmployeeException {
		HttpHeaders header = new HttpHeaders();
		header.set("Method","DELETE");
		return new ResponseEntity<>(service.delete(eId),header,HttpStatus.ALREADY_REPORTED);
	}
}
