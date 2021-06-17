package com.example.cricketteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ListView indialist,salist,wilist,auslist;
    Button done;

    String[][] Players = { {"M.S. Dhoni", "Virat Kohli", "Rohit Sharma", "K.L. Rahul", "Hardik Pandya", "Rishabh Pant", "Jasprit Bumrah", "Yuzvendra Chahal", "Ravindra Jadeja", "Kuldeep Yadav", "Dinesh Karthik"},
            {"Nicky Boje", "Mark Boucher","Herschelle Gibbs", "Jacques Kallis", "Justin Kemp", "Charl Langeveldt", "Albie Morkel", "André Nel", "Makhaya Ntini", "Shaun Pollock", "Ashwell Prince"},
            {"Ian Bradshaw", "Dwayne Bravo", "Deighton Butler", "Shivnarine Chanderpaul", "Daren Ganga", "Chris Gayle", "Wavell Hinds", "Runako Morton", "Denesh Ramdin", "Dwayne Smith", "Jerome Taylor"},
            {"Michael Clarke", "Adam Gilchrist", "James Hopes", "Michael Hussey", "Michael Kasprowicz", "Simon Katich", "Brett Lee", "Damien Martyn", "Glenn McGrath", "Ricky Ponting", "Andrew Symonds"} };

    ArrayList<String> mainlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indialist = (ListView) findViewById(R.id.listView1);
        salist = (ListView) findViewById(R.id.listView2);
        wilist = (ListView) findViewById(R.id.listView3);
        auslist = (ListView) findViewById(R.id.listView4);
        done = (Button) findViewById(R.id.done);

        indialist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Players[0]));
        salist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Players[1]));
        wilist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Players[2]));
        auslist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Players[3]));

        indialist.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        salist.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        wilist.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        auslist.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        indialist.setOnItemClickListener(this);
        salist.setOnItemClickListener(this);
        wilist.setOnItemClickListener(this);
        auslist.setOnItemClickListener(this);
        done.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

        String item = (String) parent.getItemAtPosition(i);

        if(mainlist.size() == 11){
            Toast.makeText(this,"More than 11 members are selected",Toast.LENGTH_SHORT).show();
        }
        else{
            if(mainlist.contains(item))
                mainlist.remove(item);
            else
                mainlist.add(item);
        }
    }

    @Override
    public void onClick(View view) {

        if(mainlist.size() == 11){
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putStringArrayListExtra("team",mainlist);
            startActivity(i);
        }
        else
            Toast.makeText(this,"11 players not selected",Toast.LENGTH_SHORT).show();
    }
}
