package org.sid.bankaccountservice2.service;

import org.sid.bankaccountservice2.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice2.dto.BankAccountResponseDTO;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
