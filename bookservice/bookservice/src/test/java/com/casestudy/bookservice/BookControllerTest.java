package com.casestudy.bookservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.casestudy.entity.Book;
import com.casestudy.service.BookService;

@WebMvcTest
class BookControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	 @Test
	    public void testGetBook() throws Exception {
	        List<Book> books = new ArrayList<>();
	        Book book = new Book();
	        book.setBook_id(1);
	        book.setBook_name("book1");
	        book.setAuthor("author1");
	        book.setAvaiable_copies(1);
	        book.setTotal_copies(5);
	        books.add(book);
	        Mockito.when(bookService.getAllBook()).thenReturn(books);
	        
	        mockMvc.perform(get("/book"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", Matchers.hasSize(1)))
            .andExpect(jsonPath("$[0].book_name", Matchers.equalTo("book1")));
	    }

}
