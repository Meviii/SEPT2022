package com.mdonline.ChatService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ChatList {
    private List<Chat> chats;

    public ChatList(){
        chats = new ArrayList<>();
    }

    public ChatList(List<Chat> chats) {
        this.chats = chats;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    @JsonIgnore
    public Boolean isEmpty(){
        return chats.isEmpty();
    }
}
