package com.casestudy.subscriptionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.subscriptionservice.entity.Subscriber;
import com.casestudy.subscriptionservice.repo.SubscriptionRepo;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepo subscriptionRepo;
	
	public List<Subscriber> getAllSubscriber() {
		
		return subscriptionRepo.findAll();
		
	}

	public Subscriber setSubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stubs\
		return  subscriptionRepo.save(subscriber);
		   
		  
	}
}
