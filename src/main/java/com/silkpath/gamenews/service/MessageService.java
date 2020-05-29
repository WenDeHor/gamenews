package com.silkpath.gamenews.service;

import com.silkpath.gamenews.model.Message;
import com.silkpath.gamenews.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.silkpath.gamenews.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MessageService {
    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public List<Message> getAll(int userId) {
        return repository.getAll(userId);
    }

    public void update(Message message, int userId) {
        Assert.notNull(message, "message must not be null");
        checkNotFoundWithId(repository.save(message, userId), message.getId());
    }

    public Message create(Message message, int userId) {
        Assert.notNull(message, "message must not be null");
        return repository.save(message, userId);
    }
}
