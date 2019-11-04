package edu.cnm.deepdive.dicewareservice.service;

import edu.cnm.deepdive.dicewareservice.model.dao.UserRepository;
import edu.cnm.deepdive.dicewareservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getOrCreateUser(String oauthKey) {
    return repository.getUserByOauthKey(oauthKey)
        .orElseGet(() -> {
          User user = new User();
          user.setOauthKey(oauthKey);
          return repository.save(user);
        });
  }

}
