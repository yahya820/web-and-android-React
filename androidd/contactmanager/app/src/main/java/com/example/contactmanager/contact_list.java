package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class contact_list extends AppCompatActivity {
    Button add_contact;
    TextView receive,no,ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        add_contact = findViewById(R.id.add_contact);
        receive = (TextView)findViewById(R.id.jina);
        no = (TextView) findViewById(R.id.no);
        ad = (TextView) findViewById(R.id.ad);


//        Intent intent = getIntent();
//        String text = intent.getStringExtra(add_Contact.EXTRA_TEXT);
//        String text2 = intent.getStringExtra(add_Contact.EXTRA_NO);
//        String txt = intent.getStringExtra(add_Contact.EXTRA_AD);
//
//        receive.setText(text);
//        no.setText(text2);
//        ad.setText(txt);
//
//
//        add_contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(contact_list.this,add_Contact.class));
//            }
//        });
  }

}