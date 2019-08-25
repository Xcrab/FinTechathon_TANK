package org.fisco.bcos.service;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.P2PSewage;
import org.fisco.bcos.contracts.B2CSewage;
import org.fisco.bcos.contracts.AuctionSewage;
import org.fisco.bcos.contracts.TokenSewage;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("sellSewageService")
public class SellSewageService {
    @Autowired
    private Web3j web3j;

    private String sewageTokenAddr = "0xc7e53b09d0aed9256ff79165a37806dff1150755";

    public String[] p2psell(Credentials credentials, int ledgerId, String address, int sewage_token, int price) {
        P2PSewage p2PSewage = null;

        try {
            BigInteger BledgerId = BigInteger.valueOf(ledgerId);
            BigInteger Bsewage_token = BigInteger.valueOf(sewage_token);
            BigInteger Bprice = BigInteger.valueOf(price);
            p2PSewage = P2PSewage.deploy(web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT),
                    sewageTokenAddr, BledgerId, Bprice).send();
            System.out.println("p2p");
            System.out.println(p2PSewage.getContractAddress());
            System.out.println("ledgerId");
            System.out.println(ledgerId);
            TokenSewage tokenSewage = TokenSewage.load(sewageTokenAddr, web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            tokenSewage.approve(p2PSewage.getContractAddress(), Bsewage_token).send();
            p2PSewage.sell(address, Bsewage_token).send();
        } catch (Exception e) {
            return null;
        }
        String[] output = new String[2];
        output[0] = p2PSewage.getContractAddress();
        output[1] = p2PSewage.getTransactionReceipt().get().getTransactionHash();
        return output;
    }

    public Boolean b2csell(Credentials credentials, int sewage_token) {
        try {
            BigInteger Bsewage_token = BigInteger.valueOf(sewage_token);
            B2CSewage b2CSewage = B2CSewage.deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), sewageTokenAddr).send();
            TokenSewage tokenSewage = TokenSewage.load(sewageTokenAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            tokenSewage.approve(b2CSewage.getContractAddress(), Bsewage_token).send();
            b2CSewage.sell(Bsewage_token).send();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean autcion_start(Credentials credentials, int sewage_token, int bid_time) {
        try {
            BigInteger Bsewage_token = BigInteger.valueOf(sewage_token);
            BigInteger Bbid_time = BigInteger.valueOf(bid_time);
            AuctionSewage auctionSewage = AuctionSewage.deploy(web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT)).send();
            TokenSewage tokenSewage = TokenSewage.load(sewageTokenAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            tokenSewage.approve(auctionSewage.getContractAddress(), Bsewage_token).send();
            auctionSewage.start_auction(Bsewage_token, Bbid_time).send();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean purchase_p2p(Credentials credentials) throws Exception {
        try {
            P2PSewage p2PSewage = P2PSewage.load("0x558124ebfd2deffd7cd25bc00fa9634fef791d3f",
                    web3j,
                    credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            p2PSewage.purchase(new BigInteger("12345")).send();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
