package com.mdonline.ChatService.Controller;

import com.mdonline.ChatService.Exceptions.CustomException;
import com.mdonline.ChatService.Model.Chat;
import com.mdonline.ChatService.Model.ChatList;
import com.mdonline.ChatService.Model.Message;
import com.mdonline.ChatService.Model.MessageList;
import com.mdonline.ChatService.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/chats")
public class ChatController {

    private ChatService chatService;
    private RestTemplate restTemplate;

    @Autowired
    public ChatController(ChatService chatService, RestTemplate restTemplate) {
        this.chatService = chatService;
        this.restTemplate = restTemplate;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteChatById(@PathVariable long id){
        Boolean isDeleted = chatService.deleteById(id);

        if (!isDeleted){
            throw new CustomException("Couldn't delete.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Chat deleted.", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllChats(){
        Boolean isDeleted = chatService.deleteAll();

        if (!isDeleted){
            throw new CustomException("Couldn't delete all.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("All chats deleted.", HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ChatList getAllChats(){
        ChatList chats = chatService.getAllChats();
        if (chats.isEmpty()){
            throw new CustomException("No chats currently.", HttpStatus.OK);
        }
        return chats;
    }

    @PostMapping()
    public ResponseEntity<?> createChat(@Valid @RequestBody Chat chat){
        Boolean isCreated = chatService.createChat(chat);

        if (!isCreated){
            throw new CustomException("Couldn't create", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Created new chat.", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}",produces = "application/json")
    public Chat getChatById(@PathVariable long id){
        Chat c = chatService.getChatById(id);

        if (c == null){
            throw new CustomException("Chat doesn't exist.", HttpStatus.NOT_FOUND);
        }

        return c;
    }

    @GetMapping(path = "/{id}/messages", produces = "application/json")
    public MessageList getMessagesOfChatById(@PathVariable long id){

        MessageList messages = restTemplate.getForObject("http://message-service/api/v1/messages/chat/" + id,
                MessageList.class);

        if (messages.isEmpty()){
            throw new CustomException("No messages for this chat", HttpStatus.NOT_FOUND);
        }

        return messages;
    }

    @PostMapping(path = "/{id}/messages", consumes = "application/json")
    public ResponseEntity<?> addMessageToChat(@RequestBody @Valid Message message, @PathVariable long id){

        Message response = restTemplate.postForObject("http://message-service/api/v1/messages/chat/" + id,
                message, Message.class);

        if (response == null){
            throw new CustomException("Message does not exist", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Added message to chat", HttpStatus.CREATED);
    }

    @GetMapping(path = "/user/{user_id}", produces = "application/json")
    public ChatList getChatsByUserId(@PathVariable long user_id){
        ChatList chatsOfUser = chatService.getChatByUserId(user_id);

        if (chatsOfUser.isEmpty()){
            throw new CustomException("User has no chats.", HttpStatus.NOT_FOUND);
        }

        return chatsOfUser;
    }

    // GET: api/v1/chats - list all chats
    // POST: api/v1/chats - add new chat
    // GET: api/v1/chats/:chatId/ - list all messages for a chat
    // POST: api/v1/chats/:chatId/ - add new message to a chat
    // GET: api/v1/chats/user/:userID - get all chats of a user id

    // GET: api/v1/chats/:chatId/messages

}
