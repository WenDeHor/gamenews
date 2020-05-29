package com.silkpath.gamenews.repository.datajpa;

import org.springframework.stereotype.Repository;
import com.silkpath.gamenews.model.Message;
import com.silkpath.gamenews.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class DataJpaMessegesRepository implements MessageRepository {
    @Autowired
    private BaseMessageRepository baseMessageRepository;
    @Autowired
    private BaseUserRepository baseUserRepository;

    @Override
    public Message save(Message message, int userId) {
        if (!message.isNew() && get(message.getId(), userId) == null) {
            return null;
        }
        message.setUser(baseUserRepository.getOne(userId));
        return baseMessageRepository.save(message);
    }

    @Override
    public boolean delete(int id, int userId) {
        return baseMessageRepository.delete(id, userId)!=0;
    }

    @Override
    public Message get(int id, int userId) {
        return baseMessageRepository.findById(id)
                .filter(message -> message.getUser().getId()==userId).orElse(null);
    }

    @Override
    public List<Message> getAll(int userId) {
        return baseMessageRepository.getAll(userId);
    }
}
