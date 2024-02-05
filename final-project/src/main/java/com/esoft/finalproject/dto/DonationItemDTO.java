package com.esoft.finalproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DonationItemDTO {
    private int donationItemId;
    private String description;
    private int CategoryId;
    private int donatorId;
}
