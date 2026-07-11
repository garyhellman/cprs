package org.acs.cprs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acs.cprs.model.Contact;
import org.acs.cprs.model.ContactWrapper;
import org.acs.cprs.service.ContactService;
import org.acs.cprs.util.ExtJSReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact/view.action")
    public Map<String, ?> view(@RequestParam int start, @RequestParam int limit) {
        try {
            List<Contact> contacts = contactService.getContactList(start, limit);
            long total = contactService.getTotalContacts();
            return ExtJSReturn.mapOK(contacts, total);
        } catch (Exception e) {
            logger.error("Failed to load contacts", e);
            return ExtJSReturn.mapError("Error retrieving Contacts from database.");
        }
    }

    @PostMapping("/contact/create.action")
    public Map<String, ?> create(@RequestBody ContactWrapper data) {
        try {
            List<Contact> contacts = contactService.create(data.getData());
            return ExtJSReturn.mapOK(contacts);
        } catch (Exception e) {
            logger.error("Failed to create contact", e);
            return ExtJSReturn.mapError("Error trying to create contact.");
        }
    }

    @PostMapping("/contact/update.action")
    public Map<String, ?> update(@RequestBody ContactWrapper data) {
        try {
            List<Contact> contacts = contactService.update(data.getData());
            return ExtJSReturn.mapOK(contacts);
        } catch (Exception e) {
            logger.error("Failed to update contact", e);
            return ExtJSReturn.mapError("Error trying to update contact.");
        }
    }

    @PostMapping("/contact/delete.action")
    public Map<String, ?> delete(@RequestBody ContactWrapper data) {
        try {
            contactService.delete(data.getData());
            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("success", true);
            return modelMap;
        } catch (Exception e) {
            logger.error("Failed to delete contact", e);
            return ExtJSReturn.mapError("Error trying to delete contact.");
        }
    }
}
