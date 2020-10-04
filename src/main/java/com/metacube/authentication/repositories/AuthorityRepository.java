package com.metacube.authentication.repositories;

import com.metacube.authentication.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
  Authority findByUsername(String username);
}
