package org.sid.bankaccountservice2.web;

import org.sid.bankaccountservice2.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice2.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice2.entities.BankAccount;
import org.sid.bankaccountservice2.entities.Customer;
import org.sid.bankaccountservice2.repositorie.BankAccountRepository;
import org.sid.bankaccountservice2.repositorie.CustomerRepository;
import org.sid.bankaccountservice2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService ;
    @Autowired
    private CustomerRepository customerRepository;



    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id ,@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public void daleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
    }
    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }


}
