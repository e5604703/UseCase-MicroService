package com.casestudy.subscriptionservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.subscriptionservice.entity.Subscriber;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscriber, Integer> {

}
