package com.example.myapplication;

public class Card {
    private Card[] records;
    private String id;
    private fields fields;

    public Card(String id){
        this.id = id;
    }

    public Card[] getRecords() {
        return records;
    }
    public String getId(int i){
        return records[i].id;
    }
    public fields getfields(int i){
        return records[i].fields;
    }
}
