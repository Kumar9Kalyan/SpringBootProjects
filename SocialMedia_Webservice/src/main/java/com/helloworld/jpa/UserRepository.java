package com.helloworld.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloworld.socialmedia.user.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
