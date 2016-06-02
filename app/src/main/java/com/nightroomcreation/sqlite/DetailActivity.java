package com.nightroomcreation.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Database database;

    ListView listView;

    DetailAdapter detailAdapter;

    ArrayList<String> personArrayList = new ArrayList<>();
    ArrayList<Person> personArrayList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listView = (ListView) findViewById(R.id.list_view);

        database = new Database(this);

        personArrayList1 = database.getAll();

        detailAdapter = new DetailAdapter(this, R.layout.list_view_item, personArrayList1);

        //gonna check value for db
        if (personArrayList1.size() > 0) {
//            for (int i = 0; i < personArrayList1.size(); i++) {
//                Person person = personArrayList1.get(i);
//                personArrayList.add(person.getName());
//            }
            listView.setAdapter(detailAdapter);
        }
    }
}
