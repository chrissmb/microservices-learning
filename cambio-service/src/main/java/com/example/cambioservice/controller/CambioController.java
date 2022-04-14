package com.example.cambioservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import com.example.cambioservice.model.Cambio;
import com.example.cambioservice.repository.CambioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("cambio")
public class CambioController {

    @Autowired
    private CambioRepository cambioRepository;

    @Autowired
    private Environment environment;
    
    @GetMapping(value="{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable BigDecimal amount,
            @PathVariable String from,
            @PathVariable String to) {
        Cambio cambio = cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) {
            throw new RuntimeException("Cambio not found.");
        }
        String port = environment.getProperty("local.server.port");
        cambio.setConvertedValue(amount.multiply(cambio.getConvertionFactor()));
        cambio.setEnvironment(port);
        return cambio;
    }
    
}
