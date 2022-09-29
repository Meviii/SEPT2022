package com.mdonline.MessageService.Repository;

import com.mdonline.MessageService.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

//    @Query(value = "SELECT * FROM Messages m WHERE m.chat_id = ?1",
//            nativeQuery = true)
//    MessageList findAllMedicineByChatId(long id);

    List<Message> findMessagesByChatId(long id);
}
