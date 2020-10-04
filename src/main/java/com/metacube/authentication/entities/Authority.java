package com.metacube.authentication.entities;

import com.metacube.authentication.enums.AppRole;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private java.lang.String username;
  private String authority;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public java.lang.String getUsername() {
    return username;
  }
  
  public void setUsername(java.lang.String username) {
    this.username = username;
  }
  
  public String getAuthority() {
    return authority;
  }
  
  public void setAuthority(String authority) {
    this.authority = authority;
  }
  
  @Override
  public java.lang.String toString() {
    return "Authority{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", authority=" + authority +
        '}';
  }
}
