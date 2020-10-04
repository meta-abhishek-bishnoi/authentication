package com.metacube.authentication.controllers;

import com.metacube.authentication.dtos.DetailsDTO;
import com.metacube.authentication.services.DetailsService;
import com.metacube.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  DetailsService detailsService;
  @GetMapping("/{id}")
  public ResponseEntity<Object> findUser(@PathVariable("id") Long id){
    try{
      return new ResponseEntity<>(detailsService.getDetailsByUserId(id), new HttpHeaders(), HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @PutMapping
  public ResponseEntity<Object> updateUser(@RequestBody DetailsDTO detailsDTO){
    try{
      return new ResponseEntity<>(detailsService.update(detailsDTO), new HttpHeaders(), HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
