package com.metacube.authentication.helper;

import com.metacube.authentication.dtos.DetailsDTO;
import com.metacube.authentication.entities.Detail;

public class DetailsHelper {
  public static Detail getDetailsFromDTO(DetailsDTO dto) {
    Detail detail = new Detail();
    detail.setId(dto.getId());
    detail.setUserId(dto.getUserId());
    detail.setFirstName(dto.getFirstName());
    detail.setLastName(dto.getLastName());
    detail.setEmail(dto.getEmail());
    detail.setMobileNo(dto.getMobileNo());
    return detail;
  }
  
  public static DetailsDTO getDTOFromDetails(Detail detail) {
    DetailsDTO detailsDTO = new DetailsDTO();
    detailsDTO.setId(detail.getId());
    detailsDTO.setUserId(detail.getUserId());
    detailsDTO.setFirstName(detail.getFirstName());
    detailsDTO.setLastName(detail.getLastName());
    detailsDTO.setEmail(detail.getEmail());
    detailsDTO.setMobileNo(detail.getMobileNo());
    return detailsDTO;
  }
}
