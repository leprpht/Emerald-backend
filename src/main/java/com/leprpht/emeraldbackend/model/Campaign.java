package com.leprpht.emeraldbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campaign name cannot be empty")
    private String campaignName;

    @ElementCollection(fetch = FetchType.EAGER)
    @NotEmpty(message = "At least one keyword is required")
    private List<String> keywords = new ArrayList<>();

    @Positive(message = "Bid amount must be positive")
    private double bidAmount;

    @Positive(message = "Campaign fund must be positive")
    private double campaignFund;

    private boolean status;

    @NotBlank(message = "Town cannot be empty")
    private String town;

    @Positive(message = "Radius must be positive")
    private double radius;
}
