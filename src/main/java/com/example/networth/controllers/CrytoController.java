package com.example.networth.controllers;


import com.example.networth.models.Asset;
import com.example.networth.models.Portfolio;
import com.example.networth.models.PortfolioAsset;
import com.example.networth.models.User;
import com.example.networth.services.AssetService;
import com.example.networth.services.PortfolioAssetService;
import com.example.networth.services.PortfolioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class CrytoController {


    private final PortfolioService portfolioService;
    private final AssetService assetService;
    private final PortfolioAssetService pAservice;

    public CrytoController(PortfolioService portfolioService, AssetService assetService, PortfolioAssetService pAservice) {
        this.portfolioService = portfolioService;
        this.assetService = assetService;
        this.pAservice = pAservice;
    }


    @GetMapping("/crypto")
    public String getCrypto(){
        return "crypto";
    }
    boolean isLogin = SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser" || SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null;

    @GetMapping(path = "/addCrypto/{price}/{name}/{ticker}")
    public String addCrypto(@PathVariable String name,@PathVariable String ticker,@PathVariable float price, Model model){
if(!isLogin){
    model.addAttribute("login", "login To access Portfolio");
    return "users/login";}
        System.out.println(price);
        System.out.println(name);
        System.out.println(ticker);
        model.addAttribute("price",price);
        model.addAttribute("name",name);
        model.addAttribute("ticker",ticker);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = (User)auth.getPrincipal();
        System.out.println(user);
        List<Portfolio> portfolios =portfolioService.findByUser(user);
        model.addAttribute("portfolios",portfolios);
if(portfolios.isEmpty()){
   model.addAttribute("needPortfolio","Creat a portfolio in order to add assets");
   return "createPortfolio";
}


        return "/addAsset";
    }

    @RequestMapping(value = "/add_crypto", method = RequestMethod.POST)
    public String addAsset(@RequestParam("name")String name,
                           @RequestParam("ticker")String ticker,
                           @RequestParam("price")double price,
                           @RequestParam("quantity")int quantity,
                           @RequestParam("portfolio")String portfolio,
                              Model model )
                          {
Portfolio newPortfolio = portfolioService.findByName(portfolio);
       Asset checkAsset = assetService.findByName(name);

       if(assetService.findByName(name)==null || pAservice.findByAssetAndPortfolio(assetService.findByName(name),newPortfolio)==null) {
           assetService.addAsset(new Asset(ticker, name, price));
           Asset asset = assetService.findByName(name);

           Portfolio portfolio1 = portfolioService.findByName(portfolio);


           Date date = new Date();
           pAservice.addpAsset(new PortfolioAsset(portfolio1, asset, quantity, price, date));

           return "redirect:/userFinance";
       }else {
          model.addAttribute("red","Ticker already Exist in Portfolio");
           return "addAsset";
       }

    }



}
