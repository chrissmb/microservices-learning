package com.example.cambioservice.repository;

import com.example.cambioservice.model.Cambio;

import org.springframework.data.repository.Repository;

public interface CambioRepository extends Repository<Cambio, Long> {
    
    Cambio findByFromAndTo(String from, String to);
}
