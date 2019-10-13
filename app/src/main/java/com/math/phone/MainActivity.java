package com.math.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CallAdapter adapter;
    DataBaseHelper helper;
    RecyclerView recyclerView;
    List<CallInformation> callInformationList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  init();

showList();

    }

    private void showList() {

        Cursor cursor=helper.showData();

        while (cursor.moveToNext()){

            int id=cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name=cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String work=cursor.getString(cursor.getColumnIndex(helper.COL_WORK));
            String email=cursor.getString(cursor.getColumnIndex(helper.COL_EMAIL));
            String address=cursor.getString(cursor.getColumnIndex(helper.COL_ADDRESS));
            String phone=cursor.getString(cursor.getColumnIndex(helper.COL_PHONE));
            String nick=cursor.getString(cursor.getColumnIndex(helper.COL_NICK));
            String relation=cursor.getString(cursor.getColumnIndex(helper.COL_RELATION));


            callInformationList.add( new CallInformation(id,name,work,email,address,phone,nick,relation,R.drawable.picture));

            adapter.notifyDataSetChanged();




        }
    }

    private void init() {
        recyclerView=findViewById(R.id.contactlist);
        helper=new DataBaseHelper(this);
        callInformationList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CallAdapter(callInformationList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }


    public void newContact(View view) {

        startActivity(new Intent(this,AddContact.class));
    }
}
