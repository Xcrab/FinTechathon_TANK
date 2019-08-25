package org.fisco.bcos.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Blacklist extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506116f4806100606000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806316b3e6bb1461006757806329092d0e146100a45780634ec0b798146100e1578063d4fc9fc614610123575b600080fd5b34801561007357600080fd5b5061008e60048036036100899190810190611388565b610160565b60405161009b9190611504565b60405180910390f35b3480156100b057600080fd5b506100cb60048036036100c6919081019061135f565b6103af565b6040516100d89190611504565b60405180910390f35b3480156100ed57600080fd5b506101086004803603610103919081019061135f565b6104a1565b60405161011a96959493929190611541565b60405180910390f35b34801561012f57600080fd5b5061014a6004803603610145919081019061135f565b61086d565b604051610157919061151f565b60405180910390f35b600084600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000190805190602001906101b8929190611250565b5085600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101908051906020019061020f929190611250565b5083600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002019080519060200190610266929190611250565b5082600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060030190805190602001906102bd929190611250565b5081600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206004019080519060200190610314929190611250565b506040805190810160405280600181526020017f3000000000000000000000000000000000000000000000000000000000000000815250600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060050190805190602001906103a0929190611250565b50600190509695505050505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561040c57600080fd5b6040805190810160405280600181526020017f3100000000000000000000000000000000000000000000000000000000000000815250600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206005019080519060200190610497929190611250565b5060019050919050565b6001602052806000526040600020600091509050806000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561054d5780601f106105225761010080835404028352916020019161054d565b820191906000526020600020905b81548152906001019060200180831161053057829003601f168201915b505050505090806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105eb5780601f106105c0576101008083540402835291602001916105eb565b820191906000526020600020905b8154815290600101906020018083116105ce57829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106895780601f1061065e57610100808354040283529160200191610689565b820191906000526020600020905b81548152906001019060200180831161066c57829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107275780601f106106fc57610100808354040283529160200191610727565b820191906000526020600020905b81548152906001019060200180831161070a57829003601f168201915b505050505090806004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107c55780601f1061079a576101008083540402835291602001916107c5565b820191906000526020600020905b8154815290600101906020018083116107a857829003601f168201915b505050505090806005018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108635780601f1061083857610100808354040283529160200191610863565b820191906000526020600020905b81548152906001019060200180831161084657829003601f168201915b5050505050905086565b60608060608060608060006060806060806060600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109565780601f1061092b57610100808354040283529160200191610956565b820191906000526020600020905b81548152906001019060200180831161093957829003601f168201915b50505050509a50600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a335780601f10610a0857610100808354040283529160200191610a33565b820191906000526020600020905b815481529060010190602001808311610a1657829003601f168201915b50505050509950600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b105780601f10610ae557610100808354040283529160200191610b10565b820191906000526020600020905b815481529060010190602001808311610af357829003601f168201915b50505050509850600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bed5780601f10610bc257610100808354040283529160200191610bed565b820191906000526020600020905b815481529060010190602001808311610bd057829003601f168201915b50505050509750600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cca5780601f10610c9f57610100808354040283529160200191610cca565b820191906000526020600020905b815481529060010190602001808311610cad57829003601f168201915b50505050509650600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206005019550610d8b8b6040805190810160405280600181526020017f23000000000000000000000000000000000000000000000000000000000000008152508c6040805190810160405280600181526020017f2300000000000000000000000000000000000000000000000000000000000000815250610efc565b9450610dde858a6040805190810160405280600181526020017f23000000000000000000000000000000000000000000000000000000000000008152506020604051908101604052806000815250610efc565b9350610e3184896040805190810160405280600181526020017f23000000000000000000000000000000000000000000000000000000000000008152506020604051908101604052806000815250610efc565b9250610e8483886040805190810160405280600181526020017f23000000000000000000000000000000000000000000000000000000000000008152506020604051908101604052806000815250610efc565b9150610ee7826040805190810160405280600181526020017f300000000000000000000000000000000000000000000000000000000000000081525060206040519081016040528060008152506020604051908101604052806000815250610efc565b9050809b505050505050505050505050919050565b60608060608060608060606000808c97508b96508a95508994508451865188518a510101016040519080825280601f01601f191660200182016040528015610f535781602001602082028038833980820191505090505b50935083925060009150600090505b8751811015611015578781815181101515610f7957fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000028383806001019450815181101515610fd857fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508080600101915050610f62565b600090505b86518110156110cd57868181518110151561103157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561109057fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350808060010191505061101a565b600090505b85518110156111855785818151811015156110e957fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561114857fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535080806001019150506110d2565b600090505b845181101561123d5784818151811015156111a157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561120057fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350808060010191505061118a565b8398505050505050505050949350505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061129157805160ff19168380011785556112bf565b828001600101855582156112bf579182015b828111156112be5782518255916020019190600101906112a3565b5b5090506112cc91906112d0565b5090565b6112f291905b808211156112ee5760008160009055506001016112d6565b5090565b90565b60006113018235611647565b905092915050565b600082601f830112151561131c57600080fd5b813561132f61132a826115f9565b6115cc565b9150808252602083016020830185838301111561134b57600080fd5b611356838284611667565b50505092915050565b60006020828403121561137157600080fd5b600061137f848285016112f5565b91505092915050565b60008060008060008060c087890312156113a157600080fd5b60006113af89828a016112f5565b965050602087013567ffffffffffffffff8111156113cc57600080fd5b6113d889828a01611309565b955050604087013567ffffffffffffffff8111156113f557600080fd5b61140189828a01611309565b945050606087013567ffffffffffffffff81111561141e57600080fd5b61142a89828a01611309565b935050608087013567ffffffffffffffff81111561144757600080fd5b61145389828a01611309565b92505060a087013567ffffffffffffffff81111561147057600080fd5b61147c89828a01611309565b9150509295509295509295565b6114928161163b565b82525050565b60006114a382611630565b8084526114b7816020860160208601611676565b6114c0816116a9565b602085010191505092915050565b60006114d982611625565b8084526114ed816020860160208601611676565b6114f6816116a9565b602085010191505092915050565b60006020820190506115196000830184611489565b92915050565b600060208201905081810360008301526115398184611498565b905092915050565b600060c082019050818103600083015261155b81896114ce565b9050818103602083015261156f81886114ce565b9050818103604083015261158381876114ce565b9050818103606083015261159781866114ce565b905081810360808301526115ab81856114ce565b905081810360a08301526115bf81846114ce565b9050979650505050505050565b6000604051905081810181811067ffffffffffffffff821117156115ef57600080fd5b8060405250919050565b600067ffffffffffffffff82111561161057600080fd5b601f19601f8301169050602081019050919050565b600081519050919050565b600081519050919050565b60008115159050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b82818337600083830152505050565b60005b83811015611694578082015181840152602081019050611679565b838111156116a3576000848401525b50505050565b6000601f19601f83011690509190505600a265627a7a72305820b53c016465ac097f2162dcad9649345ab507715d85751e2e7f9da82fa727ca216c6578706572696d656e74616cf50037";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"_enterprise\",\"type\":\"address\"},{\"name\":\"_enterpriseName\",\"type\":\"string\"},{\"name\":\"_enterpriseId\",\"type\":\"string\"},{\"name\":\"_illegalNum\",\"type\":\"string\"},{\"name\":\"_illegalRatio\",\"type\":\"string\"},{\"name\":\"_totalBalance\",\"type\":\"string\"}],\"name\":\"add\",\"outputs\":[{\"name\":\"success\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"remove\",\"outputs\":[{\"name\":\"success\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"}],\"name\":\"illegalEnterprises\",\"outputs\":[{\"name\":\"enterpriseId\",\"type\":\"string\"},{\"name\":\"enterpriseName\",\"type\":\"string\"},{\"name\":\"illegalNum\",\"type\":\"string\"},{\"name\":\"illegalRatio\",\"type\":\"string\"},{\"name\":\"totalBalance\",\"type\":\"string\"},{\"name\":\"isDeleted\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_enterprise\",\"type\":\"address\"}],\"name\":\"query\",\"outputs\":[{\"name\":\"_info\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_REMOVE = "remove";

    public static final String FUNC_ILLEGALENTERPRISES = "illegalEnterprises";

    public static final String FUNC_QUERY = "query";

    @Deprecated
    protected Blacklist(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Blacklist(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Blacklist(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Blacklist(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> add(String _enterprise, String _enterpriseName, String _enterpriseId, String _illegalNum, String _illegalRatio, String _totalBalance) {
        final Function function = new Function(
                FUNC_ADD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_enterprise), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_enterpriseName), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_enterpriseId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_illegalNum), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_illegalRatio), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_totalBalance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void add(String _enterprise, String _enterpriseName, String _enterpriseId, String _illegalNum, String _illegalRatio, String _totalBalance, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_enterprise), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_enterpriseName), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_enterpriseId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_illegalNum), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_illegalRatio), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_totalBalance)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addSeq(String _enterprise, String _enterpriseName, String _enterpriseId, String _illegalNum, String _illegalRatio, String _totalBalance) {
        final Function function = new Function(
                FUNC_ADD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_enterprise), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_enterpriseName), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_enterpriseId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_illegalNum), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_illegalRatio), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_totalBalance)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> remove(String _entAddress) {
        final Function function = new Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_entAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void remove(String _entAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_entAddress)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String removeSeq(String _entAddress) {
        final Function function = new Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_entAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple6<String, String, String, String, String, String>> illegalEnterprises(String param0) {
        final Function function = new Function(FUNC_ILLEGALENTERPRISES, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple6<String, String, String, String, String, String>>(
                new Callable<Tuple6<String, String, String, String, String, String>>() {
                    @Override
                    public Tuple6<String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<String> query(String _enterprise) {
        final Function function = new Function(FUNC_QUERY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_enterprise)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Blacklist load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Blacklist(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Blacklist load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Blacklist(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Blacklist load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Blacklist(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Blacklist load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Blacklist(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Blacklist> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blacklist.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Blacklist> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blacklist.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Blacklist> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blacklist.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Blacklist> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blacklist.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
