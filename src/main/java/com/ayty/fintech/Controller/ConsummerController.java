package com.ayty.fintech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayty.fintech.Entity.Consummer;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Service.ConsummerService;

@RestController
public class ConsummerController {
	
	@Autowired
	ConsummerService consummerService;
	
	@GetMapping("/users/consummers")
	public ResponseEntity<List<Consummer>> getAllConsummer() {
		try {
			return new ResponseEntity<>(this.consummerService.getAllConsummer(), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/users/consummers/{id}")
	public ResponseEntity<Consummer> getOneConcummer(@PathVariable(value = "id") long id){
		try {
			return new ResponseEntity<>(this.consummerService.getOneConsummer(id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/users/consummers")
	public ResponseEntity<Consummer> saveConsummer(@RequestBody @Validated Consummer consummer) {
		return new ResponseEntity<Consummer> (this.consummerService.saveConsummer(consummer), HttpStatus.CREATED);
	}

}
