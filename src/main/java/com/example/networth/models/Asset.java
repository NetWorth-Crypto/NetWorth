package com.example.networth.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "assets")
    private List<Portfolio> portfolios;

    @Column(unique = true, nullable = false)
    private String ticker;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private double purchasePrice;

    @Column(nullable = false)
    private double currentPrice;

    public Asset() {
    }

    public Asset(String ticker, String name, double quantity, double purchasePrice, double currentPrice) {
        this.ticker = ticker;
        this.name = name;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Portfolio> getPortfolio() {
        return portfolios;
    }

    public void setPortfolio(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
