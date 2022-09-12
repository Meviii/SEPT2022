package com.mdonline.MessageService.Model;

import javax.persistence.*;

@Entity(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="text", nullable = false)
    private String text;

    @Column(name="user_id", nullable = false)
    private long userId;

    @Column(name = "chat_id", nullable = false)
    private long chatId;

    public Message() {
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                ", chatId=" + chatId +
                '}';
    }
}
