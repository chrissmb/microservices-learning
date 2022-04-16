package com.example.bookservice.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookservice.response.Cambio;

@FeignClient(name = "cambio-service")
public interface CambioProxy {

    @GetMapping(value = "cambio/{amount}/{from}/{to}")
    Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to);
}
