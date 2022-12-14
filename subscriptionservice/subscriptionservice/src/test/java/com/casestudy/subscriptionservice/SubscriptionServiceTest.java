package com.casestudy.subscriptionservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.subscriptionservice.entity.Subscriber;
import com.casestudy.subscriptionservice.service.SubscriptionFeignClient;
import com.casestudy.subscriptionservice.service.SubscriptionService;

@WebMvcTest
class SubscriptionServiceTest {

	@MockBean
	SubscriptionService service;
	
	@MockBean
	SubscriptionFeignClient feignClient;
	
	@Test
	void testGetAllSubscriber() {
		List<Subscriber> subscribers = new ArrayList<>();
		Subscriber subscriber = new Subscriber();
        subscriber.setBookid(1);
        subscriber.setSubscriberid(1);
        subscriber.setDatereturned(new Date());
        subscriber.setSubscribername("subs");
        subscribers.add(subscriber);
        Mockito.when(service.getAllSubscriber()).thenReturn(subscribers);	    
	    Assert.assertThat(subscriber.getSubscribername(),is("subs"));;

	}

	@Test
	void testSetSubscriber() {
		Subscriber subscriber = new Subscriber();
        subscriber.setBookid(1);
        subscriber.setSubscriberid(1);
        subscriber.setDatereturned(new Date());
        subscriber.setSubscribername("subs");
		    
		    Mockito.when(service.setSubscriber(subscriber)).thenReturn(subscriber);	    
		    Assert.assertThat(subscriber.getSubscribername(),is("subs"));;
	}

}
