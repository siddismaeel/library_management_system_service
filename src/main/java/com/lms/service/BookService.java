package com.lms.service;

import java.util.List;

import com.lms.dto.request.BookRequestDTO;
import com.lms.dto.response.BookDTO;
import com.lms.dto.response.BookDopdownDTO;
import com.lms.exception.ResourceNotFoundException;

public interface BookService {

	public BookDTO getBook(Long bookId) throws ResourceNotFoundException;
	public List<BookDTO> getAllBooks();
	public BookDTO saveBook(BookRequestDTO book);
	public List<BookDTO> searchBook(String bookName);
	public List<BookDopdownDTO> getBooksForDropdown();
}
