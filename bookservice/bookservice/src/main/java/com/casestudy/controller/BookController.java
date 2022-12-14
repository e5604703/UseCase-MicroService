package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.entity.Book;
import com.casestudy.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public List<Book> findAllBook(){
		return bookService.getAllBook();
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book){
		return bookService.saveBook(book);
	}
}
