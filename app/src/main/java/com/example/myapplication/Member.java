package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private Member[] records;
    private String id;
    private fields fields;

    private String mem_account;
    private String mem_password;
    private String mem_name;
    private String mem_gender;
    private String mem_birthday;
    private String mem_phone;

    public List<String> getMem_fav_cat_name() {
        return mem_fav_cat_name;
    }

    private List<String> mem_fav_cat_name;

//    public List<String> getMem_fav_cat_name() {
//        return mem_fav_cat_name;
//    }

//    private List<String> mem_fav_cat_name;


    public List<String> getCat_id() {
        return cat_id;
    }

    private List<String> cat_id;

    public Member(List<String> cat_id) {

        this.cat_id = cat_id;
    }


    public String getMem_gender() {
        return mem_gender;
    }

    public String getMem_birthday() {
        return mem_birthday;
    }


    public String getMem_phone() {
        return mem_phone;
    }



    public String getMem_account() {
        return mem_account;
    }

    public String getMem_password() {
        return mem_password;
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

    public String getMem_name() {return mem_name;}
}
