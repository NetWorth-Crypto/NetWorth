package com.example.networth.controllers;

import com.example.networth.models.Portfolio;
import com.example.networth.models.PortfolioAsset;
import com.example.networth.models.User;
import com.example.networth.repositories.PortfolioAssetRepository;
import com.example.networth.services.PortfolioAssetService;
import com.example.networth.services.PortfolioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class UserFinancePortfolioCtl {
    private final PortfolioService portfolioService;

    private final PortfolioAssetService portAssetDao;
    public UserFinancePortfolioCtl(PortfolioService portfolioService, PortfolioAssetService portAssetDao) {
        this.portfolioService = portfolioService;
        this.portAssetDao = portAssetDao;
    }


    @GetMapping("/userFinance")
    public String userFinancePage(Model model, RedirectAttributes redirectAttrs) {

  Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getPrincipal()=="anonymousUser") {
            redirectAttrs.addFlashAttribute("login","login to continue");
            return "redirect:/login";
        }
        User user = (User)auth.getPrincipal();
        System.out.println(user);
       List<Portfolio> portfolios =portfolioService.findByUser(user);
       model.addAttribute("portfolios",portfolios);
            return "users/userFinance";
    }


    @GetMapping("/createPortfolio")
    public String createPortfolio(){
        return "createPortfolio";
    }

    @PostMapping("/addPortfolio")
    public String addPortfolio(@RequestParam("name")String name,
                               @RequestParam("dollarLimit")int dollarLimit,
                               @RequestParam("type")String type
                              ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isDefault =type.equals("Default");
        boolean isPrivate = type.equals("Private");
        Portfolio portfolio = new Portfolio((User)auth.getPrincipal(),name,isDefault,dollarLimit,isPrivate);

portfolioService.addPortfolio(portfolio);
        return "redirect:/crypto";
    }

    @GetMapping(path = "/asset/{id}")
    public String getAsset(@PathVariable long id, Model model){
        System.out.println(id);
        List<PortfolioAsset> asset = portAssetDao.findByPortfolio(portfolioService.findById(id));
        model.addAttribute("asset",asset);
        System.out.println("here ------------------"+ asset.get(1).toString());
        return "users/userFinance";
    }

}