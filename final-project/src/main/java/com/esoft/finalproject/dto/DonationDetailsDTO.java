package com.esoft.finalproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DonationDetailsDTO {
    private int donationId;
    private int donatorId;
    private String donatorAddress;
    private int donateItemId;
}

