package org.fisco.bcos.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.fisco.bcos.tools.Utils;
import org.fisco.bcos.autoconfigure.AccountConfig;
import org.fisco.bcos.service.*;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class sellController {

    @Autowired
    SellSewageService sellSewageService;

    @Autowired
    private AccountConfig accountConfig;

    private ArrayList<String> account = new ArrayList<String>();
    private ArrayList<String> p2pOrder = new ArrayList<String>();


    private void initAccount() {

        JSONObject jsonAccount = Utils.readJsonObject("/home/xcrab/projects/FinTechathon/src/main/resources/data/account.json");
        List<String> ar = JSON.parseArray(jsonAccount.getJSONArray("Account").toJSONString(), String.class);
        int lenAr = ar.size();

        JSONObject jsonP2pOrder = Utils.readJsonObject("/home/xcrab/projects/FinTechathon/src/main/resources/data/p2p_order.json");
        List<String> pr = JSON.parseArray(jsonP2pOrder.getJSONArray("Order").toJSONString(), String.class);
        int lenPr = pr.size();

        for (int i = 0; i < lenAr; i++) {
            if (account.contains(ar.get(i))) {
                continue;
            }
            account.add(ar.get(i));
        }

        for (int i = 0; i < lenPr; i++) {
            if (p2pOrder.contains(pr.get(i))) {
                continue;
            }
            p2pOrder.add(pr.get(i));
        }
    }



    @RequestMapping("/purchasep2p")
    public ModelAndView purchasep2p() {
        initAccount();
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0x98333491efac02f8ce109b0c499074d47e7779a6.p12", "123456");
            Boolean str = sellSewageService.purchase_p2p(credentials);
            System.out.println("start");
            System.out.println(str);

            return new ModelAndView("Tiger", "tigerName", str);
        } catch (Exception e) {
            return new ModelAndView("404");
//        }
        }
    }
}
