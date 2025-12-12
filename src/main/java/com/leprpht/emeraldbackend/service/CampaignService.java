package com.leprpht.emeraldbackend.service;

import com.leprpht.emeraldbackend.model.Campaign;
import com.leprpht.emeraldbackend.repository.CampaignRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Async
    public CompletableFuture<List<Campaign>> getAllCampaigns(){
        return CompletableFuture.completedFuture(campaignRepository.findAll());
    }

    @Async
    public CompletableFuture<Campaign> getCampaignById(Long id){
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if (campaign == null) throw new RuntimeException("Campaign not found");
        return CompletableFuture.completedFuture(campaign);
    }

    @Async
    public CompletableFuture<Campaign> saveCampaign(Campaign campaign){
        return CompletableFuture.completedFuture(campaignRepository.save(campaign));
    }

    @Async
    public void deleteCampaign(Long id){
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if (campaign == null) throw new RuntimeException("Campaign not found");
        campaignRepository.delete(campaign);
    }

    @Async
    public CompletableFuture<Campaign> updateCampaign(Campaign campaign){
        Campaign campaignToUpdate = campaignRepository.findById(campaign.getId()).orElse(null);
        if (campaignToUpdate == null) throw new RuntimeException("Campaign not found");
        Campaign updatedCampaign = setNewValues(campaignToUpdate, campaign);
        return CompletableFuture.completedFuture(campaignRepository.save(updatedCampaign));
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
