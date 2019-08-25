package org.fisco.bcos.service;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.AuctionSewage;
import org.fisco.bcos.tools.Utils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public class ContractInfoService {

    @Autowired
    private Web3j web3j;

    public String getAuctionContractInfo(Credentials credentials, int ledgerId){
        try {
            String contractAddr = Utils.find_contract(ledgerId);
            AuctionSewage auctionSewage = AuctionSewage.load(contractAddr, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            BigInteger ident = auctionSewage.ident().send();
            String owner = auctionSewage.owner().send();
            BigInteger auction_toklen = auctionSewage.auction_token().send();
            BigInteger auction_end = auctionSewage.auction_end().send();
            String highestBidder = auctionSewage.highestBidder().send();
            BigInteger higestBid = auctionSewage.highestBid().send();
            BigInteger deadline = auctionSewage.deadline().send();
            BigInteger bank_serials_number = auctionSewage.bank_serials_number().send();
            return "";

        }catch (Exception e){
            return "";
        }
    }


}
