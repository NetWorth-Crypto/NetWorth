package com.example.networth.repositories;

import com.example.networth.models.PortfolioAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioAssetRepository extends JpaRepository<PortfolioAsset,Long> {
}
