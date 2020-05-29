package com.silkpath.gamenews.repository.datajpa;

import com.silkpath.gamenews.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface BaseMessageRepository extends JpaRepository<Message, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Message m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional
    Message save(Message item);

    @Query("SELECT m FROM Message m WHERE m.user.id=:userId ORDER BY m.id DESC")
    List<Message> getAll(@Param("userId") int userId);
 }
