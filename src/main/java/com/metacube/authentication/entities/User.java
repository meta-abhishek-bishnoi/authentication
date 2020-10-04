package com.metacube.authentication.entities;

import javax.persistence.*;

/**
  *
  * @return
  * @author Abhishek Bishnoi
  * 03-Oct-2020, 2:45 PM
*/
@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  private Boolean enabled;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Boolean getEnabled() {
    return enabled;
  }
  
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
  
  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", enabled=" + enabled +
        '}';
  }
}
