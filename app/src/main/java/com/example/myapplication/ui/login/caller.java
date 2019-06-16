package com.example.myapplication.ui.login;

public class caller {
private caller [] records;
private String id;
    private member_3 fields;

    public caller(String id){this.id=id;}

    public caller[] getRecords() {
        return records;
    }
    public String getId (int i){return  records[i].id;}
    public member_3 getFeilds(int i){return records[i].fields;}
}
