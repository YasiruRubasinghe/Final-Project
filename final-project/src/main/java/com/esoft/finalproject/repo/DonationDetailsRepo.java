package com.esoft.finalproject.repo;

import com.esoft.finalproject.entity.DonationDetails;
import com.esoft.finalproject.entity.Donator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationDetailsRepo extends JpaRepository<DonationDetails, Integer> {
    @Query(value = "select * from donation_details", nativeQuery = true)
    List<DonationDetails> getAllDonationDetails();

    @Query(value = "select * from donation_details s where s.donator_address=?1 ", nativeQuery = true)
    List<DonationDetails> getAllDonationDetailsFilter(String address);
}
