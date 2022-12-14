package com.casestudy.subscriptionservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	private int book_id;
	private String Book_name;
	private String author;
	private int avaiable_copies;
	private int Total_copies;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return Book_name;
	}
	public void setBook_name(String book_name) {
		Book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvaiable_copies() {
		return avaiable_copies;
	}
	public void setAvaiable_copies(int avaiable_copies) {
		this.avaiable_copies = avaiable_copies;
	}
	public int getTotal_copies() {
		return Total_copies;
	}
	public void setTotal_copies(int total_copies) {
		Total_copies = total_copies;
	}
	
	
}
