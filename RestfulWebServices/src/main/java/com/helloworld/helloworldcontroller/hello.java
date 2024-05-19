package com.helloworld.helloworldcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
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
