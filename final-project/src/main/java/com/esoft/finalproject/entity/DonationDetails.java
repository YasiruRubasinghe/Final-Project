package com.esoft.finalproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DonationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donationId;
    private int donatorId;
    private String donatorAddress;
    private int donateItemId;
}
