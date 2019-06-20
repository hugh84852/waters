package com.example.myapplication;

public class Card_count {
    private Card_count[] records;
    private String id;
    private fields fields;

    private int count;

    public int getCount(){
        return count;
    }

    public fields getfields(int i){
        return records[i].fields;
    }
}
