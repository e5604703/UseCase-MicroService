package com.casestudy.bookservice;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.entity.Book;
import com.casestudy.service.BookService;

@WebMvcTest
class BookServiceTest {
	
	@MockBean
	private BookService bookService;
	
    @Test 
    void testSave()
    {  	        Book book = new Book();
		    book.setBook_id(1);
		    book.setBook_name("book1");
		    book.setAuthor("author1");
		    book.setAvaiable_copies(1);
		    book.setTotal_copies(5);
		    
		    Mockito.when(bookService.saveBook(book)).thenReturn(book);	    
		    Assert.assertThat(book.getBook_name(),is("book1"));;
		   
    
    }

}
