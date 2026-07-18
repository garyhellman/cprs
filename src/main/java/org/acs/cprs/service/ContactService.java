package org.acs.cprs.service;

import java.util.ArrayList;
import java.util.List;

import org.acs.cprs.model.Contact;
import org.acs.cprs.repository.ContactRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional(readOnly = true)
    public List<Contact> getContactList(int start, int limit) {
        int page = limit > 0 ? start / limit : 0;
        return contactRepository.findAll(PageRequest.of(page, Math.max(limit, 1))).getContent();
    }

    @Transactional
    public List<Contact> create(Contact contact) {
        List<Contact> created = new ArrayList<>();
        created.add(contactRepository.save(contact));
        return created;
    }

    @Transactional
    public List<Contact> update(Contact contact) {
        List<Contact> updated = new ArrayList<>();
        updated.add(contactRepository.save(contact));
        return updated;
    }

    @Transactional
    public void delete(Contact contact) {
        contactRepository.deleteById(contact.getId());
    }

    @Transactional(readOnly = true)
    public long getTotalContacts() {
        return contactRepository.count();
    }
}
