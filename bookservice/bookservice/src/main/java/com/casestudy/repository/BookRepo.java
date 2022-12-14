package com.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	
}
