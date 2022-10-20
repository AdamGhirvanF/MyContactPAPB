package com.example.modul6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager linearLayoutManager;
    ContactAdapter mAdapter;
    ArrayList<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_contact);
        contacts = new ArrayList<>();

        contacts.add(new Contact("Agnes", "081289764563", R.drawable.pp_agnes));
        contacts.add(new Contact("Andrew", "085867889868", R.drawable.pp_andrew));
        contacts.add(new Contact("Ardhito", "082167129087", R.drawable.pp_ardhito));
        contacts.add(new Contact("Budi", "+081355678754", R.drawable.pp_budi));
        contacts.add(new Contact("Ghozali", "082267548976", R.drawable.pp_ghozali));
        contacts.add(new Contact("Keisya", "081156453278", R.drawable.pp_keisya));
        contacts.add(new Contact("Laura", "082378942801", R.drawable.pp_laura));
        contacts.add(new Contact("Nadin", "081898437823", R.drawable.pp_nadin));
        contacts.add(new Contact("Pamungkas", "085296462837", R.drawable.pp_pamungkas));
        contacts.add(new Contact("Siska", "081372638910", R.drawable.pp_siska));

        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new ContactAdapter(this, contacts);

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                contacts.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
        mAdapter.notifyDataSetChanged();
    }
}