package org.sid.web;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class ContactController {
	@Autowired
	private ContactRepository contactRepository;
	@PostMapping("/addContact")
    public Contact saveContact(@RequestBody Contact contact) {
		System.out.println("********************");
		return this.contactRepository.save(contact);	
	}
}
