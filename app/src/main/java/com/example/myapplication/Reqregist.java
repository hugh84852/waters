package com.example.myapplication;

public class Reqregist {
    public Reqregist[] records;
    public String id ;
    private Member member;
    private fields fields;
    private cardcount_fields cardcount_fields;

    public String getId(){return id;}

    public Reqregist(fields fields)
    {
        this.fields = fields;
    }

    public Reqregist(cardcount_fields cardcount_fields)
    {
        this.cardcount_fields = cardcount_fields;
    }

    public fields getFields() {
        return fields;
    }

    public fields getFields(int i){
        return records[i].fields;
    }
}
