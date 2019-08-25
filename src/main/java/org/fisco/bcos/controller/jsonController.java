package org.fisco.bcos.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.fisco.bcos.tools.Utils;
import org.fisco.bcos.autoconfigure.AccountConfig;
import org.fisco.bcos.service.*;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
public class jsonController {

    @Autowired
    SellSewageService sellSewageService;

    @Autowired
    BlacklistService blacklistService;

    @Autowired
    TokenSewageService tokenSewageService;

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

    @RequestMapping("/jsonTest")
    public String jsonTest() {
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "ok");
        result.put("data", "ok");
        return result.toJSONString();
    }

    @RequestMapping("/myp2p")
    public String myp2p() {

        JSONObject p2pOrderNumber = Utils.readJsonObject("/home/xcrab/projects/FinTechathon/src/main/resources/data/p2p_order_number.json");
        int no = p2pOrderNumber.getIntValue("p2p_order_number");

        initAccount();
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0x98333491efac02f8ce109b0c499074d47e7779a6.p12", "123456");
            String[] getData = sellSewageService.p2psell(
                    credentials,
                    no,
                    account.get(0),
                    20,
                    20
            );
            if (getData[0] != "") {
                p2pOrder.add(getData[0]);
                no++;
            } else {
                assert (false);
            }

            JSONObject newObject = new JSONObject();
            newObject.put("Order", p2pOrder);
            Utils.writeJsonFile("/home/xcrab/projects/FinTechathon/src/main/resources/data/p2p_order.json",
                    newObject.toJSONString());

            JSONObject outputObject = new JSONObject();
            outputObject.put("address", getData[0]);
            outputObject.put("hash", getData[1]);

            return outputObject.toJSONString();
        } catch (Exception e) {
            return "";
        }
    }

    @RequestMapping("testqueryAllEenterprise")
    public String testqueryAllEenterprise() throws Exception {
        Credentials credentials =
                accountConfig.setp12Account("accounts/0xa1f2bdeaa430c05dda9375ebf53218d03993a72a.p12", "123456");
        ArrayList<String> output = blacklistService.queryAllEenterprise(credentials);

        int len = output.size();
        JSONArray arr = new JSONArray();
        //001#test1#1#1%#1000#0
        for (int i = 0; i < len; i++) {
            String[] splitResult = output.get(i).split("#");
//            JSONObject newObject = new JSONObject();
//            newObject.put(String.valueOf(i),splitResult);
//            arr.add(newObject);
            arr.add(splitResult);
        }
        System.out.println(arr.toJSONString());
        return arr.toJSONString();
    }

    @RequestMapping("/initSewage")
    public String initSewage() {
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0x98333491efac02f8ce109b0c499074d47e7779a6.p12", "123456");
            String str = tokenSewageService.deployTokenSewage(credentials);
            System.out.println("start");
            System.out.println(str);
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    @RequestMapping("/initAllSewage")
    public String initAllSewage() {
        try {
            Credentials credentials = accountConfig.setp12Account("accounts/0x98333491efac02f8ce109b0c499074d47e7779a6.p12", "123456");
            String str = tokenSewageService.initAllSewage(credentials);
            System.out.println("start");
            System.out.println(str);
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    @RequestMapping("one_transaction")
    public String one_transaction() {
        try {
            Credentials credentials =
                    accountConfig.setp12Account("accounts/0x98333491efac02f8ce109b0c499074d47e7779a6.p12", "123456");
            String output = blacklistService.addEenterprise(credentials, "100", "test",
                    "2000", "10", "1%", "10000");
            System.out.println(output);

            JSONObject outputObject = new JSONObject();
            outputObject.put("hash", output);
            return outputObject.toJSONString();
        } catch (Exception e) {
            return "";
        }

    }

}
