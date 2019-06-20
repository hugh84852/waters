package com.example.myapplication;

public class Reqregist {
    public Reqregist[] records;
    public String id ;
    private Member member;
    private fields fields;

    public String getId(){return id;}

    public Reqregist(fields fields)
    {
        this.fields = fields;
    }
    public int records_length(){
        return records.length;
    }

    public fields getFields() {
        return fields;
    }

    public fields getFields(int i){
        return records[i].fields;
    }
}
