package org.fisco.bcos.service;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.AuctionSewage;
import org.fisco.bcos.contracts.B2CSewage;
import org.fisco.bcos.tools.Utils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("orderService")
public class OrderService {
    @Autowired
    private Web3j web3j;

    public boolean bid(Credentials credentials, int ledgerId, int value) {
        try {
            BigInteger Bvalue = BigInteger.valueOf(value);
            String auctionContractAddr = Utils.find_contract(ledgerId);
            AuctionSewage auctionSewage = AuctionSewage.load(auctionContractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            auctionSewage.bid(Bvalue);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean order(Credentials credentials, int productId, int ledgerId, int sewage_token) {
        try {
            String contractAddr = Utils.find_product_contract(productId);
            BigInteger BledgerId = BigInteger.valueOf(ledgerId);
            BigInteger Bsewage_token = BigInteger.valueOf(sewage_token);
            B2CSewage b2CSewage = B2CSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            b2CSewage.purchase_phase1(BledgerId, Bsewage_token).send();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
