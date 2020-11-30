package com.ayty.fintech.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.Entity.Consummer;
import com.ayty.fintech.Entity.User;


@Repository
public interface ConsummerRepository extends JpaRepository<Consummer, Long>{
	Optional<User> findByUsername(String username);
}
