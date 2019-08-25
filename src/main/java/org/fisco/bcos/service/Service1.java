package org.fisco.bcos.service;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.HelloWorld;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class Service1 {

    @Autowired
    private Web3j web3j;


    public String deployAndCallHelloWorld(Credentials credentials) throws Exception {
        // deploy contract
        HelloWorld helloWorld =
                HelloWorld.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                        .send();
        if (helloWorld != null) {
            // call set function
            helloWorld.set("Hello, World!").send();
            // call get function
            return helloWorld.getContractAddress() + ' ' + helloWorld.get().send();
        }
        return "";
    }

}
