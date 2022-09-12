package com.mdonline.ChatService.Service;

import com.mdonline.ChatService.Model.Chat;
import com.mdonline.ChatService.Model.ChatList;
import com.mdonline.ChatService.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ChatList getAllChats() {
        ChatList chats = new ChatList(chatRepository.findAll());
        return chats;
    }

    public Boolean createChat(Chat chat) {
        Boolean isCreated = true;

        List<Chat> chats = chatRepository.findChatsByDoctorIdAndPatientId(chat.getPatientId(), chat.getDoctorId());
        try {
            if (chats.isEmpty()) {
                chatRepository.save(chat);
            }else throw new Exception();
        }catch (Exception e){
            isCreated = false;
        }
        return isCreated;
    }

    public Chat getChatById(long id) {
        return chatRepository.findById(id);
    }

    public ChatList getChatByUserId(long user_id) {
        return new ChatList(chatRepository.findAllByUserId(user_id));
    }

    public Boolean deleteById(long id) {
        Boolean isDeleted = true;

        try{
            chatRepository.deleteById(id);
        }catch (Exception e){
            isDeleted = false;
        }

        return isDeleted;
    }

    public Boolean deleteAll() {
        Boolean isDeleted = true;

        try{
            chatRepository.deleteAll();
        }catch (Exception e){
            isDeleted = false;
        }

        return isDeleted;
    }
}
