package com.insiteprojectid.practiceadapter.user;

/**
 * Created by Gregorius Andito on 10/7/2016.
 */
public class Student {
    private int id;
    private String noreg;
    private String name;
    private String mail;
    private String phone;

    public Student (int id, String noreg, String name, String mail, String phone){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.noreg = noreg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
