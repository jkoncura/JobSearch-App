package com.jobsearch.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {
	
	@GetMapping(value ="/")
	public String rootView() {
		return "index"; // goes to index.html file, /src/main/resources/index.html
	}
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}
