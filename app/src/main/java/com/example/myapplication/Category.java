package com.example.myapplication;

import java.util.List;

public class Category {
    private Category[] records;
    private String id;
    private fields fields;

    //    private int[] cat_id;
    private List<String> cat_name;



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
}
