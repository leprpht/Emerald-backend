package com.leprpht.emeraldbackend.repository;

import com.leprpht.emeraldbackend.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> { }
