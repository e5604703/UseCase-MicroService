package com.casestudy.subscriptionservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriberid;
	private String subscribername;
	private Date datesubscribed;
	private Date datereturned;
	private int bookid;
	
	public int getSubscriberid() {
		return subscriberid;
	}
	public void setSubscriberid(int subscriberid) {
		this.subscriberid = subscriberid;
	}
	public String getSubscribername() {
		return subscribername;
	}
	public void setSubscribername(String subscribername) {
		this.subscribername = subscribername;
	}
	public Date getDatesubscribed() {
		return datesubscribed;
	}
	public void setDatesubscribed(Date datesubscribed) {
		this.datesubscribed = datesubscribed;
	}
	public Date getDatereturned() {
		return datereturned;
	}
	public void setDatereturned(Date datereturned) {
		this.datereturned = datereturned;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	
	
}
