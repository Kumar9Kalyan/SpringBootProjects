package com.mywebsite.springboot.JpaandHibernate.course.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mywebsite.springboot.JpaandHibernate.course.Course;


@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		courseJpaRepository.insert(new Course(6,"Learn Data Analytics","Kalyan"));
		courseJpaRepository.insert(new Course(7,"Learn Data Science","Kalyan"));
		System.out.println( courseJpaRepository.findByID(6));
		courseJpaRepository.deleteById(7);
		
	}

}
