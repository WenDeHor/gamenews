package com.silkpath.gamenews.repository.datajpa;

import com.silkpath.gamenews.model.User;
import org.springframework.data.domain.Sort;
import com.silkpath.gamenews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DateJpaUserRepository implements UserRepository {
  private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");
   @Autowired
    private BaseUserRepository baseUserRepository;

    @Override
    public User save(User user) {
        return baseUserRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return baseUserRepository.delete(id)!=0;
    }

    @Override
    public User get(int id) {
        return baseUserRepository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return baseUserRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return baseUserRepository.findAll(SORT_NAME_EMAIL);
    }
}
