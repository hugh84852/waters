package com.example.myapplication;

import java.util.List;

public class fields {
    //--------------------------------------Restaurant-------------------------------------------
    private String res_name;
    private String res_address;
    private String res_phone;
    private String res_opening_time;
    private String res_info;
//
//    public fields(String res_name, String res_address, String res_phone, String res_opening_time, String res_info, List<String> cat_name, List<String> ser_name) {
//        this.res_name = res_name;
//        this.res_address = res_address;
//        this.res_phone = res_phone;
//        this.res_opening_time = res_opening_time;
//        this.res_info = res_info;
//        this.cat_name = cat_name;
//        this.ser_name = ser_name;
//    }

    public String getRes_name() {
        return res_name;
    }

    public String getRes_address() {
        return res_address;
    }
//
    public String getRes_phone() {
        return res_phone;
    }
//
    public String getRes_opening_time() {
        return res_opening_time;
    }
//
    public String getRes_info() {
        return res_info;
    }
//
//    //--------------------------------------Member-----------------------------------------------
    private String mem_account;
    private String mem_password;
    private String mem_name;
    private String mem_gender;
    private String mem_birthday;
    private String mem_phone;
    private List<String> cat_id;

    public List<String> getCat_id() {
        return cat_id;
    }
//    private String mem_fav_cat_name;

    public fields(String mem_account, String mem_password, String mem_name, String mem_gender, String mem_birthday, String mem_phone, List<String> cat_id)
    {
        this.mem_account = mem_account;
        this.mem_password = mem_password;
        this.mem_name = mem_name;
        this.mem_gender = mem_gender;
        this.mem_birthday = mem_birthday;
        this.mem_phone = mem_phone;
        this.cat_id = cat_id;
    }

    public String getMem_account() {
        return mem_account;
    }

    public String getMem_password() {
        return mem_password;
    }

    public String getMem_name() {
        return mem_name;
    }

//    public String getMem_gender() {
//        return mem_gender;
//    }
//
//    public String getMem_birthday() {
//        return mem_birthday;
//    }
//

//
//    public String getMem_phone() {
//        return mem_phone;
//    }
//
//    //--------------------------------------Story------------------------------------------------
//    private int[] sto_id;
//    private String sto_content;
//
//    public String getSto_content() {
//        return sto_content;
//    }
//
//    //--------------------------------------Card-------------------------------------------------
//
//    //--------------------------------------Service----------------------------------------------
    private List<String> ser_name;
//
    public List<String> getSer_name() {
        return ser_name;
    }
//
//    //--------------------------------------Comment----------------------------------------------
//    private int[] com_id;
//    private String com_content;
//
//    public String getCom_content() {
//        return com_content;
//    }
//
//    //--------------------------------------Category---------------------------------------------
//    private int[] cat_id;
    private List<String> cat_name;

    public List<String> getCat_name() {
        return cat_name;
    }

    //--------------------------------------Card_Count---------------------------------------------
    private int count;

    public fields(int c){
        count = c;
    }

}

