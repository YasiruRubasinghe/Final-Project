package com.esoft.finalproject.service.impl;

import com.esoft.finalproject.dto.DonationDetailsDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.entity.DonationDetails;
import com.esoft.finalproject.entity.DonationItem;
import com.esoft.finalproject.entity.Donator;
import com.esoft.finalproject.repo.DonationDetailsRepo;
import com.esoft.finalproject.repo.DonationItemRepo;
import com.esoft.finalproject.repo.DonatorRepo;
import com.esoft.finalproject.service.DonationDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonationDetailsImpl implements DonationDetailsService {

    private DonationDetailsRepo donationDetailsRepo;
    private DonationItemRepo donationItemRepo;
    private DonatorRepo donatorRepo;

    public DonationDetailsImpl(DonationDetailsRepo donationDetailsRepo, DonationItemRepo donationItemRepo, DonatorRepo donatorRepo){
        this.donationDetailsRepo = donationDetailsRepo;
        this.donationItemRepo = donationItemRepo;
        this.donatorRepo = donatorRepo;
    }

    @Override
    public ResponseDTO saveDonationDetails(DonationDetailsDTO dto) {
        DonationDetails donationDetails = new DonationDetails();
        Optional<DonationItem> optionalDonationItem = donationItemRepo.findById(dto.getDonateItemId());
        if(optionalDonationItem.isPresent()){
            donationDetails.setDonateItemId(optionalDonationItem.get().getDonationItemId());
        }
        Optional<Donator> optionalDonator = donatorRepo.findById(dto.getDonateItemId());
        if(optionalDonator.isPresent()){
            donationDetails.setDonatorId(optionalDonator.get().getDonatorId());
        }

        donationDetails.setDonatorAddress(dto.getDonatorAddress());

        donationDetailsRepo.save(donationDetails);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO updateDonationDetails(DonationDetailsDTO dto) {
        DonationDetails donationDetails = donationDetailsRepo.findById(dto.getDonationId()).get();
        donationDetailsRepo.save(donationDetails);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO deleteByDonationId(int id) {
        donationDetailsRepo.deleteById(id);
        return new ResponseDTO();
    }

    @Override
    public List<DonationDetailsDTO> getAllDonationDetails() {
        List<DonationDetailsDTO> donationDetailsDTOS = new ArrayList<>();
        List<DonationDetails> donationDetails = donationDetailsRepo.getAllDonationDetails();
        for (DonationDetails d :donationDetails) {
            DonationDetailsDTO donationDetailsDTO = new DonationDetailsDTO();
            donationDetailsDTO.setDonationId(d.getDonationId());
            donationDetailsDTO.setDonatorId(d.getDonatorId());
            donationDetailsDTO.setDonatorAddress(d.getDonatorAddress());
            donationDetailsDTO.setDonateItemId(d.getDonateItemId());
            donationDetailsDTOS.add(donationDetailsDTO);
        }
        return donationDetailsDTOS;
    }

    @Override
    public List<DonationDetailsDTO> getFilterAllDonationDetails(String name) {
        List<DonationDetailsDTO> donationDetailsDTOS = new ArrayList<>();
        List<DonationDetails> donationDetails = donationDetailsRepo.getAllDonationDetailsFilter(name);
        for (DonationDetails d :donationDetails) {
            DonationDetailsDTO donationDetailsDTO = new DonationDetailsDTO();
            donationDetailsDTO.setDonationId(d.getDonationId());
            donationDetailsDTO.setDonatorId(d.getDonatorId());
            donationDetailsDTO.setDonatorAddress(d.getDonatorAddress());
            donationDetailsDTO.setDonateItemId(d.getDonateItemId());
            donationDetailsDTOS.add(donationDetailsDTO);
        }
        return donationDetailsDTOS;
    }
}
