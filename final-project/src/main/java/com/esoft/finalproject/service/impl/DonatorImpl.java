package com.esoft.finalproject.service.impl;

import com.esoft.finalproject.dto.DonatorDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.entity.DonationItem;
import com.esoft.finalproject.entity.Donator;
import com.esoft.finalproject.repo.DonatorRepo;
import com.esoft.finalproject.service.DonatorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonatorImpl implements DonatorService {

    private final DonatorRepo donatorRepo;

    public DonatorImpl(DonatorRepo donatorRepo) {
        this.donatorRepo = donatorRepo;
    }

    public ResponseDTO saveDonator(DonatorDTO dto){
        Donator donator = new Donator();
        donator.setDonatorName(dto.getDonatorName());
        donator.setDonatorAge(dto.getDonatorAge());
        donator.setDonatorContact(dto.getDonatorContact());

        donatorRepo.save(donator);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO updateDonator(DonatorDTO dto) {
        Optional<Donator> optionalDonator = donatorRepo.findById(dto.getDonatorId());
        if(optionalDonator.isPresent()){
            Donator donator = optionalDonator.get();
            donator.setDonatorContact(dto.getDonatorContact());
            donator.setDonatorAge(dto.getDonatorAge());
            donator.setDonatorName(dto.getDonatorName());

            donatorRepo.save(donator);
        }
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO deleteBydonatorId(int id) {
        donatorRepo.deleteById(id);
        return new ResponseDTO();
    }

    @Override
    public List<DonatorDTO> getAllDonator() {
        List<DonatorDTO>donatorDTOS = new ArrayList<>();
        List<Donator> donator = donatorRepo.getAllDonator();
        for (Donator d:donator) {
            DonatorDTO donatorDTO = new DonatorDTO();
            donatorDTO.setDonatorId(d.getDonatorId());
            donatorDTO.setDonatorName(d.getDonatorName());
            donatorDTO.setDonatorAge(d.getDonatorAge());
            donatorDTO.setDonatorContact(d.getDonatorContact());
            donatorDTOS.add(donatorDTO);
        }
        return donatorDTOS;
    }

}
