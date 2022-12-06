package com.example.networth.models;

import javax.persistence.*;

@Entity
public class PortfolioAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    Asset asset;

    @Column(nullable = false)
    double quantity;

    public PortfolioAsset() {
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
