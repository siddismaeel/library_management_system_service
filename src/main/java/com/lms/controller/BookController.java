package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.controller.response.GeneralResponse;
import com.lms.dto.request.BookRequestDTO;
import com.lms.dto.response.BookDTO;
import com.lms.dto.response.BookDopdownDTO;
import com.lms.enums.ResponseStatus;
import com.lms.exception.ResourceNotFoundException;
import com.lms.service.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/*
	 * All Exceptions are handled globally
	 */	@GetMapping("/get-book/{book_id}")
	public GeneralResponse<BookDTO> getBook(@PathVariable("book_id") Long bookId) throws ResourceNotFoundException {
		GeneralResponse<BookDTO> response = new GeneralResponse<>();
		BookDTO book = bookService.getBook(bookId);
		
		response.setData(book);
		response.setMessage("Book saved.");
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}
	
	@PostMapping("/save-book")
	public GeneralResponse<BookDTO> saveBook(@RequestBody BookRequestDTO booDto){
		
		GeneralResponse<BookDTO> response = new GeneralResponse<>();
		
		BookDTO savedBook = bookService.saveBook(booDto);
		
		response.setData(savedBook);
		response.setMessage("Book saved.");
		response.setStatus(ResponseStatus.SUCCESS);
		
		return response;
		
	}
	
	@GetMapping("/get-book-list")
	public GeneralResponse<List<BookDTO>> getAllBooks(){
		
		GeneralResponse<List<BookDTO>> response = new GeneralResponse<>();
		
		List<BookDTO> savedBook = bookService.getAllBooks();
		
		response.setData(savedBook);
		response.setMessage("Book saved.");
		response.setStatus(ResponseStatus.SUCCESS);
		
		return response;
		
	}
	
	@GetMapping("/get-book-dropdown")
	public GeneralResponse<List<BookDopdownDTO>> getBooksForDropdown(){
		GeneralResponse<List<BookDopdownDTO>> response = new GeneralResponse<>();
		
		List<BookDopdownDTO> books = bookService.getBooksForDropdown();
		
		response.setData(books);
		response.setStatus(ResponseStatus.SUCCESS);
		response.setMessage("Books fetch");
		
		return response;
	}
	
	
}
