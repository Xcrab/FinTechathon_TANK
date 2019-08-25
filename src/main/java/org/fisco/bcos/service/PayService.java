package org.fisco.bcos.service;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.AuctionSewage;
import org.fisco.bcos.contracts.B2CSewage;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.fisco.bcos.contracts.P2PSewage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.fisco.bcos.tools.Utils;

import java.math.BigInteger;

@Service("payService")
public class PayService {
    @Autowired
    private Web3j web3j;

    public Boolean p2p_pay(Credentials credentials, int ledgerId, int bank_serials_number){
        try {
            BigInteger Bbank_serials_number = BigInteger.valueOf(bank_serials_number);
            String p2pContractAddr = Utils.find_contract(ledgerId);
            P2PSewage p2PSewage = P2PSewage.load(p2pContractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            p2PSewage.purchase(Bbank_serials_number).send();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Boolean b2c_pay(Credentials credentials, int productId, int ledgerId, int bank_serials_number){
        try{
            BigInteger BledgerId = BigInteger.valueOf(ledgerId);
            BigInteger Bbank_serials_number = BigInteger.valueOf(bank_serials_number);
            String b2cContractAddr = Utils.find_product_contract(productId);
            B2CSewage b2CSewage = B2CSewage.load(b2cContractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            b2CSewage.purchase_phase2(BledgerId, Bbank_serials_number);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Boolean auction_pay(Credentials credentials, int ledgerId, int bank_serials_number){
        try{
            BigInteger Bbank_serials_number = BigInteger.valueOf(bank_serials_number);
            String auctionContractAddr = Utils.find_contract(ledgerId);
            AuctionSewage auctionSewage = AuctionSewage.load(auctionContractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            auctionSewage.pay(Bbank_serials_number);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
