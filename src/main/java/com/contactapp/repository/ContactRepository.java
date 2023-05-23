package com.contactapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactapp.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
