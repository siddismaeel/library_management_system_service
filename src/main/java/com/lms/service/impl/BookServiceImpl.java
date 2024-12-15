package com.lms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dto.request.BookRequestDTO;
import com.lms.dto.response.BookDTO;
import com.lms.dto.response.BookDopdownDTO;
import com.lms.exception.ResourceNotFoundException;
import com.lms.model.Book;
import com.lms.repository.BookRepository;
import com.lms.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDTO getBook(Long bookId) throws ResourceNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
		return modelMapper.map(book, BookDTO.class);
	}

	@Override
	public List<BookDTO> getAllBooks() {

		List<Book> books = bookRepository.findAll();

		return books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}

	@Override
	public BookDTO saveBook(BookRequestDTO bookDto) {

		Book book = bookRepository.findById(bookDto.getBookId()).orElse(new Book());

		book.setAvailableCopies(bookDto.getAvailableCopies());
		book.setPublisher(bookDto.getPublisher());
		book.setTitle(bookDto.getTitle());
		book.setTotalCopies(bookDto.getTotalCopies());
		book.setYearOfPublication(bookDto.getYearOfPublication());
		book.setAuthorName(bookDto.getAuthorName());
		Book savedBook = bookRepository.save(book);

		return modelMapper.map(savedBook, BookDTO.class);

	}

	@Override
	public List<BookDopdownDTO> getBooksForDropdown() {

		List<Book> searchBookForDropdown = bookRepository.findAll();
		return searchBookForDropdown.stream().map(book -> modelMapper.map(book, BookDopdownDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> searchBook(String bookName) {

//		bookRepository
		return null;
	}

}
