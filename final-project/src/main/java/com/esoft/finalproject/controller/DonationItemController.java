package com.esoft.finalproject.controller;

import com.esoft.finalproject.dto.DonationItemDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.service.DonationItemService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Donation/Item")
public class DonationItemController {

    private DonationItemService service;

    public DonationItemController(DonationItemService service){
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseDTO saveDonationItem(@RequestParam(value = "description") String description,
                                        @RequestParam(value = "categoryId") int categoryId,
                                        @RequestParam(value = "donatorId") int donatorId
    )
    {
        DonationItemDTO dto = new DonationItemDTO();
        dto.setDescription(description);
        dto.setCategoryId(categoryId);
        dto.setDonatorId(donatorId);

        return service.saveDonationItem(dto);
    }

    @PostMapping("/update")
    public ResponseDTO updateDonationItem(@RequestParam(value = "donationItemId") int donationItemId,
                                          @RequestParam(value = "description") String description,
                                          @RequestParam(value = "categoryId") int categoryId,
                                          @RequestParam(value = "donatorId") int donatorId
    )
    {
        DonationItemDTO dto = new DonationItemDTO();
        dto.setDonationItemId(donationItemId);
        dto.setDescription(description);
        dto.setCategoryId(categoryId);
        dto.setDonatorId(donatorId);

        service.updateDonationItem(dto);
        return new ResponseDTO(200,"Donation Item Update Successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteByDonationItemId(@RequestParam(value = "donationItemId") int donationItemId) {
        return service.deleteByDonationItemId(donationItemId);
    }

    @GetMapping("/get-all")
    public ResponseDTO getAllDonationItem() {
        return new ResponseDTO(200,"Successfully",service.getAllDonationItem());
    }

}
