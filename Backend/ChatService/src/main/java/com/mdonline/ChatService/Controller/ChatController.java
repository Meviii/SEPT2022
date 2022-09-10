package com.mdonline.ChatService.Controller;

import com.mdonline.ChatService.Model.Chat;
import com.mdonline.ChatService.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/chats")
public class ChatController {

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping(produces = "application/json")
    public List<Chat> getAllChats(){

        return chatService.getAllChats();
    }

    @PostMapping(path = "/users/")
    public ResponseEntity<?> createChat(@RequestBody Chat chat){

        return chatService.createChat(chat);
    }

}
