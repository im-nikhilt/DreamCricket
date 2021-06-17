package com.example.cricketteam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayList<String> team = getIntent().getStringArrayListExtra("team");

        second = (ListView) findViewById(R.id.listView1);
        second.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, team));
        second.setChoiceMode(ListView.CHOICE_MODE_NONE);


    }
}