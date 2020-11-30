package com.ayty.fintech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.Entity.Seller;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	SellerRepository sellerRepository;	
	
	public List<Seller> getAllSeller() throws ResourceNotFoundException {
		List<Seller> sellerList = sellerRepository.findAll();
		if(sellerList.isEmpty()) {
			throw new ResourceNotFoundException("Users not found");
		} else {
			return sellerList;
		}
	}
	
	public Seller getOneSeller(long id) throws ResourceNotFoundException {
		Optional<Seller> sellerFirst = sellerRepository.findById(id);
		if(!sellerFirst.isPresent()) {
			throw new ResourceNotFoundException("No user for this ID");
		} else {
			return sellerFirst.get();
		}
	}
	
	public Seller saveSeller(Seller seller) {
		return sellerRepository.save(seller);
	}
}
