package com.esoft.finalproject.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Data
public class DonationCampaignDTO {
    private int campaignId;
    private String campaignTitle;
    private String description;
    private String contact;
    private MultipartFile imageFile;
}
