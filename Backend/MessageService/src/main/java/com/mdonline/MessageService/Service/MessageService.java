package com.mdonline.MessageService.Service;

import com.mdonline.MessageService.Model.Message;
import com.mdonline.MessageService.Model.MessageList;
import com.mdonline.MessageService.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public MessageList getMessagesByChatId(long id) {
        List<Message> messages = messageRepository.findMessagesByChatId(id);
        MessageList messageList = new MessageList();
        messageList.setMessages(messages);
        return messageList;
    }

    public Boolean addMessageToChat(Message message, long chatId) {
        Boolean didAdd = true;
        try {
            message.setChatId(chatId);
            messageRepository.save(message);
        }catch (Exception e){
            didAdd = false;
        }
        return didAdd;
    }
}
