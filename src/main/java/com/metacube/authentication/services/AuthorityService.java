package com.metacube.authentication.services;

import com.metacube.authentication.entities.Authority;
import com.metacube.authentication.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
  * AuthorityService
  *
  * @author Abhishek Bishnoi
  * 04-Oct-2020, 2:10 PM
*/
@Service
public class AuthorityService {
  @Autowired
  AuthorityRepository repository;
  public Authority create(Authority authority){
    return repository.save(authority);
  }
  public Authority update(Authority authority){
    return repository.save(authority);
  }
  public Authority findByUsername(String username){
    return repository.findByUsername(username);
  }
}
