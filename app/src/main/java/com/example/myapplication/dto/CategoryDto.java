package com.example.myapplication.dto;

import java.util.List;

public class CategoryDto {
    private Integer cat_id;
    private String mem_account;
    private String cat_name;
    private List<String> res_id;
    private List<String> Member;
    private List<String> resname;

    public CategoryDto(String mem_account, String cat_name, List<String> res_id, List<String> member) {
        this.mem_account = mem_account;
        this.cat_name = cat_name;
        this.res_id = res_id;
        Member = member;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getMem_account() {
        return mem_account;
    }

    public void setMem_account(String mem_account) {
        this.mem_account = mem_account;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<String> getRes_id() {
        return res_id;
    }

    public void setRes_id(List<String> res_id) {
        this.res_id = res_id;
    }

    public List<String> getMember() {
        return Member;
    }

    public void setMember(List<String> Member) {
        this.Member = Member;
    }

    public List<String> getResname() {
        return resname;
    }

    public void setResname(List<String> resname) {
        this.resname = resname;
    }
}