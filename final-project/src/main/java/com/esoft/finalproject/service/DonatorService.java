package com.esoft.finalproject.service;

import com.esoft.finalproject.dto.DonatorDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.entity.Donator;

import java.util.List;

public interface DonatorService {
    ResponseDTO saveDonator(DonatorDTO dto);
    ResponseDTO updateDonator(DonatorDTO dto);
    ResponseDTO deleteBydonatorId(int id);
    List<DonatorDTO> getAllDonator();
}
