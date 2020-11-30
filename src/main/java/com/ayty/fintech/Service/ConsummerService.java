package com.ayty.fintech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.Entity.Consummer;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Repository.ConsummerRepository;

@Service
public class ConsummerService {
	@Autowired
	ConsummerRepository consummerRepository;
	
	public List<Consummer> getAllConsummer() throws ResourceNotFoundException {
		List<Consummer> consummerList = consummerRepository.findAll();
		if(consummerList.isEmpty()) {
			throw new ResourceNotFoundException("Consummer not found");
		} else {
			return consummerList;
		}
	}
	
	public Consummer getOneConsummer(long id) throws ResourceNotFoundException {
		Optional<Consummer> consummerFirst = consummerRepository.findById(id);
		if(!consummerFirst.isPresent()) {
			throw new ResourceNotFoundException("Consummer not found");
		} else {
			return consummerFirst.get();
		}
	}
	
	public Consummer saveConsummer(Consummer consummer) {
		return consummerRepository.save(consummer);
	}
}
