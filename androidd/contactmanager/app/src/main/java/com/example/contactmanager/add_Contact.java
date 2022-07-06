package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactmanager.model.ContactList;
import com.example.contactmanager.reotrofit.ContactListAPI;
import com.example.contactmanager.reotrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class add_Contact extends AppCompatActivity {
    Button save;
    TextView address,name,phone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Initializecomponents();


    }



        private void Initializecomponents(){
             name = findViewById(R.id.name);
             address = findViewById(R.id.address);
             phone = findViewById(R.id.phone);
             email = findViewById(R.id.email);

             save = (Button) findViewById(R.id.save);

            RetrofitService retrofit = new RetrofitService();
            ContactListAPI enrollmentAPI = retrofit.getRetrofit().create(ContactListAPI.class);

            save.setOnClickListener( view ->{
                String names = String.valueOf(name.getText());
                String emails = String.valueOf(email.getText());
                String addresses = String.valueOf(address.getText());
                String phones = String.valueOf(phone.getText());

                ContactList enrollment = new ContactList();

                enrollment.setName(names);
                enrollment.setEmail(emails);
                enrollment.setAddress(addresses);
                enrollment.setPhone(phones);


                enrollmentAPI.save(enrollment)
                        .enqueue(new Callback<ContactList>(){

                            @Override
                            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                                Toast.makeText(add_Contact.this, "Save successful!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<ContactList> call, Throwable t) {
                                Toast.makeText(add_Contact.this, "", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(add_Contact.class.getName()).log(Level.SEVERE,"Error Occured",t);

                            }
                        });
            });

        }
    }

