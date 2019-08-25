package org.fisco.bcos.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
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
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
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
public class B2CSewage extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051602080610f718339810180604052810190808051906020019092919050505033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610ead806100c46000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631090d450146100b457806367d33d06146100df578063735d50fa1461010a57806389c3bb9f146101415780638da5cb5b146101a657806396580290146101fd5780639fe8a3df14610234578063a0e6f5d31461024b578063af3066bc146102c5578063c2b25ded146102f0578063e4849b321461031d575b600080fd5b3480156100c057600080fd5b506100c961034a565b6040518082815260200191505060405180910390f35b3480156100eb57600080fd5b506100f4610350565b6040518082815260200191505060405180910390f35b34801561011657600080fd5b5061013f6004803603810190808035906020019092919080359060200190929190505050610356565b005b34801561014d57600080fd5b5061018c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506105bc565b604051808215151515815260200191505060405180910390f35b3480156101b257600080fd5b506101bb6106fd565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561020957600080fd5b506102326004803603810190808035906020019092919080359060200190929190505050610723565b005b34801561024057600080fd5b50610249610854565b005b34801561025757600080fd5b50610296600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610aee565b604051808581526020018481526020018381526020018215151515815260200194505050505060405180910390f35b3480156102d157600080fd5b506102da610b38565b6040518082815260200191505060405180910390f35b3480156102fc57600080fd5b5061031b60048036038101908080359060200190929190505050610b3e565b005b34801561032957600080fd5b5061034860048036038101908080359060200190929190505050610ca0565b005b60055481565b60045481565b600160065414151561036757600080fd5b42600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600084815260200190815260200160002060020154101580156103ca5750600081115b15156103d557600080fd5b80600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000848152602001908152602001600020600101819055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ccb1b3033600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000868152602001908152602001600020600001546040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561054457600080fd5b505af1158015610558573d6000803e3d6000fd5b505050506040513d602081101561056e57600080fd5b8101908080519060200190929190505050151561058a57600080fd5b60007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a25050565b600060016006541415156105cf57600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561062b57600080fd5b42600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008481526020019081526020016000206002015410156106f257600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600083815260200190815260200160002060000154600560008282540192505081905550600190506106f7565b600090505b92915050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160065414151561073457600080fd5b600060055411151561074557600080fd5b806005541015151561075657600080fd5b806005600082825403925050819055506080604051908101604052808281526020016000815260200162093a804201815260200160001515815250600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600084815260200190815260200160002060008201518160000155602082015181600101556040820151816002015560608201518160030160006101000a81548160ff02191690831515021790555090505060007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a25050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156108b257600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561096e57600080fd5b505af1158015610982573d6000803e3d6000fd5b505050506040513d602081101561099857600080fd5b810190808051906020019092919050505090506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ccb1b3033836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b158015610a6f57600080fd5b505af1158015610a83573d6000803e3d6000fd5b505050506040513d6020811015610a9957600080fd5b81019080805190602001909291905050501515610ab557600080fd5b600260068190555060007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a250565b6002602052816000526040600020602052806000526040600020600091509150508060000154908060010154908060020154908060030160009054906101000a900460ff16905084565b60035481565b42600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008381526020019081526020016000206002015410151515610ba057600080fd5b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828152602001908152602001600020600001546005600082825401925050819055506001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600083815260200190815260200160002060030160006101000a81548160ff02191690831515021790555060007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a250565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610cfc57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015610df457600080fd5b505af1158015610e08573d6000803e3d6000fd5b505050506040513d6020811015610e1e57600080fd5b81019080805190602001909291905050501515610e3a57600080fd5b8060038190555080600581905550600160068190555060007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a2505600a165627a7a7230582068776ab69bc26cc63f0a2ce81050e807b1ecfb449c123f2be7f6960e875533490029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"remaining_sewage_token\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"unit_price\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ledger_id\",\"type\":\"uint256\"},{\"name\":\"_bank_serials_number\",\"type\":\"uint256\"}],\"name\":\"purchase_phase2\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_buyer\",\"type\":\"address\"},{\"name\":\"ledger_id\",\"type\":\"uint256\"}],\"name\":\"interrupt_deadline\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"owner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ledger_id\",\"type\":\"uint256\"},{\"name\":\"_sewage_token\",\"type\":\"uint256\"}],\"name\":\"purchase_phase1\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"interrupt_sell\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"buyers\",\"outputs\":[{\"name\":\"sewage_token\",\"type\":\"uint256\"},{\"name\":\"bank_serials_number\",\"type\":\"uint256\"},{\"name\":\"deadline\",\"type\":\"uint256\"},{\"name\":\"flag\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"sewage_token\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ledger_id\",\"type\":\"uint256\"}],\"name\":\"interrupt_order\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_sewage_token\",\"type\":\"uint256\"}],\"name\":\"sell\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_tokenSewage\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"t\",\"type\":\"uint256\"}],\"name\":\"Transaction_msg\",\"type\":\"event\"}]";

    public static final String FUNC_REMAINING_SEWAGE_TOKEN = "remaining_sewage_token";

    public static final String FUNC_UNIT_PRICE = "unit_price";

    public static final String FUNC_PURCHASE_PHASE2 = "purchase_phase2";

    public static final String FUNC_INTERRUPT_DEADLINE = "interrupt_deadline";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PURCHASE_PHASE1 = "purchase_phase1";

    public static final String FUNC_INTERRUPT_SELL = "interrupt_sell";

    public static final String FUNC_BUYERS = "buyers";

    public static final String FUNC_SEWAGE_TOKEN = "sewage_token";

    public static final String FUNC_INTERRUPT_ORDER = "interrupt_order";

    public static final String FUNC_SELL = "sell";

    public static final Event TRANSACTION_MSG_EVENT = new Event("Transaction_msg", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected B2CSewage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected B2CSewage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected B2CSewage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected B2CSewage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> remaining_sewage_token() {
        final Function function = new Function(FUNC_REMAINING_SEWAGE_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> unit_price() {
        final Function function = new Function(FUNC_UNIT_PRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> purchase_phase2(BigInteger ledger_id, BigInteger _bank_serials_number) {
        final Function function = new Function(
                FUNC_PURCHASE_PHASE2, 
                Arrays.<Type>asList(new Uint256(ledger_id),
                new Uint256(_bank_serials_number)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void purchase_phase2(BigInteger ledger_id, BigInteger _bank_serials_number, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PURCHASE_PHASE2, 
                Arrays.<Type>asList(new Uint256(ledger_id),
                new Uint256(_bank_serials_number)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String purchase_phase2Seq(BigInteger ledger_id, BigInteger _bank_serials_number) {
        final Function function = new Function(
                FUNC_PURCHASE_PHASE2, 
                Arrays.<Type>asList(new Uint256(ledger_id),
                new Uint256(_bank_serials_number)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> interrupt_deadline(String _buyer, BigInteger ledger_id) {
        final Function function = new Function(
                FUNC_INTERRUPT_DEADLINE, 
                Arrays.<Type>asList(new Address(_buyer),
                new Uint256(ledger_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void interrupt_deadline(String _buyer, BigInteger ledger_id, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INTERRUPT_DEADLINE, 
                Arrays.<Type>asList(new Address(_buyer),
                new Uint256(ledger_id)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String interrupt_deadlineSeq(String _buyer, BigInteger ledger_id) {
        final Function function = new Function(
                FUNC_INTERRUPT_DEADLINE, 
                Arrays.<Type>asList(new Address(_buyer),
                new Uint256(ledger_id)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> purchase_phase1(BigInteger ledger_id, BigInteger _sewage_token) {
        final Function function = new Function(
                FUNC_PURCHASE_PHASE1, 
                Arrays.<Type>asList(new Uint256(ledger_id),
                new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void purchase_phase1(BigInteger ledger_id, BigInteger _sewage_token, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PURCHASE_PHASE1, 
                Arrays.<Type>asList(new Uint256(ledger_id),
                new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String purchase_phase1Seq(BigInteger ledger_id, BigInteger _sewage_token) {
        final Function function = new Function(
                FUNC_PURCHASE_PHASE1, 
                Arrays.<Type>asList(new Uint256(ledger_id),
                new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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

    public RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, Boolean>> buyers(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_BUYERS, 
                Arrays.<Type>asList(new Address(param0),
                new Uint256(param1)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, Boolean>>(
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> sewage_token() {
        final Function function = new Function(FUNC_SEWAGE_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> interrupt_order(BigInteger ledger_id) {
        final Function function = new Function(
                FUNC_INTERRUPT_ORDER, 
                Arrays.<Type>asList(new Uint256(ledger_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void interrupt_order(BigInteger ledger_id, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INTERRUPT_ORDER, 
                Arrays.<Type>asList(new Uint256(ledger_id)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String interrupt_orderSeq(BigInteger ledger_id) {
        final Function function = new Function(
                FUNC_INTERRUPT_ORDER, 
                Arrays.<Type>asList(new Uint256(ledger_id)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> sell(BigInteger _sewage_token) {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void sell(BigInteger _sewage_token, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(new Uint256(_sewage_token)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String sellSeq(BigInteger _sewage_token) {
        final Function function = new Function(
                FUNC_SELL, 
                Arrays.<Type>asList(new Uint256(_sewage_token)),
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
    public static B2CSewage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new B2CSewage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static B2CSewage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new B2CSewage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static B2CSewage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new B2CSewage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static B2CSewage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new B2CSewage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<B2CSewage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _tokenSewage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage)));
        return deployRemoteCall(B2CSewage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<B2CSewage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _tokenSewage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage)));
        return deployRemoteCall(B2CSewage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<B2CSewage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _tokenSewage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage)));
        return deployRemoteCall(B2CSewage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<B2CSewage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _tokenSewage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_tokenSewage)));
        return deployRemoteCall(B2CSewage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class Transaction_msgEventResponse {
        public Log log;

        public BigInteger t;
    }
}
