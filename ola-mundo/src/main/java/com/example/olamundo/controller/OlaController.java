package com.example.olamundo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.olamundo.config.MinhasProps;
import com.example.olamundo.exception.NegocioException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class OlaController {
    
    @Autowired
    private MinhasProps minhasProps;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getOlaMundo(@RequestParam(name = "nome", defaultValue = "mundo") String nome) {
        final int nomeLength = 5;
        if (nome.length() < nomeLength) {
            throw new NegocioException(String.format("Nome deve ser maior que %d caracteres.", nomeLength));
        }
        return String.format("Olá %s!", nome);
    }

    @GetMapping("/minhas-props")
    public MinhasProps getMinhasProps() {
        return minhasProps;
    }

    @GetMapping("/sum/{value1}/{value2}")
    public Integer sum(@PathVariable("value1") Integer value1, @PathVariable("value2") Integer value2) {
        if (value1 == null || value2 == null) {
            throw new NegocioException("Números não informados.");
        }
        return value1 + value2;
    }
}
