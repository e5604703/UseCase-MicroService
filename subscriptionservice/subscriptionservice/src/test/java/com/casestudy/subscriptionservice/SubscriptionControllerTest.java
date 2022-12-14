package com.casestudy.subscriptionservice;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.casestudy.subscriptionservice.entity.Subscriber;
import com.casestudy.subscriptionservice.service.SubscriptionFeignClient;
import com.casestudy.subscriptionservice.service.SubscriptionService;


@WebMvcTest
class SubscriptionControllerTest {

	@MockBean
	SubscriptionService service;
	
	@MockBean
	SubscriptionFeignClient feignClient;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testGetSubs() throws Exception {
		  List<Subscriber> subscribers = new ArrayList<>();
		  Subscriber subscriber = new Subscriber();
	        subscriber.setBookid(1);
	        subscriber.setSubscriberid(1);
	        subscriber.setDatereturned(new Date());
	        subscriber.setSubscribername("subs");
	        subscribers.add(subscriber);
	        
	        Mockito.when(service.getAllSubscriber()).thenReturn(subscribers);
	            
	        mockMvc.perform(get("/subscription"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", Matchers.hasSize(1)))
          .andExpect(jsonPath("$[0].subscribername", Matchers.equalTo("subs")));
	}

}
