package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.entity.Book;
import com.casestudy.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getAllBook(){	
		return bookRepo.findAll();
	}

	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
}
