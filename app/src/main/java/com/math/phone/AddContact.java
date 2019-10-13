package com.math.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    private EditText nameEt, workEt, phoneEt, addressEt, nickEt, emailEt;

    private AutoCompleteTextView relationACTv;
    private String name, phone;
    private String work = null;
    private String relation = null;
    private String nick = null;
    private String email = null;
    private String address = null;
    private String [] typesRelation={"Father","Mother","Brother","Sister","Son","Daughter","Husband","Wife","Cousin","Love","ETC"};

    DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        init();

        setData();

    }

    private void setData() {
    }

    private void getData() {



        name=nameEt.getText().toString().trim();
        work=workEt.getText().toString().trim();
        relation=relationACTv.getText().toString().trim();
        phone=phoneEt.getText().toString().trim();
        address=addressEt.getText().toString().trim();
        nick=nickEt.getText().toString().trim();
        email=emailEt.getText().toString().trim();


        if(! name.equals("") && ! phone.equals("")){
            Long id= helper.insertData(name,work,phone,email,address,nick,relation);

            Toast.makeText(this, "Contact Number"+id, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show();
        }





    }

    private void init() {

        nameEt = findViewById(R.id.nameET);
        workEt = findViewById(R.id.workET);
        phoneEt = findViewById(R.id.phoneET);
        addressEt = findViewById(R.id.addressET);
        relationACTv = findViewById(R.id.relationACTV);
        nickEt = findViewById(R.id.nickET);
        emailEt = findViewById(R.id.emailET);
        helper=new DataBaseHelper(this);
        ArrayAdapter adapter = new ArrayAdapter(AddContact.this,R.layout.support_simple_spinner_dropdown_item,typesRelation);
        relationACTv.setAdapter(adapter);
        relationACTv.setThreshold(1);



    }

    public void back(View view) {

        startActivity(new Intent(this, MainActivity.class));
    }

    public void Save(View view) {
        getData();
    }
}
