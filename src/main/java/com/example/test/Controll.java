package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@RestController
public class Controll {

	@Autowired
	private UserRepo userRepo;

	@PostMapping("/")
	public String login(@RequestBody StudentDTO studentDTO) {

		boolean f = userRepo.existsByEmail(studentDTO.getEmail());
		
		if (f) {
			return "Login Successfully";
		}

		return "Invalid Credentials";
	}

	@PostMapping("/register")
	public String createUser(@RequestBody Student student) {
		String password = student.getPassword();

		boolean f = userRepo.existsByEmail(student.getEmail());

		if (f) {
			return "User already exists";
		}

		userRepo.save(student);

		return "Registered Successfully";
	}

}
