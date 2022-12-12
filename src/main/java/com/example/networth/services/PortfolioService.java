package com.example.networth.services;


import com.example.networth.models.Portfolio;
import com.example.networth.models.User;
import com.example.networth.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

private final PortfolioRepository portfolioDao;


    public PortfolioService(PortfolioRepository portfolioDao) {
        this.portfolioDao = portfolioDao;
    }

    public List<Portfolio> allPortfolio(){
        return portfolioDao.findAll();
    }


    public List<Portfolio> findByUser(User user){
        return portfolioDao.findByUser(user);
    }
}
