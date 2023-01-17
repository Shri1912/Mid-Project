package com.axis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Admin;
import com.axis.repository.AdminRepository;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	
    @PostMapping("/create")
	public ResponseEntity<Admin> createUser(@RequestBody Admin admin){
    	 try {
				 Admin _user = adminRepository.save(new Admin(admin.getEmail(),admin.getPassword()));
    		 return new ResponseEntity<>(_user,HttpStatus.CREATED); 
    	 }catch(Exception ex) {
    		 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR); 
    	 }    	
	  }
	 
	  @GetMapping("/fetch")
	   public ResponseEntity<List<Admin>> getAllAdmin(){
		   try {
			   List<Admin> admins = new ArrayList<Admin>();
	    	   adminRepository.findAll().forEach(admins::add);
	    	   if(admins.isEmpty()) {
	    		   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	   }
	    	   return new ResponseEntity<>(admins,HttpStatus.OK);
		   }catch(Exception ex) {
			   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR); 
		   }
		 }
	   
	   @GetMapping("/fetch_user/{id}")
	   public ResponseEntity<Admin> getUserById(@PathVariable("id") long id){
		  Optional<Admin> adminData = adminRepository.findById(id);
		  if(adminData.isPresent()) {
			  return new ResponseEntity<>(adminData.get(),HttpStatus.OK);
		  }else {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  }
	   }   
  
	   
	   
	   
	   @PostMapping("/validate")
	   public String validateUser(@RequestBody Admin admin){
		   String msg = "";	
		   try {
			   Admin adminData = adminRepository.findAdminByEmail(admin.getEmail());
			   if( admin.getEmail().equals(adminData.getEmail()) && admin.getPassword().equals(adminData.getPassword())) {
					 msg = "valid";
				   }else {
					   return "invalid";
		       } 
		   }catch(Exception ex) {
			   	msg ="invalid";
		   } 	   
		   
		return msg; 		   
	   }
	   
	   @PutMapping("/update_admin/{id}")
	   public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id,@RequestBody Admin admin){
		   Optional<Admin> adminData = adminRepository.findById(id);
		   if(adminData.isPresent()) {
			   Admin _admin = adminData.get();
			   _admin.setEmail(admin.getEmail());
			   _admin.setPassword(admin.getPassword());
			   return new ResponseEntity<>(adminRepository.save(_admin),HttpStatus.OK);
		   }else {
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		   }
	   }
	   
	   @DeleteMapping("/delete_admin/{id}")
	   public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") long id){
		   try {			   
			   adminRepository.deleteById(id);
			   return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		   }catch(Exception ex) {
			  return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		   }
	   }
}
