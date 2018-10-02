package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource; 

	@GetMapping(path = "/hello-world", produces = "application/vnd.company.app-v1+json")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean", produces = "application/vnd.company.app-v1+json")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	///hello-world/path-variable/
	@GetMapping(path = "/hello-world/path-variable/{name}", produces = "application/vnd.company.app-v1+json")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-world-internationalized", produces = "application/vnd.company.app-v1+json")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}
