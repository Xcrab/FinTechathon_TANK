package org.fisco.bcos.service;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.AuctionSewage;
import org.fisco.bcos.contracts.B2CSewage;
import org.fisco.bcos.contracts.P2PSewage;
import org.fisco.bcos.tools.Utils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("interuptService")
public class InteruptService {

    @Autowired
    private Web3j web3j;

    public boolean p2p_seller(Credentials credentials, int ledgerId){
        try{
            String contractAddr = Utils.find_contract(ledgerId);
            P2PSewage p2PSewage = P2PSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            p2PSewage.interrupt_sell().send();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean b2c_seller(Credentials credentials, int productId){
        try{
            String contractAddr = Utils.find_product_contract(productId);
            B2CSewage b2CSewage = B2CSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            b2CSewage.interrupt_sell().send();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean b2c_buyer(Credentials credentials, int productId, int ledgerId){
        try{
            String contractAddr = Utils.find_product_contract(productId);
            B2CSewage b2CSewage = B2CSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            BigInteger BledgerId = BigInteger.valueOf(ledgerId);
            b2CSewage.interrupt_order(BledgerId).send();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean b2c_deadline(Credentials credentials, int productId, String buyer, int ledgerId){
        try{
            String contractAddr = Utils.find_product_contract(productId);
            B2CSewage b2CSewage = B2CSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            BigInteger BledgerId = BigInteger.valueOf(ledgerId);
            b2CSewage.interrupt_deadline(buyer, BledgerId).send();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean auction_refund(Credentials credentials, int productId){
        try{
            String contractAddr = Utils.find_product_contract(productId);
            AuctionSewage auctionSewage = AuctionSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            auctionSewage.refund().send();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
