package com.esoft.finalproject.service;

import com.esoft.finalproject.dto.DonationItemDTO;
import com.esoft.finalproject.dto.ResponseDTO;

import java.util.List;

public interface DonationItemService {
    ResponseDTO saveDonationItem(DonationItemDTO dto);
    ResponseDTO updateDonationItem(DonationItemDTO dto);
    ResponseDTO deleteByDonationItemId(int Id);
    List<DonationItemDTO> getAllDonationItem();
}
