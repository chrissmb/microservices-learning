package com.example.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookservice.model.Book;
import com.example.bookservice.proxy.CambioProxy;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.response.Cambio;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @Autowired
    private Environment environment;

    @GetMapping(value = "{id}/{currency}")
    public Book getBook(@PathVariable Long id, @PathVariable String currency) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found."));
        Cambio cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
        String port = environment.getProperty("local.server.port");
        book.setPrice(cambio.getConvertedValue());
        book.setEnvironment(port + " cambio" + cambio.getEnvironment());
        book.setCurrency(currency);
        return book;
    }

}
