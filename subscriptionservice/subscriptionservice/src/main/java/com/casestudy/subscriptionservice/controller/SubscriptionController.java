package com.casestudy.subscriptionservice.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.subscriptionservice.entity.Book;
import com.casestudy.subscriptionservice.entity.Subscriber;
import com.casestudy.subscriptionservice.service.SubscriptionFeignClient;
import com.casestudy.subscriptionservice.service.SubscriptionService;

import io.github.resilience4j.retry.annotation.Retry;



@RestController
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	SubscriptionFeignClient feignClient;
	
	@GetMapping("/subscription")
	public List<Subscriber> getSubs(){
		return subscriptionService.getAllSubscriber();
	}
	
	@Transactional
	@PostMapping(path = "/subscription",produces = "application/json")
	@Retry(name="breaker",fallbackMethod = "exceptionCatcher")
	public String setSubr1(@RequestBody Subscriber subscriber){
		boolean saved=false;
		
		Book[] books =feignClient.getbooks();
		Book book = new Book();
		for(int i=0;i<books.length;i++) {
			if(books[i].getBook_id()==subscriber.getBookid()
			   && books[i].getAvaiable_copies()>0) {
				subscriptionService.setSubscriber(subscriber);
				book = books[i];
				book.setAvaiable_copies(books[i].getAvaiable_copies()-1);
				feignClient.saveBook(book);
				saved=true;
			}
		}
		if (!saved)
		{
			throw new RuntimeException(" test transaction rollback");
		}
		return "Saved";
	}
	public String exceptionCatcher(Subscriber subscriber, Throwable e) {
		return  "from fallbackMethod";
	}
}
