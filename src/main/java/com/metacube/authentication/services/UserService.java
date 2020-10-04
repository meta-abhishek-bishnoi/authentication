package com.metacube.authentication.services;

import com.metacube.authentication.entities.User;
import com.metacube.authentication.enums.AppRole;
import com.metacube.authentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
  * UserService
  *
  * @author Abhishek Bishnoi
  * 04-Oct-2020, 2:10 PM
*/
@Service
public class UserService {
  @Autowired
  UserRepository repository;
  public User create(User user){
    return repository.save(user);
  }
  public User update(User user){
    return repository.save(user);
  }
  public User findById(Long id){
    return repository.findById(id).get();
  }
  public User findByUsername(String username){
    return repository.findByUsername(username);
  }
}
