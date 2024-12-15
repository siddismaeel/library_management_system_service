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
import com.lms.dto.request.TransactionRequest;
import com.lms.dto.response.TransactionDTO;
import com.lms.enums.ResponseStatus;
import com.lms.service.TransactionService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/get-issues")
	public GeneralResponse<List<TransactionDTO>> getAllTransactions(){
		
		GeneralResponse<List<TransactionDTO>> response = new GeneralResponse<>();
		List<TransactionDTO> allTransactions = transactionService.getAllTransactions();
		
		response.setData(allTransactions);
		response.setMessage("Transactions fetched");
		response.setStatus(ResponseStatus.SUCCESS);
		
		return response;
	}
	
	/*
	 *  All exceptions are handled globally
	 */	
	@PostMapping("/issue-book")
	public GeneralResponse<TransactionDTO> issue(@RequestBody TransactionRequest transactionRequest) throws Exception{
		
		GeneralResponse<TransactionDTO> response = new GeneralResponse<>();
		
		TransactionDTO issued = transactionService.issueBook(transactionRequest);
		
		response.setData(issued);
		response.setMessage("Book Issued");
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}
	
	@PostMapping("/return-book")
	public GeneralResponse<TransactionDTO> returnBook(@RequestBody TransactionRequest transactionRequest) throws Exception{
		
		GeneralResponse<TransactionDTO> response = new GeneralResponse<>();
		
		TransactionDTO issued = transactionService.returnBook(transactionRequest);
		
		response.setData(issued);
		response.setMessage("Book Issued");
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}
	
	@GetMapping("/get-issuance/{issueId}")
	public GeneralResponse<TransactionDTO> getIssue(@PathVariable("issueId") Long id){
		
		GeneralResponse<TransactionDTO> response = new GeneralResponse<>();
		
		TransactionDTO issued = transactionService.getIssuedBook(id);
		
		response.setData(issued);
		response.setMessage("Issue fetched.");
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}


}
