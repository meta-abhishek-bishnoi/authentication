package com.metacube.authentication.dtos;

public class DetailsDTO {
  private Long id;
  private Long userId;
  private String firstName;
  private String lastName;
  private String email;
  private String mobileNo;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getUserId() {
    return userId;
  }
  
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getMobileNo() {
    return mobileNo;
  }
  
  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }
}
