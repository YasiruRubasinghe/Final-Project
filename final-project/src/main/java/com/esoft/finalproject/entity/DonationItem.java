package com.esoft.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DonationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donationItemId;
    private String description;
    private int categoryId;
    private int donatorId;
}
