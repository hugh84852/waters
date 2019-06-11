package com.example.myapplication;

public class fields {
    //--------------------------------------Restaurant-------------------------------------------
    private int[] res_id;
    private String res_name;
    private String res_address;
    private String res_phone;
    private String res_opening_time;
    private String res_info;

    public String getRes_name() {
        return res_name;
    }

    public String getRes_address() {
        return res_address;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public String getRes_opening_time() {
        return res_opening_time;
    }

    public String getRes_info() {
        return res_info;
    }

    //--------------------------------------Member-----------------------------------------------
    private String mem_account;
    private String mem_name;
    private String mem_sex;
    private String mem_birthday;
    private String mem_email;
    private String mem_phone;

    public String getMem_name() {
        return mem_name;
    }

    public String getMem_sex() {
        return mem_sex;
    }

    public String getMem_birthday() {
        return mem_birthday;
    }

    public String getMem_email() {
        return mem_email;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    //--------------------------------------Story------------------------------------------------
    private int[] sto_id;
    private String sto_content;

    public String getSto_content() {
        return sto_content;
    }

    //--------------------------------------Card-------------------------------------------------
    private int[] c_id;

    //--------------------------------------Service----------------------------------------------
    private int[] ser_id;
    private String ser_name;

    public String getSer_name() {
        return ser_name;
    }

    //--------------------------------------Comment----------------------------------------------
    private int[] com_id;
    private String com_content;

    public String getCom_content() {
        return com_content;
    }

    //--------------------------------------Category---------------------------------------------
    private int[] cat_id;
    private String cat_name;

    public String getCat_name() {
        return cat_name;
    }
}

