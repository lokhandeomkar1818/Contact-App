package com.contactapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CONTACT_DTLS")
@Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Contact_Id")
	private int cid;

	@Column(name = "Contact_Name")
	private String name;

	@Column(name = "Contact_Email")
	private String email;

	@Column(name = "Contact_Phno")
	private long phno;

	@Column(name = "Active_Sw")
	private String activeSw;
}
