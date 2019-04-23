package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;


@RestController
@RequestMapping(value="/api", consumes=MediaType.APPLICATION_JSON_VALUE)
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postRepository.findAll(); 
	}
	
	@GetMapping("/posts/{id}")
	public Post getPostById(@PathVariable("id") String id){
		return postRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/posts")
	public Post savePost(@Valid @RequestBody Post post){
		 return postRepository.save(post);
	}
	
	@PutMapping("/posts")
	public Post updatePost(@Valid Post post){
		 return postRepository.save(post);
	}
	
	@DeleteMapping("/posts/{id}")
	public String deletePostById(@PathVariable("id") String id){
		postRepository.deleteById(id);
		return "successfully removed post, postid:"+id;
	}
}
