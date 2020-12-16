package com.chodhary.adnan.Model;

import java.io.Serializable;

public class Donor implements Serializable {
    String name,phone,address,group;

    public Donor() {
    }

    public Donor(String name, String phone, String address, String group) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
