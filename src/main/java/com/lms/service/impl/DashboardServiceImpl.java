package com.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dto.response.DashboardDTO;
import com.lms.repository.BookRepository;
import com.lms.repository.MemberRepository;
import com.lms.repository.TransactionRepository;
import com.lms.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public DashboardDTO getDashboardData() {
		
		long totalBooks = bookRepository.getTotalBooks();
		long totalMembers = memberRepository.count();
		long totalIssuedBooks = bookRepository.getTotalIssuedBooks();
		Long totalAvailableBooks = bookRepository.getTotalAvailableBooks();
		
		DashboardDTO dashboardDTO = new DashboardDTO();
		
		dashboardDTO.setTotalBooks(totalBooks);
		dashboardDTO.setTotalIssued(totalIssuedBooks);
		dashboardDTO.setTotalMembers(totalMembers);
		dashboardDTO.setAvailableBooks(totalAvailableBooks);
		
		return dashboardDTO;
	}

}
