package com.mywebsite.springboot.JpaandHibernate.course.DataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywebsite.springboot.JpaandHibernate.course.Course;

public interface SpringDataJpaRepository  extends JpaRepository<Course, Long>{

	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
