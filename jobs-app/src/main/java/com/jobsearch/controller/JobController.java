package com.jobsearch.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobController {
	
	@GetMapping(value ="/")
	public String rootView() {
		return "index"; // goes to index.html file, /src/main/resources/index.html
	}
	@GetMapping(value= "/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}