package com.example.contact2.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.contact2.Model.ContactList;

@Repository
public interface ContactRepository extends JpaRepository<ContactList,Long> {
    
}
