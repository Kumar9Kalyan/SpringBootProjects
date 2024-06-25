package com.mywebsite.springboot.JpaandHibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
	private long Id;
	@Column
	private String name;
	@Column
	private String author;

	public Course() {

	}

	public Course(long id, String name, String author) {
		super();
		Id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(long id) {
		Id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", name=" + name + ", author=" + author + "]";
	}

}
