package com.esoft.finalproject.service;

import com.esoft.finalproject.dto.DonationCampaignDTO;
import com.esoft.finalproject.dto.DonationCategoryDTO;
import com.esoft.finalproject.dto.ResponseDTO;

import java.util.List;

public interface DonationCampaignService {
    ResponseDTO saveCampaign(DonationCampaignDTO dto);
    ResponseDTO updateCampaign(DonationCampaignDTO dto);
    ResponseDTO deleteByCampaignId(int id);
    List<DonationCampaignDTO> getAllCampaign();
}
