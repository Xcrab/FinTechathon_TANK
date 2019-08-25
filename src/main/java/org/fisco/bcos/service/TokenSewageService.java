package org.fisco.bcos.service;

import java.math.BigInteger;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.TokenSewage;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tokenSewageService")
public class TokenSewageService {
    @Autowired
    private Web3j web3j;

    private String tokenSewageAddress = "0xc7e53b09d0aed9256ff79165a37806dff1150755";

    private String[] accounts = {
            "0xf4b9d492d4d346053eeee9d97228e120397e37ec",
            "0xfff9f5c55f5832924d9d61435a0884acfbefd9d1",
            "0xd951d22dd38c4a70c447e51357e366d8c0e35a02",
            "0xe5b3d553a26aa9b6043ca64fafcc6ce8ded043f1",
            "0xf8d266596c934073ac0435fe508f4448ee1e460b"
    };

    public String deployTokenSewage(Credentials credentials) throws Exception {
        TokenSewage tokenSewage =
                TokenSewage.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT),
                        new BigInteger("1000000"),
                        "testName",
                        "testSymbol").send();

        if (tokenSewage != null) {
            return tokenSewage.getContractAddress();
        }
        return "";
    }

    public String initAllSewage(Credentials credentials) throws Exception {
        TokenSewage tokenSewage =
                TokenSewage.load(
                        tokenSewageAddress, web3j,
                        credentials,
                        new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));

        // 初始化分配合约金额
        for (String ac : accounts) {
            tokenSewage.transferTo(ac, new BigInteger("1000")).send();
        }

        // 查询合约余额
        for (String ac : accounts) {
            BigInteger ba = tokenSewage.balanceOf(ac).send();
            System.out.println(ac);
            System.out.println(ba);
        }

        //总量有多少
        BigInteger total = tokenSewage.balanceOf("0x98333491efac02f8ce109b0c499074d47e7779a6").send();
        System.out.println("total");
        System.out.println(total);

        if (tokenSewage != null) {
            return tokenSewage.getContractAddress();
        }
        return "";
    }
}
