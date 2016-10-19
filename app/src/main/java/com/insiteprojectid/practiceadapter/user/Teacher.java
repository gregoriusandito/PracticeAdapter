package com.insiteprojectid.practiceadapter.user;

/**
 * Created by Gregorius Andito on 10/7/2016.
 */
public class Teacher {
    private int id;
    private String name;
    private String nip;
    private String mail;
    private String phone;

    public Teacher (int id, String name, String mail, String phone, String nip){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.nip = nip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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
