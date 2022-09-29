package com.mdonline.ChatService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class MessageList {
    private List<Message> messages;

    public MessageList(){
        messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    public Boolean isEmpty(){
        return messages.isEmpty();
    }
}
