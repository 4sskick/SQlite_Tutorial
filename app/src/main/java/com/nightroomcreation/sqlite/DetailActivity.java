package com.nightroomcreation.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Database database;

    TextView txtName;
    TextView txtAddress;
    ListView listView;

    DetailAdapter detailAdapter;

    ArrayList<String> personArrayList;
    ArrayList<Person> personArrayList1 = new ArrayList<>();
    String[] stringPerson = new String[personArrayList1.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        txtName = (TextView) findViewById(R.id.txt_name_detail);
//        txtAddress = (TextView) findViewById(android.R.id.text1);
        listView = (ListView)findViewById(R.id.list_view);

        database = new Database(this);
        personArrayList = database.getAllName();
        personArrayList1 = database.getAllName1();

        detailAdapter = new DetailAdapter(this, android.R.layout.simple_list_item_1, personArrayList);

        //gonna check value for db
        if (personArrayList.size() > 0) {
            listView.setAdapter(detailAdapter);
        }
    }
}
