package com.leprpht.emeraldbackend.controller;

import com.leprpht.emeraldbackend.model.Campaign;
import com.leprpht.emeraldbackend.service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/campaigns")
    public CompletableFuture<ResponseEntity<List<Campaign>>> getAllCampaigns() {
        return campaignService.getAllCampaigns()
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/campaigns/{id}")
    public CompletableFuture<ResponseEntity<Campaign>> getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> ResponseEntity.notFound().build());
    }

    @PostMapping("/campaigns")
    public CompletableFuture<ResponseEntity<Campaign>> createCampaign(@RequestBody @Valid Campaign campaign) {
        return campaignService.saveCampaign(campaign)
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping("/campaigns/{id}")
    public CompletableFuture<ResponseEntity<Campaign>> updateCampaign(
            @PathVariable Long id,
            @RequestBody @Valid Campaign campaign
    ) {
        return campaignService.updateCampaign(id, campaign)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> ResponseEntity.notFound().build());
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
