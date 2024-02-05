package com.esoft.finalproject.service.impl;

import com.esoft.finalproject.dto.DonationItemDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.entity.DonationItem;
import com.esoft.finalproject.repo.DonationItemRepo;
import com.esoft.finalproject.service.DonationItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonationItemImpl implements DonationItemService {

    private DonationItemRepo donationItemRepo;

    public DonationItemImpl(DonationItemRepo donationItemRepo){
        this.donationItemRepo = donationItemRepo;
    }

    @Override
    public ResponseDTO saveDonationItem(DonationItemDTO dto) {
        DonationItem donationItem = new DonationItem();
        donationItem.setDescription(dto.getDescription());
        donationItem.setCategoryId(dto.getCategoryId());
        donationItem.setDonatorId(dto.getDonatorId());
        donationItemRepo.save(donationItem);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO updateDonationItem(DonationItemDTO dto) {
        DonationItem donationItem = donationItemRepo.findById(dto.getDonationItemId()).get();
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO deleteByDonationItemId(int Id) {
        donationItemRepo.deleteById(Id);
        return new ResponseDTO();
    }

    @Override
    public List<DonationItemDTO> getAllDonationItem() {
        List<DonationItemDTO>donationItemDTOS = new ArrayList<>();
        List<DonationItem>donationItems = donationItemRepo.getAllDonationItem();
        for (DonationItem d: donationItems) {
            DonationItemDTO donationItemDTO = new DonationItemDTO();
            donationItemDTO.setDonationItemId(d.getDonationItemId());
            donationItemDTO.setDescription(d.getDescription());
            donationItemDTO.setCategoryId(d.getCategoryId());
            donationItemDTO.setCategoryId(d.getDonatorId());
            donationItemDTOS.add(donationItemDTO);
        }
        return donationItemDTOS;
    }
}
