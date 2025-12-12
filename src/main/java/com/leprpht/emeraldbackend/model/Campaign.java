package com.leprpht.emeraldbackend.model;

import jakarta.persistence.*;
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

    private String campaignName; // Campaign name (mandatory)

    @ElementCollection
    private List<String> keywords = new ArrayList<>(); // Keywords (mandatory, pre-populated with typeahead)

    private double bidAmount; // Bid amount (mandatory, min amount)

    private double campaignFund; // Campaign fund (mandatory and deducted from their Emerald account funds, new balance updated on screen)

    private boolean status; // Status (on or off - mandatory)

    private String town; // Town (can pick from a pre-populated dropdown list of towns)

    private double radius; // Radius (mandatory in kilometres)
}
