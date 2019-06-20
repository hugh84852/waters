package com.example.myapplication;

public class Category {
    private Category[] records;
    private String id;
    private fields fields;
    private getcategory getcategory;

    public Category(String id){
        this.id = id;
    }

    public Category[] getRecords() {
        return records;
    }
    public String getId(int i){
        return records[i].id;
    }
    public fields getfields(int i){
        return records[i].fields;
    }

    public getcategory getcategory(int i)
    {
        return records[i].getcategory;
    }
}
