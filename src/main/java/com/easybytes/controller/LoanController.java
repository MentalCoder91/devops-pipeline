package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	
	@GetMapping("/myLoans")
	public String getLoansDetails() {

		return "Here are the Loan details from the DB";

	}

}
