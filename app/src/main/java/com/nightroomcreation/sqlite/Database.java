package com.nightroomcreation.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Administrator on 01-Jun-16.
 */
public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myDB.db";
    public static final String TABLE_NAME = "person";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " " +
                "(id integer primary key, " +
                "name text," +
                "address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist " + TABLE_NAME);
        //called again to re-create
        onCreate(db);
    }

    public void addPerson(Person person) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", person.getName());
        contentValues.put("address", person.getAddress());

        //execute to insert
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void updatePerson(Person person) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", person.getName());
        contentValues.put("address", person.getAddress());

        //execte to update
        sqLiteDatabase.update(
                TABLE_NAME,
                contentValues,
                "id = ? ",
                new String[]{Integer.toString(person.getId())}
        );
    }

    public void deletePerson(Integer id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(
                TABLE_NAME,
                "id = ?",
                new String[]{Integer.toString(id)}
        );
    }

    public ArrayList<Person> getAll() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Person person = new Person();
            person.setId(cursor.getInt(0));//this gonna get value of ID table column
            person.setName(cursor.getString(1));//this gonna get value of NAME table column
            person.setAddress(cursor.getString(2));//ADDRESS table column

            //add into arrayList
            personArrayList.add(person);
            cursor.moveToNext();
        }
        return personArrayList;
    }

    public ArrayList<String> getAllName() {
        ArrayList<String> personArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Person person = new Person();
            person.setId(cursor.getInt(0));//this gonna get value of ID table column
            person.setName(cursor.getString(1));//this gonna get value of NAME table column
            person.setAddress(cursor.getString(2));//ADDRESS table column

            //add into arrayList
            personArrayList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        return personArrayList;
    }

    public ArrayList<Person> getAllName1() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Person person = new Person();
            person.setId(cursor.getInt(0));//this gonna get value of ID table column
            person.setName(cursor.getString(1));//this gonna get value of NAME table column
            person.setAddress(cursor.getString(2));//ADDRESS table column

            //add into arrayList
            personArrayList.add(person);
            cursor.moveToNext();
        }
        return personArrayList;
    }

    public Person getPersonById(int id) {
        Person person = new Person();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + TABLE_NAME + " where id = " + COLUMN_ID, null
        );

        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            return null;
        }

        person.setId(cursor.getInt(0));
        person.setName(cursor.getString(1));
        person.setAddress(cursor.getString(2));

        return person;
    }
}
