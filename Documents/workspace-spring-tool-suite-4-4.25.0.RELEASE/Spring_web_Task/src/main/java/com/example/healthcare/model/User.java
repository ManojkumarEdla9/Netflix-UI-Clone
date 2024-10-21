package com.example.healthcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String mobile;
    private String password;
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setUsername(Object username2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email) {
		// TODO Auto-generated method stub
		
	}
}
