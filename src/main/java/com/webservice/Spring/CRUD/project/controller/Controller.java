package com.webservice.Spring.CRUD.project.controller;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.Spring.CRUD.project.modal.Modal;

@RestController
@RequestMapping("/users")
public class Controller {
	
	HashMap<String,Modal> hmap = new HashMap<>();
	
	@GetMapping
	public Collection<Modal> getMethod() {
		return hmap.values();
	}
	
	@PostMapping
	public String addMethod(@RequestBody Modal userDetails) {
		Modal modal = new Modal();
		modal.setUserId(userDetails.getUserId());
		modal.setName(userDetails.getName());
		modal.setEmail(userDetails.getEmail());
		
		hmap.put(userDetails.getUserId(),modal);
		return "Updated";	
	}
	
	@PutMapping(path="/{userId}")
	public String updateMethod(@PathVariable String userId,@RequestBody Modal userDetails) {
		Modal modal = new Modal();
		if(hmap.containsKey(userId)) {
			modal.setUserId(userDetails.getUserId());
			modal.setName(userDetails.getName());
			modal.setEmail(userDetails.getEmail());
			hmap.put(userDetails.getUserId(),modal);
			return "Updated";
		}
		else {
			return "Not updated";
		}
	}
	
	@DeleteMapping(path="/{userId}")
	public String deleteMethod(@PathVariable String userId) {
		if(hmap.containsKey(userId)) {
			hmap.remove(userId);
			return "Deleted";
		}
		else {
			return "Not deleted";
		}
		
	}
	
}
