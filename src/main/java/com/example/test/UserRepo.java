package com.example.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Student, Integer> {
      
	public boolean existsByEmail(String email);
}
