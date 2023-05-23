package com.contactapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contactapp.entity.Contact;
import com.contactapp.service.ContactServiceImpl;

@RestController
public class ContactController {

	private ContactServiceImpl contactServiceImpl;

	public ContactController(ContactServiceImpl contactServiceImpl) {
		this.contactServiceImpl = contactServiceImpl;
	}

	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact) {
		System.out.println(contact);
		String upsert = contactServiceImpl.upsert(contact);
		return new ResponseEntity<>(upsert, HttpStatus.CREATED);
	}

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		List<Contact> allContacts = contactServiceImpl.getAllContacts();
		return new ResponseEntity<>(allContacts, HttpStatus.OK);
	}

	@GetMapping("/contact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable int cid) {
		Contact contact = contactServiceImpl.getContact(cid);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid) {
		String deleteContact = contactServiceImpl.deleteContact(cid);
		return new ResponseEntity<>(deleteContact, HttpStatus.ACCEPTED.OK);
	}
}
