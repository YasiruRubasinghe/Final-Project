package com.esoft.finalproject.repo;

import com.esoft.finalproject.entity.DonationCampaign;
import com.esoft.finalproject.entity.DonationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationCategoryRepo extends JpaRepository<DonationCategory , Integer> {
    @Query(value = "select * from donation_category ", nativeQuery = true)
    List<DonationCategory>getAllDonationCategory();
}
