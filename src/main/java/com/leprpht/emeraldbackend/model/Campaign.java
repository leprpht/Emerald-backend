package com.leprpht.emeraldbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campaign name cannot be empty")
    private String campaignName; // Campaign name (mandatory)

    @ElementCollection
    @NotEmpty(message = "At least one keyword is required")
    private List<String> keywords = new ArrayList<>(); // Keywords (mandatory, pre-populated with typeahead)

    @Positive(message = "Bid amount must be positive")
    private double bidAmount; // Bid amount (mandatory, min amount)

    @Positive(message = "Campaign fund must be positive")
    private double campaignFund; // Campaign fund (mandatory and deducted from their Emerald account funds, new balance updated on screen)

    private boolean status; // Status (on or off - mandatory)

    @NotBlank(message = "Town cannot be empty")
    private String town; // Town (can pick from a pre-populated dropdown list of towns)

    @Positive(message = "Radius must be positive")
    private double radius; // Radius (mandatory in kilometres)
}
