package com.example.myapplication;

public class Member {
    private Member[] records;
    private String id;
    private fields fields;

    public Member(String id){
        this.id = id;
    }

    public Member[] getRecords() {
        return records;
    }
    public String getId(int i){
        return records[i].id;
    }
    public fields getfields(int i){
        return records[i].fields;
    }
}
