package org.fisco.bcos.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.request.BcosFilter;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class P2PSewage extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516060806109d083398101806040528101908080519060200190929190805190602001909291908051906020019092919050505033600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550826000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060068190555062093a804201600281905550816001819055505050506108dc806100f46000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806329dcb0cf1461009e5780635eb8c0e2146100c95780636c197ff5146100f45780637150d8ae146101415780638da5cb5b146101985780639fe8a3df146101ef578063a035b1fe14610206578063af3066bc14610231578063efef39a11461025c575b600080fd5b3480156100aa57600080fd5b506100b3610289565b6040518082815260200191505060405180910390f35b3480156100d557600080fd5b506100de61028f565b6040518082815260200191505060405180910390f35b34801561010057600080fd5b5061013f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610295565b005b34801561014d57600080fd5b506101566104cb565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101a457600080fd5b506101ad6104f1565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101fb57600080fd5b50610204610517565b005b34801561021257600080fd5b5061021b6106bc565b6040518082815260200191505060405180910390f35b34801561023d57600080fd5b506102466106c2565b6040518082815260200191505060405180910390f35b34801561026857600080fd5b50610287600480360381019080803590602001909291905050506106c8565b005b60025481565b60075481565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156102f157600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b1580156103e957600080fd5b505af11580156103fd573d6000803e3d6000fd5b505050506040513d602081101561041357600080fd5b8101908080519060200190929190505050151561042f57600080fd5b600060085414151561044057600080fd5b81600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600581905550600160086000828254019250508190555060007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a25050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561057357600080fd5b600160085414151561058457600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ccb1b30600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166005546040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561066c57600080fd5b505af1158015610680573d6000803e3d6000fd5b505050506040513d602081101561069657600080fd5b810190808051906020019092919050505015156106b257600080fd5b6003600881905550565b60065481565b60055481565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561072457600080fd5b6001600854148061073757506002600854145b151561074257600080fd5b60006007541415151561075457600080fd5b4260025410151561076457600080fd5b806007819055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ccb1b30336005546040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561083157600080fd5b505af1158015610845573d6000803e3d6000fd5b505050506040513d602081101561085b57600080fd5b8101908080519060200190929190505050151561087757600080fd5b600260088190555060017f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a2505600a165627a7a72305820353fdd7a76bae05d321a1aece90f391ce5e77ac55ff086c9f7d58588dbbe9a940029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"deadline\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"bank_serials_number\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_buyer\",\"type\":\"address\"},{\"name\":\"_sewage_token\",\"type\":\"uint256\"}],\"name\":\"sell\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"buyer\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"owner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"interrupt_sell\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"price\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"sewage_token\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_bank_serials_number\",\"type\":\"uint256\"}],\"name\":\"purchase\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_tokenSewage\",\"type\":\"address\"},{\"name\":\"_ident\",\"type\":\"uint256\"},{\"name\":\"_value\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"t\",\"type\":\"uint256\"}],\"name\":\"Transaction_msg\",\"type\":\"event\"}]";

    public static final String FUNC_DEADLINE = "deadline";

    public static final String FUNC_BANK_SERIALS_NUMBER = "bank_serials_number";

    public static final String FUNC_SELL = "sell";

    public static final String FUNC_BUYER = "buyer";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_INTERRUPT_SELL = "interrupt_sell";

    public static final String FUNC_PRICE = "price";

    public static final String FUNC_SEWAGE_TOKEN = "sewage_token";

    public static final String FUNC_PURCHASE = "purchase";

    public static final Event TRANSACTION_MSG_EVENT = new Event("Transaction_msg", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected P2PSewage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected P2PSewage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected P2PSewage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected P2PSewage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> deadline() {
        final Function function = new Function(FUNC_DEADLINE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> bank_serials_number() {
        final Function function = new Function(FUNC_BANK_SERIALS_NUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> sell(String _buyer, BigInteger _sewage_token) {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(new Address(_buyer),
                new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void sell(String _buyer, BigInteger _sewage_token, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(new Address(_buyer),
                new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String sellSeq(String _buyer, BigInteger _sewage_token) {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(new Address(_buyer),
                new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<String> buyer() {
        final Function function = new Function(FUNC_BUYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> interrupt_sell() {
        final Function function = new Function(
                FUNC_INTERRUPT_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void interrupt_sell(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INTERRUPT_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String interrupt_sellSeq() {
        final Function function = new Function(
                FUNC_INTERRUPT_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<BigInteger> price() {
        final Function function = new Function(FUNC_PRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> sewage_token() {
        final Function function = new Function(FUNC_SEWAGE_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> purchase(BigInteger _bank_serials_number) {
        final Function function = new Function(
                FUNC_PURCHASE, 
                Arrays.<Type>asList(new Uint256(_bank_serials_number)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void purchase(BigInteger _bank_serials_number, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PURCHASE, 
                Arrays.<Type>asList(new Uint256(_bank_serials_number)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String purchaseSeq(BigInteger _bank_serials_number) {
        final Function function = new Function(
                FUNC_PURCHASE, 
                Arrays.<Type>asList(new Uint256(_bank_serials_number)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public List<Transaction_msgEventResponse> getTransaction_msgEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSACTION_MSG_EVENT, transactionReceipt);
        ArrayList<Transaction_msgEventResponse> responses = new ArrayList<Transaction_msgEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            Transaction_msgEventResponse typedResponse = new Transaction_msgEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.t = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<Transaction_msgEventResponse> transaction_msgEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, Transaction_msgEventResponse>() {
            @Override
            public Transaction_msgEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSACTION_MSG_EVENT, log);
                Transaction_msgEventResponse typedResponse = new Transaction_msgEventResponse();
                typedResponse.log = log;
                typedResponse.t = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<Transaction_msgEventResponse> transaction_msgEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSACTION_MSG_EVENT));
        return transaction_msgEventFlowable(filter);
    }

    @Deprecated
    public static P2PSewage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new P2PSewage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static P2PSewage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new P2PSewage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static P2PSewage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new P2PSewage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static P2PSewage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new P2PSewage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<P2PSewage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _tokenSewage, BigInteger _ident, BigInteger _value) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage),
                new Uint256(_ident),
                new Uint256(_value)));
        return deployRemoteCall(P2PSewage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<P2PSewage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _tokenSewage, BigInteger _ident, BigInteger _value) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage),
                new Uint256(_ident),
                new Uint256(_value)));
        return deployRemoteCall(P2PSewage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<P2PSewage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _tokenSewage, BigInteger _ident, BigInteger _value) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage),
                new Uint256(_ident),
                new Uint256(_value)));
        return deployRemoteCall(P2PSewage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<P2PSewage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _tokenSewage, BigInteger _ident, BigInteger _value) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage),
                new Uint256(_ident),
                new Uint256(_value)));
        return deployRemoteCall(P2PSewage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class Transaction_msgEventResponse {
        public Log log;

        public BigInteger t;
    }
}
