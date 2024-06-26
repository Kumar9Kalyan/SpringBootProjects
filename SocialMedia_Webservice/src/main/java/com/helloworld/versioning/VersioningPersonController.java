package com.helloworld.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	//URI versioning (Twitter)
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		
		return new PersonV1("Kumar Kalyan");
		
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		
		return new PersonV2(new Name("kumar", "kalyan"));
		
	}
	
	//Request parameter versioning(Amazon)
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		
		return new PersonV1("kumar kalyan");
		
	}
	
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		
		return new PersonV2(new Name("kumar","kalyan"));
	}
	
	
	//Custom header versioning(Microsoft)
	@GetMapping(path="/person/header", headers ="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		
		return new PersonV1("kumar kalyan");
		
	}
	
	
	@GetMapping(path="/person/header",headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		
		return new PersonV2(new Name("kumar","kalyan"));
	}
	
	//Media type versioning (Content negotiation or Accept header)- Github 
	@GetMapping(path="/person/accept", produces ="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		
		return new PersonV1("kumar kalyan");
		
	}
	@GetMapping(path="/person/accept",produces ="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		
		return new PersonV2(new Name("kumar","kalyan"));
	}

}
