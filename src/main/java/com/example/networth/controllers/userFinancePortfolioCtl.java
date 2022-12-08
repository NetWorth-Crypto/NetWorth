package com.example.networth.controllers;

import com.example.networth.models.Portfolio;
import com.example.networth.models.User;
import com.example.networth.services.PortfolioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class userFinancePortfolioCtl {
    private final PortfolioService portfolioService;

    public userFinancePortfolioCtl(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    @GetMapping("/userFinance")
    public String userFinancePage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getPrincipal() == "anonymousUser") {
            return "redirect:login";
        }
        User user = (User)auth.getPrincipal();
        System.out.println(user);
       List<Portfolio> portfolios =portfolioService.findByUser(user);
       model.addAttribute("portfolios",portfolios);
            return "users/userFinance";



    }
}