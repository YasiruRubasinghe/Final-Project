package com.esoft.finalproject.repo;

import com.esoft.finalproject.entity.DonationCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationCampaignRepo extends JpaRepository<DonationCampaign, Integer> {
    @Query(value = "select * from donation_campaign", nativeQuery = true)
    List<DonationCampaign> getAllCampaign();
}
