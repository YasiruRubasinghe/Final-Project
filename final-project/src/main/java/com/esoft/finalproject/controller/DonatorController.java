package com.esoft.finalproject.controller;

import com.esoft.finalproject.dto.DonatorDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.service.DonatorService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Donation/Donator")
public class DonatorController {

    private final DonatorService service;

    public DonatorController(DonatorService service) {
        this.service = service;
    }

    @RequestMapping("/save")
    public ResponseDTO saveDonator(@RequestParam(value = "donatorName") String donatorName,
                                   @RequestParam(value = "donatorAge") String donatorAge,
                                   @RequestParam(value = "donatorContact") String donatorContact
    ) {
        DonatorDTO dto = new DonatorDTO();
        dto.setDonatorName(donatorName);
        dto.setDonatorAge(donatorAge);
        dto.setDonatorContact(donatorContact);

        return service.saveDonator(dto);
    }

    @PutMapping("/update")
    public ResponseDTO updateDonator(@RequestParam(value = "donatorId") int donatorId,
                                     @RequestParam(value = "donatorName") String donatorName,
                                     @RequestParam(value = "donatorAge") String donatorAge,
                                     @RequestParam(value = "donatorContact") String donatorContact
    ) {
        DonatorDTO dto = new DonatorDTO();
        dto.setDonatorId(donatorId);
        dto.setDonatorName(donatorName);
        dto.setDonatorAge(donatorAge);
        dto.setDonatorContact(donatorContact);

        service.updateDonator(dto);
        return new ResponseDTO(200,"Donator Update Successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteBydonatorId(@PathVariable("id") int id){
        return service.deleteBydonatorId(id);
    }

    @GetMapping("/get-all")
    public ResponseDTO getAllDonator() {
        return new ResponseDTO(200,"Successfully",service.getAllDonator());
    }

}
