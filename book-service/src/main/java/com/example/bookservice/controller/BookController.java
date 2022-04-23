package com.example.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookservice.model.Book;
import com.example.bookservice.proxy.CambioProxy;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.response.Cambio;

@CrossOrigin("http://localhost:8765")
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @Autowired
    private Environment environment;
    
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

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
    
	@GetMapping(value = "/foo-bar")
//	@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
//	@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
//	@RateLimiter(name = "default")
//	@Bulkhead(name = "default")
	public String getFooBar() {
		log.info("Request getFooBar.");
		//var resp = new RestTemplate().getForEntity("http://192.168.50.1/errar", String.class);
		return "foo-bar";
	}
	
	public String fallbackMethod(Exception e) {
		return "Caiu no fallackMethod: " + e.getMessage();
	}
}
