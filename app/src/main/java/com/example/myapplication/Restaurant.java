package com.example.myapplication;

public class Restaurant {
    private Restaurant[] records;
    private String id;
    private fields fields;

    public Restaurant(String id){
        this.id = id;
    }

    public Restaurant[] getRecords() {
        return records;
    }
    public String getId(int i){
        return records[i].id;
    }
    public fields getfields(int i){
        return records[i].fields;
    }
}
