package com.helloworld.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@Autowired
	private FilterClass filterClass;

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean= new SomeBean("value1","value2","value3");
		
		
		return filterClass.filterLogic(someBean, "field1", "field3");
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		
		
		
		List<SomeBean> listBean = Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6"));
		
		
		return filterClass.filterLogic(listBean, "field2", "field3");
	}
}
