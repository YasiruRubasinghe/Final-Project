package com.esoft.finalproject.service;

import com.esoft.finalproject.dto.DonationCampaignDTO;
import com.esoft.finalproject.dto.DonationCategoryDTO;
import com.esoft.finalproject.dto.ResponseDTO;

import java.util.List;

public interface DonationCategoryService {
    ResponseDTO saveDonationCategory(DonationCategoryDTO dto);
    ResponseDTO updateDonationCategory(DonationCategoryDTO dto);
    ResponseDTO deleteByDonationCategoryId(int id);
    List<DonationCategoryDTO> getAllDonationCategory();
}
