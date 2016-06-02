package com.nightroomcreation.sqlite;

/**
 * Created by Administrator on 01-Jun-16.
 */
public class Person {
    Integer id;
    String name;
    String address;

    public Person(){

    }
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
