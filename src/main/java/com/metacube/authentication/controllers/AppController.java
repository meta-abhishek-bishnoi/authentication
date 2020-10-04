package com.metacube.authentication.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
  @GetMapping("/home")
  public String welcomePage() {
    UserDetails details = ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    return "<h3> You are Successfully logged in as : "+details.getAuthorities()+"</h3>"+
          "<p>"+ "<h3> This is rest application to perfom operations "+
        "please shrare current session with postman using interceptor<h3>"+
        "</p>"+
        "<h2>Update DTO Link: <a href='https://jsoneditoronline.org/#right=cloud.cd0ecfe83be243b1bc976496436d9a66&left=cloud.fc86560c2b9348a8b2b74bec2203e244' target=\"_blank\">click here</a></h2>"+
        "<h2>APIs:</h2>"+
        "<p>"+
        "<h3>User:</h3>"+
        "<b>GET:</b> /user/{id}<br>"+
        "<b>PUT:</b> /user"+
        "</p>"+
        "<p>"+
        "<h3>Admin:</h3>"+
        "<b>GET:</b> /user/{id}<br>"+
        "<b>PUT:</b> /user<br>"+
        "<b>GET:</b> /admin/{id}<br>"+
        "<b>PUT:</b> /admin"+
        "</p>";
  }
}
