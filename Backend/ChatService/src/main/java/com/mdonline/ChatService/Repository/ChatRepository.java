package com.mdonline.ChatService.Repository;

import com.mdonline.ChatService.Model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findById(long id);

    @Query(value = "SELECT * FROM Chats WHERE doctor_id = ?1 OR patient_id = ?1", nativeQuery = true)
    List<Chat> findAllByUserId(long id);

    @Query(value = "SELECT * FROM Chats WHERE doctor_id = ?2 AND patient_id = ?1", nativeQuery = true)
    List<Chat> findChatsByDoctorIdAndPatientId(long patient_id, long doctor_id);
}
