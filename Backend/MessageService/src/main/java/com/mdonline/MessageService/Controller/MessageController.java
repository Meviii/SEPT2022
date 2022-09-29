package com.mdonline.MessageService.Controller;

import com.mdonline.MessageService.Model.Message;
import com.mdonline.MessageService.Model.MessageList;
import com.mdonline.MessageService.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // api/v1/messages/chat/:chatId
    @GetMapping(path = "/chat/{chatId}", produces = "application/json")
    public MessageList getMessagesByChatId(@PathVariable long chatId){
        return messageService.getMessagesByChatId(chatId);
    }

    @PostMapping(path = "/chat/{chatId}", consumes = "application/json")
    public Message addMessageToChat(@RequestBody Message message, @PathVariable long chatId){

        messageService.addMessageToChat(message, chatId);

        return message;
    }
}
