package com.esoft.finalproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DonatorDTO {
    private int donatorId;
    private String donatorName;
    private String donatorAge;
    private String donatorContact;
    private String donatorAddress;
}
