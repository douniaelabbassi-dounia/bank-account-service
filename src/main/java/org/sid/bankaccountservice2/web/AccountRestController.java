package org.sid.bankaccountservice2.web;

import org.sid.bankaccountservice2.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice2.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice2.entities.BankAccount;
import org.sid.bankaccountservice2.mappers.AccountMapper;
import org.sid.bankaccountservice2.repositorie.BankAccountRepository;
import org.sid.bankaccountservice2.service.AccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public  BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s nout found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
