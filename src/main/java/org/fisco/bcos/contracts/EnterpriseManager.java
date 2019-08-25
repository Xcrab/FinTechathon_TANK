package org.fisco.bcos.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
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
public class EnterpriseManager extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061197f806100206000396000f3006080604052600436106100a4576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633c7a28ed146100a95780634d31be53146101905780634e63c021146102bf578063708877f5146103a25780637d1b24db1461040f578063902e11b61461046a5780639124f398146105d7578063ae2c69da1461071c578063cd68248a14610777578063e0a7928e146107d2575b600080fd5b3480156100b557600080fd5b50610176600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506107fd565b604051808215151515815260200191505060405180910390f35b34801561019c57600080fd5b506101d1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c4b565b604051808060200180602001848152602001838103835286818151815260200191508051906020019080838360005b8381101561021b578082015181840152602081019050610200565b50505050905090810190601f1680156102485780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b83811015610281578082015181840152602081019050610266565b50505050905090810190601f1680156102ae5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b3480156102cb57600080fd5b5061038c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610edd565b6040518082815260200191505060405180910390f35b3480156103ae57600080fd5b506103cd600480360381019080803590602001909291905050506111ad565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561041b57600080fd5b50610450600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506111eb565b604051808215151515815260200191505060405180910390f35b34801561047657600080fd5b506104ab600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611269565b604051808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018060200185815260200184151515158152602001838103835287818151815260200191508051906020019080838360005b83811015610531578082015181840152602081019050610516565b50505050905090810190601f16801561055e5780820380516001836020036101000a031916815260200191505b50838103825286818151815260200191508051906020019080838360005b8381101561059757808201518184015260208101905061057c565b50505050905090810190601f1680156105c45780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b3480156105e357600080fd5b50610602600480360381019080803590602001909291905050506113fc565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b8381101561067857808201518184015260208101905061065d565b50505050905090810190601f1680156106a55780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156106de5780820151818401526020810190506106c3565b50505050905090810190601f16801561070b5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561072857600080fd5b5061075d600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506116fc565b604051808215151515815260200191505060405180910390f35b34801561078357600080fd5b506107b8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506117d8565b604051808215151515815260200191505060405180910390f35b3480156107de57600080fd5b506107e76118a1565b6040518082815260200191505060405180910390f35b60006001151561080c856117d8565b1515141515610883576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f456e7465727072697365206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b60405160200180807f6e616d650000000000000000000000000000000000000000000000000000000081525060040190506040516020818303038152906040526040518082805190602001908083835b6020831015156108f857805182526020820191506020810190506020830392506108d3565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916836040516020018082805190602001908083835b602083101515610962578051825260208201915060208101905060208303925061093d565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b6020831015156109cb57805182526020820191506020810190506020830392506109a6565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019161415610a6157816000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001019080519060200190610a579291906118ae565b5060019050610c44565b60405160200180807f7265616c6964000000000000000000000000000000000000000000000000000081525060060190506040516020818303038152906040526040518082805190602001908083835b602083101515610ad65780518252602082019150602081019050602083039250610ab1565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916836040516020018082805190602001908083835b602083101515610b405780518252602082019150602081019050602083039250610b1b565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b602083101515610ba95780518252602082019150602081019050602083039250610b84565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019161415610c3f57816000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002019080519060200190610c359291906118ae565b5060019050610c44565b600090505b9392505050565b606080600060011515610c5d856117d8565b1515141515610cd4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f456e7465727072697365206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b6000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001016000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002016000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060030154828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e2d5780601f10610e0257610100808354040283529160200191610e2d565b820191906000526020600020905b815481529060010190602001808311610e1057829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ec95780601f10610e9e57610100808354040283529160200191610ec9565b820191906000526020600020905b815481529060010190602001808311610eac57829003601f168201915b505050505091509250925092509193909250565b600060011515610eec856117d8565b1515141515610f63576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f456e7465727072697365206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b60018490806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050836000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550826000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101908051906020019061109e9291906118ae565b50816000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020190805190602001906110f49291906118ae565b5060018080549050036000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018190555060008060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160006101000a81548160ff021916908315150217905550600180805490500390509392505050565b6001818154811015156111bc57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60006111f6826117d8565b15156112055760009050611264565b60016000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160006101000a81548160ff021916908315150217905550600190505b919050565b60006020528060005260406000206000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561133b5780601f106113105761010080835404028352916020019161133b565b820191906000526020600020905b81548152906001019060200180831161131e57829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113d95780601f106113ae576101008083540402835291602001916113d9565b820191906000526020600020905b8154815290600101906020018083116113bc57829003601f168201915b5050505050908060030154908060040160009054906101000a900460ff16905085565b6000606080600084108061141557506001805490508410155b1515611489576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f696e646578206973206f7574206f662072616e6765000000000000000000000081525060200191505060405180910390fd5b60018481548110151561149857fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000806001878154811015156114d557fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160008060018881548110151561154f57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201818054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561164c5780601f106116215761010080835404028352916020019161164c565b820191906000526020600020905b81548152906001019060200180831161162f57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116e85780601f106116bd576101008083540402835291602001916116e8565b820191906000526020600020905b8154815290600101906020018083116116cb57829003601f168201915b505050505090509250925092509193909250565b60006001151561170b836117d8565b1515141515611782576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f456e7465727072697365206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b6000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040160009054906101000a900460ff169050919050565b60008060018054905014156117f0576000905061189c565b8173ffffffffffffffffffffffffffffffffffffffff1660016000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003015481548110151561185757fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b919050565b6000600180549050905090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106118ef57805160ff191683800117855561191d565b8280016001018555821561191d579182015b8281111561191c578251825591602001919060010190611901565b5b50905061192a919061192e565b5090565b61195091905b8082111561194c576000816000905550600101611934565b5090565b905600a165627a7a7230582079a7d032cdde025eccb10490fba94968190714672502aca0c7bd8596d2f8552c0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"_entAddress\",\"type\":\"address\"},{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"string\"}],\"name\":\"UpdateEnterprise\",\"outputs\":[{\"name\":\"success\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"GetEnterprise\",\"outputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"realid\",\"type\":\"string\"},{\"name\":\"index\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_entAddress\",\"type\":\"address\"},{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_realid\",\"type\":\"string\"}],\"name\":\"AddEnterprise\",\"outputs\":[{\"name\":\"index\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"enterpriseAddresses\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"DeleteEnterprise\",\"outputs\":[{\"name\":\"isSuccess\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"}],\"name\":\"enterprises\",\"outputs\":[{\"name\":\"enterpriseAddress\",\"type\":\"address\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"realid\",\"type\":\"string\"},{\"name\":\"index\",\"type\":\"uint256\"},{\"name\":\"isdeleted\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"GetEnterpriseByIndex\",\"outputs\":[{\"name\":\"entAddress\",\"type\":\"address\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"realid\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"IsDeleted\",\"outputs\":[{\"name\":\"isDeleted\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_enterAddress\",\"type\":\"address\"}],\"name\":\"IsExitAddress\",\"outputs\":[{\"name\":\"isExited\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"GetEnterpriseCount\",\"outputs\":[{\"name\":\"count\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]";

    public static final String FUNC_UPDATEENTERPRISE = "UpdateEnterprise";

    public static final String FUNC_GETENTERPRISE = "GetEnterprise";

    public static final String FUNC_ADDENTERPRISE = "AddEnterprise";

    public static final String FUNC_ENTERPRISEADDRESSES = "enterpriseAddresses";

    public static final String FUNC_DELETEENTERPRISE = "DeleteEnterprise";

    public static final String FUNC_ENTERPRISES = "enterprises";

    public static final String FUNC_GETENTERPRISEBYINDEX = "GetEnterpriseByIndex";

    public static final String FUNC_ISDELETED = "IsDeleted";

    public static final String FUNC_ISEXITADDRESS = "IsExitAddress";

    public static final String FUNC_GETENTERPRISECOUNT = "GetEnterpriseCount";

    @Deprecated
    protected EnterpriseManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EnterpriseManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EnterpriseManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EnterpriseManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> UpdateEnterprise(String _entAddress, String key, String value) {
        final Function function = new Function(
                FUNC_UPDATEENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(key),
                new Utf8String(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void UpdateEnterprise(String _entAddress, String key, String value, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UPDATEENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(key),
                new Utf8String(value)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String UpdateEnterpriseSeq(String _entAddress, String key, String value) {
        final Function function = new Function(
                FUNC_UPDATEENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(key),
                new Utf8String(value)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> GetEnterprise(String _entAddress) {
        final Function function = new Function(FUNC_GETENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> AddEnterprise(String _entAddress, String _name, String _realid) {
        final Function function = new Function(
                FUNC_ADDENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(_name),
                new Utf8String(_realid)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void AddEnterprise(String _entAddress, String _name, String _realid, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(_name),
                new Utf8String(_realid)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String AddEnterpriseSeq(String _entAddress, String _name, String _realid) {
        final Function function = new Function(
                FUNC_ADDENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(_name),
                new Utf8String(_realid)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<String> enterpriseAddresses(BigInteger param0) {
        final Function function = new Function(FUNC_ENTERPRISEADDRESSES, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> DeleteEnterprise(String _entAddress) {
        final Function function = new Function(
                FUNC_DELETEENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void DeleteEnterprise(String _entAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DELETEENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String DeleteEnterpriseSeq(String _entAddress) {
        final Function function = new Function(
                FUNC_DELETEENTERPRISE, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple5<String, String, String, BigInteger, Boolean>> enterprises(String param0) {
        final Function function = new Function(FUNC_ENTERPRISES, 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple5<String, String, String, BigInteger, Boolean>>(
                new Callable<Tuple5<String, String, String, BigInteger, Boolean>>() {
                    @Override
                    public Tuple5<String, String, String, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, BigInteger, Boolean>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<Tuple3<String, String, String>> GetEnterpriseByIndex(BigInteger index) {
        final Function function = new Function(FUNC_GETENTERPRISEBYINDEX, 
                Arrays.<Type>asList(new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple3<String, String, String>>(
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> IsDeleted(String _entAddress) {
        final Function function = new Function(FUNC_ISDELETED, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> IsExitAddress(String _enterAddress) {
        final Function function = new Function(FUNC_ISEXITADDRESS, 
                Arrays.<Type>asList(new Address(_enterAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> GetEnterpriseCount() {
        final Function function = new Function(FUNC_GETENTERPRISECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static EnterpriseManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnterpriseManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EnterpriseManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnterpriseManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EnterpriseManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EnterpriseManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EnterpriseManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EnterpriseManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EnterpriseManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnterpriseManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnterpriseManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnterpriseManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EnterpriseManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnterpriseManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnterpriseManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnterpriseManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
