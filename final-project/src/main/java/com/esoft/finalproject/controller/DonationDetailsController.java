package com.esoft.finalproject.controller;

import com.esoft.finalproject.dto.DonationDetailsDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.service.DonationDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Donation/Donation_Details")
public class DonationDetailsController {

    private DonationDetailsService service;

    public DonationDetailsController(DonationDetailsService service){
        this.service = service;
    }

    @RequestMapping("/save")
    public ResponseDTO saveDonationDetails(@RequestParam(value = "donatorId") int donatorId,
                                           @RequestParam(value = "donatorAddress") String donatorAddress,
                                           @RequestParam(value = "donateItemId") int donateItemId
    )
    {
        DonationDetailsDTO dto = new DonationDetailsDTO();
        dto.setDonatorId(donatorId);
        dto.setDonatorAddress(donatorAddress);
        dto.setDonateItemId(donateItemId);
        return service.saveDonationDetails(dto);

    }
    @PostMapping("/update")
    public ResponseDTO updateDonationDetails(@RequestParam(value = "donationId") int donationId,
                                             @RequestParam(value = "donatorId") int donatorId,
                                             @RequestParam(value = "donatorAddress") String donatorAddress,
                                             @RequestParam(value = "donateItemId") String donateItemId

    )
    {
        DonationDetailsDTO dto = new DonationDetailsDTO();
        dto.setDonationId(donationId);
        service.updateDonationDetails(dto);
        return new ResponseDTO(200,"Donation Details Update Successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteByDonationId(@RequestParam(value = "donationId") int donationId)
    { return service.deleteByDonationId(donationId);}

    @GetMapping("/get-all")
    public ResponseDTO getAllDonationDetails()
    {return new ResponseDTO(200,"Successfully",service.getAllDonationDetails()); }

    @GetMapping("/get-all/filter/{address}")
    public ResponseDTO getAllDonationFilterDetails(@PathVariable String address)
    {return new ResponseDTO(200,"Successfully",service.getFilterAllDonationDetails(address)); }
}
