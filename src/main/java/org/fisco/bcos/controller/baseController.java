package org.fisco.bcos.controller;

import org.fisco.bcos.autoconfigure.AccountConfig;
import org.fisco.bcos.service.*;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class baseController {
    @Autowired
    Service1 service1;

    @Autowired
    TokenSewageService tokenSewageService;

    @Autowired
    private AccountConfig accountConfig;


    @RequestMapping("/test")
    public ModelAndView tiger() {
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0xa1f2bdeaa430c05dda9375ebf53218d03993a72a.p12", "123456");
            String str = service1.deployAndCallHelloWorld(credentials);
            return new ModelAndView("Tiger", "tigerName", str);
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/user_index")
    public ModelAndView b() {
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0x98333491efac02f8ce109b0c499074d47e7779a6.p12", "123456");
            return new ModelAndView("user_index");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/transaction")
    public ModelAndView transaction() {
        try {
            return new ModelAndView("transaction");

        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        try {
            return new ModelAndView("login");

        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/auction")
    public ModelAndView auction() {
        try {
            return new ModelAndView("auction");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/shop")
    public ModelAndView shop() {
        try {
            return new ModelAndView("shop");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/initIndex")
    public ModelAndView initIndex() {
        try {
            return new ModelAndView("init");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/transaction_in")
    public ModelAndView transaction_in() {
        try {
            return new ModelAndView("transaction_in");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/transaction_out")
    public ModelAndView transaction_out() {
        try {
            return new ModelAndView("transaction_in");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }

    @RequestMapping("/user_detail")
    public ModelAndView user_detail() {
        try {
            return new ModelAndView("user_index");
        } catch (Exception e) {
            return new ModelAndView("404");
        }
    }
}
