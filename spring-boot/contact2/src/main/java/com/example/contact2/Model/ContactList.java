package com.example.contact2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ContactList")
public class ContactList {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    

    public ContactList() {
        
    }


    public ContactList(long id, String name, String address, String email,int phone) {
        Id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }


   


    public long getId() {
        return Id;
    }


    public void setId(long id) {
        Id = id;
    }


    public String getname() {
        return name;
    }


    public void setname(String name) {
        this.name = name;
    }


    public String getaddress() {
        return address;
    }


    public void setaddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public int getPhone(){
        return phone;
    }

    
}
