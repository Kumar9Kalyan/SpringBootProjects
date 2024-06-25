package com.mywebsite.springboot.JpaandHibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mywebsite.springboot.JpaandHibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	private static final String DELETE_QUERY = """
			delete from course where id=?;
			""";
	private static final String SELECT_QUERY = """
			select * from course where id=?;
			""";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static String INSERT_QUERY = 
			"""
			insert into course (Id,name,author) values (?,?,?);
			""";		
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY, course.getId(),course.getName(),course.getAuthor());
	}
	public void deleteById(long i) {
		jdbcTemplate.update(DELETE_QUERY,i);
	}
	public Course findById(long id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
	}
}
