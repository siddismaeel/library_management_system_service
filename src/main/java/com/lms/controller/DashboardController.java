package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.controller.response.GeneralResponse;
import com.lms.dto.response.DashboardDTO;
import com.lms.enums.ResponseStatus;
import com.lms.service.DashboardService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/get-dashboard-data")
	public GeneralResponse<DashboardDTO> getDashboardData(){
		
		GeneralResponse<DashboardDTO> response = new GeneralResponse<>();
		
		DashboardDTO dashboardData = dashboardService.getDashboardData();
		
		response.setData(dashboardData);
		response.setStatus(ResponseStatus.SUCCESS);
		response.setMessage("Dashboard data fetched.");	
		
		return response;
	}

}
