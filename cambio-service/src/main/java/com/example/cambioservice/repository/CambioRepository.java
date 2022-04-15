package com.example.cambioservice.repository;

import java.util.Optional;

import com.example.cambioservice.model.Cambio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
    
    Optional<Cambio> findByFromAndTo(String from, String to);
}
