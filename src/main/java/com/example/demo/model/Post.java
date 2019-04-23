/**
 * 
 */
package com.example.demo.model;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndexes({
	@CompoundIndex(def="{id:1, author:1, post:1}"),
	@CompoundIndex(def="{author:1, post:1}")
})
public class Post {
	@Id
	@NotEmpty
	private String id;
	@Indexed
	private String author;
	@Indexed
	private String post;
	private Set<String> comments;
	
	/**
	 * 
	 */
	public Post() {
		super();
	}

	/**
	 * @param id
	 * @param author
	 * @param post
	 * @param comments
	 */
	public Post(String id, String author, String post, Set<String> comments) {
		super();
		this.id = id;
		this.author = author;
		this.post = post;
		this.comments = comments;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @return the comments
	 */
	public Set<String> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<String> comments) {
		this.comments = comments;
	}
	
}
