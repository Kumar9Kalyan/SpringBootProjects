package com.mywebsite.springboot.JpaandHibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mywebsite.springboot.JpaandHibernate.course.Course;


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1,"Learn Machine Learning","Kalyan"));
		repository.insert(new Course(2,"Learn Deep learning","Kalyan"));
		repository.insert(new Course(3,"Learn DevOps","Kalyan"));
		repository.insert(new Course(4,"Learn SpringBoot","Kalyan"));
		repository.insert(new Course(5,"Learn Node.js","Kalyan"));
		repository.deleteById( 3);
		System.out.println(repository.findById(1));
		
		
	}

}
