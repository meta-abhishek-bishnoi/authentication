package com.metacube.authentication.repositories;

import com.metacube.authentication.dtos.DetailsDTO;
import com.metacube.authentication.entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Detail, Long>{
  Detail findByUserId(Long userId);
}
