package com.ayty.fintech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.Entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

}
