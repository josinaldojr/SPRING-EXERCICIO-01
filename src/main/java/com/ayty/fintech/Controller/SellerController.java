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

import com.ayty.fintech.Entity.Seller;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Service.SellerService;

@RestController
public class SellerController {
	@Autowired
	SellerService sellerService;
	
	@GetMapping("/users/sellers")
	public ResponseEntity<List<Seller>> getAllSeller() {
		try {
			return new ResponseEntity<>(this.sellerService.getAllSeller(), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/users/sellers/{id}")
	public ResponseEntity<Seller> getOneSeller(@PathVariable(value = "id") long id){
		try {
			return new ResponseEntity<>(this.sellerService.getOneSeller(id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/users/sellers")
	public ResponseEntity<Seller> saveSeller(@RequestBody @Validated Seller seller) {
		return new ResponseEntity<Seller> (this.sellerService.saveSeller(seller), HttpStatus.CREATED);
	}
	
}
