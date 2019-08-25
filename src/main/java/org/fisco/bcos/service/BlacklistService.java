package org.fisco.bcos.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.tools.ant.taskdefs.Sleep;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.HelloWorld;
import org.fisco.bcos.contracts.Blacklist;
import org.fisco.bcos.tools.Utils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("blacklistService")
public class BlacklistService {
    @Autowired
    private Web3j web3j;

    private String blacklistAddress = "0x04241360c541e6e8362aab2c265d9764b93d30f8";

    public String deploy(Credentials credentials) throws Exception {
        Blacklist blacklist =
                Blacklist.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT)).send();
        return blacklist.getContractAddress();
    }

    public String addEenterprise(Credentials credentials, String enterprise, String enterpriseName,
                                 String enterpriseId, String illgalNum, String illgalRatio, String totalBalance)
            throws Exception {
        String output = "";
        try {
            Blacklist blacklist = Blacklist.load(blacklistAddress, web3j, credentials, new StaticGasProvider(
                    GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));

            if (blacklist != null) {
                // call set function
                output = blacklist.add(enterprise, enterpriseName, enterpriseId,
                        illgalNum, illgalRatio, totalBalance).send().getTransactionHash();
            }
        } catch (Exception e) {
            return output;
        }
        return output;
    }

    public Boolean testAdd(Credentials credentials) throws Exception {
        try {
            Blacklist blacklist = Blacklist.load(blacklistAddress, web3j, credentials, new StaticGasProvider(
                    GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));

            if (blacklist != null) {
                // call set function
                blacklist.add("0xf8a551eab66823c5847af6b43bc711b0f5314f41",
                        "test1", "001", "1",
                        "1%", "1000").send();
                blacklist.add("0xf77909567eac8e5b62dad93a0bb3d5d573d9b925",
                        "test2", "002", "2",
                        "2%", "2000").send();
                blacklist.add("0xf6aeac4e30c12eb3a69de72d089c07eaa380b3a0",
                        "test3", "003", "3",
                        "3%", "3000").send();
                blacklist.add("0xe9de21c5e7d74a7c27291acc7f8e7f126ab8d35c",
                        "test4", "004", "4",
                        "4%", "4000").send();
                blacklist.add("0xda196040650f5d1df12531366bc9f8423892081b",
                        "test5", "005", "5",
                        "5%", "5000").send();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String queryEenterprise(Credentials credentials) throws Exception {

        Blacklist blacklist = Blacklist.load(blacklistAddress, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));

        if (blacklist != null) {
            // call set function
            return blacklist.query("0xf8a551eab66823c5847af6b43bc711b0f5314f41").send();
        }
        return "";
    }

    public ArrayList<String> queryAllEenterprise(Credentials credentials) throws Exception {
        Blacklist blacklist = Blacklist.load(blacklistAddress, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        JSONObject blackAccountlist =
                Utils.readJsonObject("/home/xcrab/projects/FinTechathon/src/main/resources/data/blacklist.json");
        List<String> bc = JSON.parseArray(blackAccountlist.getJSONArray("Account").toJSONString(), String.class);

        ArrayList<String> output = new ArrayList<String>();

        for (String s : bc) {
            System.out.println(s);
            String result = blacklist.query(s).send();
            if (result != "") {
                output.add(result);
            }
        }
//        JSONObject newObject = new JSONObject();
//        newObject.put("Order", "ddd");
//        Utils.writeJsonFile("/home/xcrab/projects/FinTechathon/src/main/resources/data/p2p_order.json",
//                newObject.toJSONString());
        return output;
    }

}
