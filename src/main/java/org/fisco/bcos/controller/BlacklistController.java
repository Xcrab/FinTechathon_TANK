package org.fisco.bcos.controller;

import org.fisco.bcos.autoconfigure.AccountConfig;
//import org.fisco.bcos.service.Service1;
import org.fisco.bcos.service.BlacklistService;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class BlacklistController {
    @Autowired
    BlacklistService blacklistService;

    @Autowired
    private AccountConfig accountConfig;

    @RequestMapping("/addBlacklist")
    public ModelAndView addBlacklist() {
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0xa1f2bdeaa430c05dda9375ebf53218d03993a72a.p12", "123456");
            String contractAddress = blacklistService.deploy(credentials);
            blacklistService.addEenterprise(credentials, "0xda34503225099be6756d62cb717eceb630eb2ac0",
                    "ttt", "0100", "10", "5%", "4000");
            return new ModelAndView("tables");
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @RequestMapping("/testAddBlacklist")
    public ModelAndView testAddBlacklist() {
        try {
            Credentials credentials =
                    accountConfig.setp12Account("accounts/0xa1f2bdeaa430c05dda9375ebf53218d03993a72a.p12", "123456");
            Boolean contractAddress = blacklistService.testAdd(credentials);
            return new ModelAndView("tables");
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @RequestMapping("/query")
    public ModelAndView query() {
        System.out.println("test");
        try {
            Credentials credentials =
                    accountConfig.setp12Account("accounts/0xa1f2bdeaa430c05dda9375ebf53218d03993a72a.p12", "123456");
            String str = blacklistService.queryEenterprise(credentials);
            System.out.println(str);
            return new ModelAndView("tables");
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @RequestMapping("/deployBlacklist")
    public ModelAndView deployBlacklist() {
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0xa1f2bdeaa430c05dda9375ebf53218d03993a72a.p12", "123456");
            String contractAddress = blacklistService.deploy(credentials);
            System.out.println("address");
            System.out.println(contractAddress);
            return new ModelAndView("dashboard");
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }
}
