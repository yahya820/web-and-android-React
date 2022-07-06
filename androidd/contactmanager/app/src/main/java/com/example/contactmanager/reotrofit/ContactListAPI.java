package com.example.contactmanager.reotrofit;


import com.example.contactmanager.model.ContactList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ContactListAPI {

    @GET("/ContactList/get-all")
    Call<List<ContactList>> getAllContact();

    @POST("/api/v1/ContactList")
    Call<ContactList> save(@Body ContactList contactList);
}
