package com.contactapp.service;

import java.util.List;

import com.contactapp.entity.Contact;

public interface ContactService {

	public String upsert(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContact(int cid);

	public String deleteContact(int cid);
}
