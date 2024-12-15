package com.lms.service;

import java.util.List;

import com.lms.dto.request.TransactionRequest;
import com.lms.dto.response.TransactionDTO;

public interface TransactionService {

//	public TransactionDTO saveTransaction(TransactionRequest transactionRequest) throws Exception;
	public List<TransactionDTO> getAllTransactions();
	public TransactionDTO getTransaction(Long transactionId);
	public TransactionDTO issueBook(TransactionRequest transactionRequest) throws Exception;
	public TransactionDTO returnBook(TransactionRequest transactionRequest) throws Exception;
	public TransactionDTO getIssuedBook(Long id);

}
