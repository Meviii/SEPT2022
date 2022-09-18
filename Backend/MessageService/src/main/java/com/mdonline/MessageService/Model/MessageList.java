package com.mdonline.MessageService.Model;

import java.util.ArrayList;
import java.util.List;

public class MessageList {
    private List<Message> messages;

    public MessageList(){
        messages = new ArrayList<>();
    }

    public MessageList(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Boolean isEmpty(){
        return messages.isEmpty();
    }
}
