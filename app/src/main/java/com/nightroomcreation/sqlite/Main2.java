package com.nightroomcreation.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 extends AppCompatActivity {

    private ArrayList<String> stringArrayList = new ArrayList<>();
    private String[] namePeople = new String[]{"Doni", "Dita", "Dona"};

    private ListView listView;
    private DetailAdapter detailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.list_sample);
        detailAdapter = new DetailAdapter(this, android.R.layout.simple_list_item_1, stringArrayList);

//        for (int i = 0; i < namePeople.length; i++) {
//            stringArrayList.add(namePeople[i]);
//        }

        Collections.addAll(stringArrayList, namePeople);

        //set adapter
        listView.setAdapter(detailAdapter);

    }
}
