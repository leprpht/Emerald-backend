package com.leprpht.emeraldbackend.controller;

import com.leprpht.emeraldbackend.model.Campaign;
import com.leprpht.emeraldbackend.service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        try{
            Campaign campaign = campaignService.getCampaignById(id);
            return ResponseEntity.ok(campaign);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/campaigns")
    public ResponseEntity<Campaign> createCampaign(@RequestBody @Valid Campaign campaign) {
        Campaign savedCampaign = campaignService.saveCampaign(campaign);
        return ResponseEntity.ok(savedCampaign);
    }

    @PutMapping("/campaigns")
    public ResponseEntity<Campaign> updateCampaign(@RequestBody @Valid Campaign campaign) {
        try{
            Campaign updatedCampaign = campaignService.updateCampaign(campaign);
            return ResponseEntity.ok(updatedCampaign);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        try{
            campaignService.deleteCampaign(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
