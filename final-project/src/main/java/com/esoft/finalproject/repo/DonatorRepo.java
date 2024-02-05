package com.esoft.finalproject.repo;

import com.esoft.finalproject.entity.DonationCampaign;
import com.esoft.finalproject.entity.Donator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonatorRepo extends JpaRepository<Donator , Integer> {
    @Query(value = "select * from donator", nativeQuery = true)
    List<Donator> getAllDonator();
}
