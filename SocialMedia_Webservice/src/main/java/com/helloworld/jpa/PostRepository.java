package com.helloworld.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloworld.socialmedia.user.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
