package com.axis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
   @Id	
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   @Column(name="email")
   private String email;
   
   @Column(name="password")
   private String password;
   
   //default constructor
   public Admin(){
	   
   }
   
   //Parameterized constructor
   public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
   
	//setters and getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + "]";
	}   
}
