package com.mdonline.AccountService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class AdminList {

    private List<Admin> admins;

    public AdminList(){
        admins = new ArrayList<>();
    }

    public AdminList(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    @JsonIgnore
    public Boolean isEmpty(){
        return admins.isEmpty();
    }
}
