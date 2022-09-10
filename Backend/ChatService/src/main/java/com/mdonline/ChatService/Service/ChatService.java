package com.mdonline.ChatService.Service;

import com.mdonline.ChatService.Model.Chat;
import com.mdonline.ChatService.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public ResponseEntity<?> createChat(Chat chat) {
        chatRepository.save(chat);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
}
