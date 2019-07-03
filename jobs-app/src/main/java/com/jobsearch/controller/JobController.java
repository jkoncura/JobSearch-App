package com.jobsearch.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	
	// this accepts GET Request with URI "/", and returning index.html as the response.
	@GetMapping("/")
	public String rootView() {
		return "index"; // goes to index.html file, /src/main/resources/index.html
	}
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}