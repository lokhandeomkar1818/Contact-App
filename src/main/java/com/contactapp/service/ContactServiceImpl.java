package com.contactapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contactapp.entity.Contact;
import com.contactapp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;

	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public String upsert(Contact contact) {
		contact.setActiveSw("Y");
		contactRepository.save(contact);
		return "Data Inserted Successfully";
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContact(int cid) {
		Optional<Contact> id = contactRepository.findById(cid);
		if (id.isPresent()) {
			return id.get();
		}
		return null;
	}

	@Override
	public String deleteContact(int cid) {
		Optional<Contact> findById = contactRepository.findById(cid);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			contactRepository.save(contact);
		}
		return "Succesfully Deleted";
	}

}
