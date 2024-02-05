package com.esoft.finalproject.repo;

import com.esoft.finalproject.entity.DonationDetails;
import com.esoft.finalproject.entity.DonationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationItemRepo extends JpaRepository<DonationItem, Integer> {
    @Query(value = "select * from  donation_item", nativeQuery = true)
    List<DonationItem> getAllDonationItem();
}
