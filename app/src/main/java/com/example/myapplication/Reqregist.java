package com.example.myapplication;

public class Reqregist {

    public String id ;
    private Member member;
    private fields fields;

    public String getId(){return id;}

    public Reqregist(fields fields)
    {
        this.fields = fields;
    }

    public fields getFields() {
        return fields;
    }
}
