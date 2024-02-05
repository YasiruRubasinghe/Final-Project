package com.esoft.finalproject.service;

import com.esoft.finalproject.dto.DonationCategoryDTO;
import com.esoft.finalproject.dto.DonationDetailsDTO;
import com.esoft.finalproject.dto.ResponseDTO;

import java.util.List;

public interface DonationDetailsService {
    ResponseDTO saveDonationDetails(DonationDetailsDTO dto);
    ResponseDTO updateDonationDetails(DonationDetailsDTO dto);
    ResponseDTO deleteByDonationId(int id);
    List<DonationDetailsDTO> getAllDonationDetails();
    List<DonationDetailsDTO> getFilterAllDonationDetails(String name);
}
