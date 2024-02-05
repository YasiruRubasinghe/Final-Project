package com.esoft.finalproject.controller;

import com.esoft.finalproject.dto.DonationCampaignDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.service.DonationCampaignService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/Donation/Donation_Campaign")
public class DonationCampaignController {

   private DonationCampaignService service;

   public DonationCampaignController(DonationCampaignService service){
       this.service = service;
   }

   @PostMapping("/save")
    public ResponseDTO saveCampaign(
                                    @RequestParam(value = "campaignTitle") String campaignTitle,
                                    @RequestParam(value = "description") String description,
                                    @RequestParam(value = "contact") String contact)
   {
       DonationCampaignDTO dto = new DonationCampaignDTO();
       dto.setCampaignTitle(campaignTitle);
       dto.setDescription(description);
       dto.setContact(contact);


       return service.saveCampaign(dto);
   }

   @PutMapping("/update")
    public ResponseDTO UpdateCampaign(@RequestParam(value = "imageFile") MultipartFile imageFile,
                                      @RequestParam(value = "campaignId") int campaignId,
                                      @RequestParam(value = "campaignTitle") String campaignTitle,
                                      @RequestParam(value = "description") String description,
                                      @RequestParam(value = "contact") String contact
    )
      {
          DonationCampaignDTO dto = new DonationCampaignDTO();
          dto.setCampaignId(campaignId);
          dto.setCampaignTitle(campaignTitle);
          dto.setDescription(description);
          dto.setContact(contact);
          dto.setImageFile(imageFile);

          service.updateCampaign(dto);
          return new ResponseDTO(200,"Campaign Update successfully");
      }

      @DeleteMapping("/delete/{id}")
      public ResponseDTO deleteByCampaignId(@PathVariable("id") int id){
         return service.deleteByCampaignId(id);
      }

      @GetMapping("/get-all")
      public ResponseDTO getAllCampaign(){
       return new ResponseDTO( 200,"Successfully",service.getAllCampaign());
      }

}
