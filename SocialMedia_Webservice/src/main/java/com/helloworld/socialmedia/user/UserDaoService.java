package com.helloworld.socialmedia.user;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

//Dao stands for Data Access Object

@Component
public class UserDaoService {

	private static int count=0;
	
	//JPA/Hibernate > Database
	//UserDaoService > Static list
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(++count,"Rakesh",LocalDate.now().minusYears(30)));
		users.add(new User(++count,"Lokesh",LocalDate.now().minusYears(25)));
		users.add(new User(++count,"Rajani",LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAll(){
		return users;
	}
	

	
	public User findOne(int id) {
		
		Predicate<? super User> perdicate = user -> user.getId().equals(id) ; 
		return users.stream().filter(perdicate).findFirst().orElse(null);		
	}
	
	public void deleteById(int id) {
		
		Predicate<? super User> predicate= user-> user.getId().equals(id);
		users.removeIf(predicate);
		
	}
	
	public User save(User user) {
		user.setId(++count);
		users.add(user);
		
		return user;
	}
}
