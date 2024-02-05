package com.esoft.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DonationCampaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campaignId;
    private String campaignTitle;
    private String description;
    private String contact;
    private String imageUrl;
    private String imageFile;
}
