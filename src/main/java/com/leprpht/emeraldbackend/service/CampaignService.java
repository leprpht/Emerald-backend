package com.leprpht.emeraldbackend.service;

import com.leprpht.emeraldbackend.model.Campaign;
import com.leprpht.emeraldbackend.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(Long id){
        return campaignRepository.findById(id).orElse(null);
    }

    public Campaign saveCampaign(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long id){
        campaignRepository.deleteById(id);
    }

    public Campaign updateCampaign(Campaign campaign){
        Campaign campaignToUpdate = campaignRepository.findById(campaign.getId()).orElse(null);
        if (campaignToUpdate == null) throw new RuntimeException("Campaign not found");
        Campaign updatedCampaign = setNewValues(campaignToUpdate, campaign);
        return campaignRepository.save(updatedCampaign);
    }

    private static Campaign setNewValues(Campaign existing, Campaign updated) {
        existing.setCampaignName(updated.getCampaignName());
        existing.setKeywords(updated.getKeywords());
        existing.setBidAmount(updated.getBidAmount());
        existing.setCampaignFund(updated.getCampaignFund());
        existing.setStatus(updated.isStatus());
        existing.setTown(updated.getTown());
        existing.setRadius(updated.getRadius());
        return existing;
    }
}
