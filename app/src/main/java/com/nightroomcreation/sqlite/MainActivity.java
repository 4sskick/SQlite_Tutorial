package com.nightroomcreation.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    Person person;

    Button btnSubmit;
    Button btnDetail;
    EditText editName;
    EditText editAddress;

    ArrayList<Person> personArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize component
        editName = (EditText) findViewById(R.id.edit_name);
        editAddress = (EditText) findViewById(R.id.edit_address);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnDetail = (Button) findViewById(R.id.btn_detail);

        //declare database
        database = new Database(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                person = new Person(
                        editName.getText().toString(),
                        editAddress.getText().toString()
                );

                database.addPerson(person);

                personArrayList = database.getAll();
                if (personArrayList.size() > 0) {
                    btnDetail.setVisibility(View.VISIBLE);
                } else {
                    btnDetail.setVisibility(View.GONE);
                }
            }
        });

        personArrayList = database.getAll();
        if (personArrayList.size() > 0) {
            btnDetail.setVisibility(View.VISIBLE);
        } else {
            btnDetail.setVisibility(View.GONE);
        }

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
//                Person person = personArrayList.get(0);
//                Toast.makeText(MainActivity.this, person.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
