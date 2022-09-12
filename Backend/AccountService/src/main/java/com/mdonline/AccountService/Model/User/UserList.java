package com.mdonline.AccountService.Model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;

    public UserList(){
        users = new ArrayList<>();
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getMessages() {
        return users;
    }

    public void setMessages(List<User> messages) {
        this.users = messages;
    }

    @JsonIgnore
    public Boolean isEmpty(){
        return users.isEmpty();
    }
}
