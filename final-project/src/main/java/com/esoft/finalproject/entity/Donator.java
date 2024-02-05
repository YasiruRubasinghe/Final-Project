package com.esoft.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Donator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donatorId;
    private String donatorName;
    private String donatorAge;
    private String donatorContact;

}
