package com.silkpath.gamenews.repository;

import com.silkpath.gamenews.model.Message;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

public interface MessageRepository {

    Message save(Message message, int userId);

    boolean delete(int id, int userId);

    Message get(int id, int userId);

    List<Message> getAll(int userId);

}
