package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	
	@GetMapping("/contact")
	public String getContactInquiryDetails() {

		return "Here are the Contact details from the DB";

	}

}
