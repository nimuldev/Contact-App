package com.math.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactInfo extends AppCompatActivity {
    private TextView nameTv, workTv, phoneTv, addressTv, nickTv, emailTv,relationTv;
    ImageView imageIv;
    private String name,work,phone,address,nick,email,relation,image;
    private int imageLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        init();

        getData();

        setData();
    }

    private void setData() {
    emailTv.setText(email);
    nameTv.setText(name);
    addressTv.setText(address);
    phoneTv.setText(phone);
    relationTv.setText(relation);
    workTv.setText(work);
    nickTv.setText(nick);
    imageIv.setImageResource(imageLink);


    }



    private void getData() {

        name=getIntent().getStringExtra("name");
        email=getIntent().getStringExtra("email");
        work=getIntent().getStringExtra("work");
        phone=getIntent().getStringExtra("phone");
        nick=getIntent().getStringExtra("nick");
        relation=getIntent().getStringExtra("relation");
        address=getIntent().getStringExtra("address");
         image=getIntent().getStringExtra("image");
         imageLink=Integer.parseInt(image);



    }

    private void init() {

        nameTv = findViewById(R.id.nameTV);
        workTv = findViewById(R.id.workTV);
        phoneTv  = findViewById(R.id.phoneTV);
        addressTv = findViewById(R.id.addressTV);
        relationTv = findViewById(R.id.relationACTV);
        nickTv= findViewById(R.id.nickTV);
        emailTv = findViewById(R.id.emailTV);
        imageIv=findViewById(R.id.imageIV);

    }

    public void Call(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(  Uri.parse("tel:" +phone));
       startActivity(intent);
    }
}
