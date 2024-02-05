package com.esoft.finalproject.service.impl;
import com.esoft.finalproject.dto.DonationCampaignDTO;
import com.esoft.finalproject.dto.DonationCategoryDTO;
import com.esoft.finalproject.dto.ResponseDTO;
import com.esoft.finalproject.entity.DonationCampaign;
import com.esoft.finalproject.repo.DonationCampaignRepo;
import com.esoft.finalproject.service.DonationCampaignService;
import com.esoft.finalproject.util.FileUtilizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DonationCampaignImpl implements DonationCampaignService {

    private final DonationCampaignRepo donationCampaignRepo;

    @Value("${archive.path}")
    private String archivePath;
    @Value("${backendBaseUrl}")
    private String baseUrl;

    public DonationCampaignImpl(DonationCampaignRepo donationCampaignRepo) {
        this.donationCampaignRepo = donationCampaignRepo;
    }

    @Override
    public ResponseDTO saveCampaign(DonationCampaignDTO dto) {
        DonationCampaign donationCampaign = new DonationCampaign();
        donationCampaign.setCampaignTitle(dto.getCampaignTitle());
        donationCampaign.setDescription(dto.getDescription());
        donationCampaign.setContact(dto.getContact());

        MultipartFile file = dto.getImageFile();
        if (file != null) {
            String urlPrefix = baseUrl + "/files/";
            String fileName = new FileUtilizer().generateFileName(file.getOriginalFilename());
            String fileLocation = archivePath + "/" + fileName;
            String fileUrl = urlPrefix + fileName;
            if (!new FileUtilizer().writeToDisk(file, Paths.get(archivePath), fileName))
                try {
                    throw new Exception("File Writing Error Occurred!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            else {
                donationCampaign.setImageUrl(fileUrl);
                donationCampaign.setImageFile(fileLocation);
            }
        }

        donationCampaignRepo.save(donationCampaign);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO updateCampaign(DonationCampaignDTO dto) {
        DonationCampaign donationCampaign = donationCampaignRepo.findById(dto.getCampaignId()).get();
//        MultipartFile file = dto.getImageFile();
//        if (file != null) {
//            String urlPrefix = baseUrl + "/files/";
//            String fileName = new FileUtilizer().generateFileName(file.getOriginalFilename());
//            String fileLocation = archivePath + "/" + fileName;
//            String fileUrl = urlPrefix + fileName;
//            if (!new FileUtilizer().writeToDisk(file, Paths.get(archivePath), fileName))
//                try {
//                    throw new Exception("File Writing Error Occurred!");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            else {
//                donationCampaign.setImageUrl(fileUrl);
//                donationCampaign.setImageFile(fileLocation);
//            }
//        }
        donationCampaignRepo.save(donationCampaign);
        return new ResponseDTO();
    }

    @Override
    public ResponseDTO deleteByCampaignId(int Id) {
        donationCampaignRepo.deleteById(Id);
        return new ResponseDTO();
    }

    @Override
    public List<DonationCampaignDTO> getAllCampaign() {
        List<DonationCampaignDTO> donationCampaignDTOS = new ArrayList<>();
        List<DonationCampaign> donationCampaign = donationCampaignRepo.getAllCampaign();
        for (DonationCampaign d:donationCampaign) {
           DonationCampaignDTO donationCampaignDTO = new DonationCampaignDTO();
           donationCampaignDTO.setCampaignId(d.getCampaignId());
           donationCampaignDTO.setCampaignTitle(d.getCampaignTitle());
           donationCampaignDTO.setDescription(d.getDescription());
           donationCampaignDTO.setContact(d.getContact());
           donationCampaignDTOS.add(donationCampaignDTO);
        }
        return donationCampaignDTOS;
    }
}
