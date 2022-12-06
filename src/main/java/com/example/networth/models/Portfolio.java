package com.example.networth.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column
    private boolean isDefault;

    @Column
    private double dollarLimit;

    @Column
    private boolean isPrivate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="portfolio_asset",
            joinColumns={@JoinColumn(name="portfolio_id")},
            inverseJoinColumns={@JoinColumn(name="asset_id")}
    )
    private List<Asset> assets;

    public Portfolio() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

//    public double getLimit() {
//        return limit;
//    }
//
//    public void setLimit(double limit) {
//        this.limit = limit;
//    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
