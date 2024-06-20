package com.helloworld.helloworldcontroller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	
	private MessageSource messageSource;

	public hello(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		
	Locale locale =LocaleContextHolder.getLocale() ;
	return	messageSource.getMessage("good.morning.message", null, "Default Message", locale  );
	
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		
		return new HelloWorldBean("Hello World");
	}
	
	
	
	
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		
		return new HelloWorldBean(String.format("Hello %s", name));
	}
	
}
