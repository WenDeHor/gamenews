package com.silkpath.gamenews.service;

import com.silkpath.gamenews.model.User;
import com.silkpath.gamenews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.silkpath.gamenews.util.ValidationUtil.checkNotFoundWithId;
import static com.silkpath.gamenews.util.ValidationUtil.checkNotFound;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "user", allEntries = true)
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }
    @CacheEvict(value = "user", allEntries = true)
    public List<User>getAll(){
        return repository.getAll();
    }
    public void update(User user){
        Assert.notNull(user, "user must not be null");
       checkNotFoundWithId(repository.save(user), user.getId());
    }
}
