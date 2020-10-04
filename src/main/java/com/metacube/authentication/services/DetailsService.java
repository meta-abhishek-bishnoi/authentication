package com.metacube.authentication.services;

import com.metacube.authentication.dtos.DetailsDTO;
import com.metacube.authentication.entities.Authority;
import com.metacube.authentication.entities.Detail;
import com.metacube.authentication.entities.User;
import com.metacube.authentication.enums.AppRole;
import com.metacube.authentication.helper.DetailsHelper;
import com.metacube.authentication.repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
/**
  * DetailsService
  *
  * @author Abhishek Bishnoi
  * 04-Oct-2020, 2:10 PM
*/
@Service
public class DetailsService {
  @Autowired
  DetailsRepository repository;
  @Autowired
  AuthorityService authorityService;
  @Autowired
  UserService userService;
  /**
    * 
    * @return 
    * @author Abhishek Bishnoi
    * 04-Oct-2020, 1:58 PM
  */
  public DetailsDTO create(DetailsDTO dto){
    Detail detail = DetailsHelper.getDetailsFromDTO(dto);
    detail = repository.save(detail);
    return DetailsHelper.getDTOFromDetails(detail);
  }
  /**
    * 
    * @return 
    * @author Abhishek Bishnoi
    * 04-Oct-2020, 1:59 PM
  */
  public DetailsDTO update(DetailsDTO dto) throws Exception {
    User user = userService.findById(dto.getUserId());
    Authority authority = authorityService.findByUsername(user.getUsername());
    validateUser(authority);
    Detail detail = DetailsHelper.getDetailsFromDTO(dto);
    detail = repository.save(detail);
    return DetailsHelper.getDTOFromDetails(detail);
  }
  /**
    * 
    * @return 
    * @author Abhishek Bishnoi
    * 04-Oct-2020, 1:59 PM
  */
  public DetailsDTO getDetailsByUserId(Long userId) throws Exception {
    User user = userService.findById(userId);
    Authority authority = authorityService.findByUsername(user.getUsername());
    validateUser(authority);
    return DetailsHelper.getDTOFromDetails(repository.findByUserId(userId));
  }
  /**
    *
    * @return 
    * @author Abhishek Bishnoi
    * 04-Oct-2020, 1:59 PM
  */
  private void validateUser(Authority authority) throws Exception {
    UserDetails details = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    java.lang.String activeUserRole = "";
    java.lang.String activeUsername = details.getUsername();
    // only single authority is there
    for(GrantedAuthority userAuthority: details.getAuthorities()){
      activeUserRole = userAuthority.getAuthority();
      break;
    }
    if(activeUserRole.equals(AppRole.ROLE_ADMIN.toString())){
      if(authority.getAuthority().equals(AppRole.ROLE_ADMIN.toString())
          && (!authority.getUsername().equals(activeUsername))){
        throw new Exception();
      }
    }else if(activeUserRole.equals(AppRole.ROLE_USER.toString())){
      if(authority.getAuthority().equals(AppRole.ROLE_USER.toString())
          && (!authority.getUsername().equals(activeUsername))){
        throw new Exception();
      } else if(authority.getAuthority().equals(AppRole.ROLE_ADMIN.toString())){
        throw new Exception();
      }
    }
  }
}
