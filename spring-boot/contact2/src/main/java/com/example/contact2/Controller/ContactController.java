package com.example.contact2.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.contact2.Exception.ResourceNotFoundException;
import com.example.contact2.Model.ContactList;
import com.example.contact2.Repository.ContactRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class ContactController {
    
    @Autowired
    private ContactRepository contactRepository;

    //get all 
    @GetMapping("/ContactList")
    public List<com.example.contact2.Model.ContactList> getAllContact(){
        return contactRepository.findAll();
    }

    // create Contact rest api
    @PostMapping("/ContactList")
    public ContactList createContact (@RequestBody ContactList ContactList){
        return contactRepository.save(ContactList);
    }


     //get staff by id
     @GetMapping("/ConatctList/{id}")
     public ResponseEntity<ContactList> getContact(@PathVariable long id)
     {
         ContactList contactList = contactRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
         return ResponseEntity.ok(contactList);
     }

      //update staff
    @PutMapping("/ContactList/{id}")
    public ResponseEntity<ContactList> updateContact(@PathVariable long id, @RequestBody ContactList updateDetails)
    {
        ContactList contactList = contactRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("IT IS VALID NAME"));
        contactList.setname(updateDetails.getname());
        contactList.setname(updateDetails.getname());
        contactList.setEmail(updateDetails.getEmail());

        contactRepository.save(contactList);
        return ResponseEntity.ok(updateDetails);
    }

   
    //delete staff
    @DeleteMapping("/ContactList/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStaff(@PathVariable long id)
    {
        ContactList contactList = contactRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Contact not Exits"));
        contactRepository.delete(contactList);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }  

}
