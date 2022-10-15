package com.example.modul6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        contacts.add(new Contact("Jusuf Latifah", "+62878555504", R.drawable.jusuf_latifah));
        contacts.add(new Contact("Burhanuddin Taufik", "+628785555041", R.drawable.burhanuddin));
        contacts.add(new Contact("Latifah Bagus", "+628785555042", R.drawable.latifah_bagus));
        contacts.add(new Contact("Agung Nurul", "+628785555043", R.drawable.agung_nurul));
        contacts.add(new Contact("Cahaya Krisna", "+628785555044", R.drawable.cahaya_krisna));

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