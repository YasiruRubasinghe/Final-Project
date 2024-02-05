package com.esoft.finalproject.controller;

import com.esoft.finalproject.dto.DonationCategoryDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.service.DonationCategoryService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Donation/Donation_Category")

public class DonationCategoryController {

    private DonationCategoryService service;


    public DonationCategoryController(DonationCategoryService service){
        this.service = service;
    }

    @RequestMapping("/save")
    public ResponseDTO saveDonationCategory(@RequestParam(value = "categoryName") String categoryName
    )
    {
        DonationCategoryDTO dto = new DonationCategoryDTO();
        dto.setCategoryName(categoryName);

        return service.saveDonationCategory(dto);
    }

    @PutMapping("/update")
    public ResponseDTO updateDonationCategory(@RequestParam(value = "categoryId") int categoryId,
                                              @RequestParam(value = "categoryName") String categoryName
    )
    {
        DonationCategoryDTO dto = new DonationCategoryDTO();
        dto.setCategoryId(categoryId);
        dto.setCategoryName(categoryName);

//        return service.updateDonationCategory(dto);
        service.updateDonationCategory(dto);
        return new ResponseDTO(200,"Category Update Successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteByDonationCategoryId(@PathVariable("id") int id)
    {return service.deleteByDonationCategoryId(id);}

    @GetMapping("/get-all")
    public ResponseDTO getAllDonationCategory(){
        return new ResponseDTO(200,"Successfully",service.getAllDonationCategory());
//        return service.getAllDonationCategory();
    }

}
