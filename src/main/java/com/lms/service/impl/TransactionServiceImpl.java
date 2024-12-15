package com.lms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dto.request.TransactionRequest;
import com.lms.dto.response.TransactionDTO;
import com.lms.enums.TransactionTypes;
import com.lms.exception.ResourceNotFoundException;
import com.lms.model.Book;
import com.lms.model.Member;
import com.lms.model.Transaction;
import com.lms.repository.BookRepository;
import com.lms.repository.MemberRepository;
import com.lms.repository.TransactionRepository;
import com.lms.service.TransactionService;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberRepository memberRepository;

	private final ModelMapper mapper = new ModelMapper();

	@Transactional
	private TransactionDTO saveTransaction(TransactionRequest transactionRequest, Book book) throws Exception {

		Transaction transaction = transactionRepository.findById(transactionRequest.getTranctionId())
				.orElse(new Transaction());

		transaction.setDueDate(transactionRequest.getDueDate());
		transaction.setBorrowDate(transactionRequest.getBorrowDate());
		transaction.setReturnDate(transactionRequest.getReturnDate());

		transaction.setBook(book);
		Member member = memberRepository.findById(transactionRequest.getMemberId())
				.orElseThrow(() -> new ResourceNotFoundException("Member not found"));
		transaction.setIssueTo(member);

		Transaction saveTransaction = null;

		synchronized (book) {
			if (transactionRequest.getTranctionId() == 0 && transactionRequest.getReturnDate() == null) {

				boolean bookAdded = member.getIssuedBooks().add(book);
				if (!bookAdded)
					throw new IllegalArgumentException("Member already having one copy of the same book.");
				transaction.setTransactionType(TransactionTypes.ISSUED);
				book.setAvailableCopies(book.getAvailableCopies() - 1);

			} else {
				boolean bookRemoved = member.getIssuedBooks().remove(book);
				if (!bookRemoved)
					throw new ResourceNotFoundException("Book entry not available to return.");
				transaction.setTransactionType(TransactionTypes.RETURNED);
				book.setAvailableCopies(book.getAvailableCopies() + 1);
			}
			saveTransaction = transactionRepository.save(transaction);
			bookRepository.save(book);
		}

		return mapper.map(saveTransaction, TransactionDTO.class);
	}

	@Override
	public TransactionDTO issueBook(TransactionRequest transactionRequest) throws Exception {

		Book book = bookRepository.findById(transactionRequest.getBookId())
				.orElseThrow(() -> new ResourceNotFoundException("No book found."));

		if (book.getAvailableCopies() <= 0)
			throw new ResourceNotFoundException("Book copy not available");

		TransactionDTO savedTransaction = saveTransaction(transactionRequest, book);

		return savedTransaction;
	}

	@Override
	public TransactionDTO returnBook(TransactionRequest transactionRequest) throws Exception {
		Book book = bookRepository.findById(transactionRequest.getBookId())
				.orElseThrow(() -> new ResourceNotFoundException("No book found."));

		TransactionDTO savedTransaction = saveTransaction(transactionRequest, book);

		bookRepository.save(book);
		return savedTransaction;
	}

	@Override
	public List<TransactionDTO> getAllTransactions() {
		List<Transaction> transactionList = transactionRepository.findAll();
		return transactionList.stream().map(transaction -> mapper.map(transaction, TransactionDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public TransactionDTO getTransaction(Long transactionId) {
		Transaction trancation = transactionRepository.findById(transactionId)
				.orElseThrow(() -> new IllegalIdentifierException("Member not found."));

		return mapper.map(trancation, TransactionDTO.class);
	}

	@Override
	public TransactionDTO getIssuedBook(Long id) {
		Transaction tr = transactionRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No issue found."));
		return mapper.map(tr, TransactionDTO.class);
	}

}
