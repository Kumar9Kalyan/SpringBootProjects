package com.mywebsite.springboot.JpaandHibernate.course.DataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mywebsite.springboot.JpaandHibernate.course.Course;

@Component
public class DataJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private SpringDataJpaRepository dataRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dataRepository.save(new Course(8,"Learn Python","Kalyan"));
		dataRepository.save(new Course(9,"Learn NeuroScience","Krishna"));
		System.out.println(dataRepository.findById(8l));
		dataRepository.deleteById(8l);
		System.out.println(dataRepository.findAll());
		System.out.println(dataRepository.count());
		System.out.println(dataRepository.findByAuthor("Kalyan"));
		System.out.println(dataRepository.findByName("Learn NeuroScience"));
		
	}

}
