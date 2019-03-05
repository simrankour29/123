package com.cg.payroll.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class URIController {
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
     
}
