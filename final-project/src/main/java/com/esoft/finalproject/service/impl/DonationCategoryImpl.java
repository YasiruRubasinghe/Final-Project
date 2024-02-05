package com.esoft.finalproject.service.impl;

import com.esoft.finalproject.dto.DonationCategoryDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.entity.DonationCategory;
import com.esoft.finalproject.repo.DonationCategoryRepo;
import com.esoft.finalproject.service.DonationCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DonationCategoryImpl implements DonationCategoryService {

    private final DonationCategoryRepo donationCategoryRepo;

    public DonationCategoryImpl(DonationCategoryRepo donationCategoryRepo) {
        this.donationCategoryRepo = donationCategoryRepo;
    }

    @Override
    public ResponseDTO saveDonationCategory(DonationCategoryDTO dto) {
        DonationCategory donationCategory = new DonationCategory();
        donationCategory.setCategoryName(dto.getCategoryName());
        donationCategoryRepo.save(donationCategory);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO updateDonationCategory(DonationCategoryDTO dto) {
        DonationCategory donationCategory = donationCategoryRepo.findById(dto.getCategoryId()).get();
        donationCategoryRepo.save(donationCategory);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO deleteByDonationCategoryId(int Id) {
        donationCategoryRepo.deleteById(Id);
        return new ResponseDTO();
    }

    @Override
    public List<DonationCategoryDTO> getAllDonationCategory() {
        List<DonationCategoryDTO> donationCategoryDTOS = new ArrayList<>();
        List<DonationCategory> donationCategory = donationCategoryRepo.getAllDonationCategory();
        for (DonationCategory d:donationCategory) {
            DonationCategoryDTO donationCategoryDTO = new DonationCategoryDTO();
            donationCategoryDTO.setCategoryId(d.getCategoryId());
            donationCategoryDTO.setCategoryName(d.getCategoryName());
            donationCategoryDTOS.add(donationCategoryDTO);
        }
        return donationCategoryDTOS;
    }
}
