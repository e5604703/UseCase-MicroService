package com.casestudy.subscriptionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casestudy.subscriptionservice.entity.Book;
import com.casestudy.subscriptionservice.entity.Subscriber;

@FeignClient(name="book")
public interface SubscriptionFeignClient {

	@GetMapping("book")
	public Book[] getbooks();
	
	@PostMapping("book")
	public Book saveBook(Book book);
}
