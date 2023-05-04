package org.sid.bankaccountservice2.mappers;

import org.sid.bankaccountservice2.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice2.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO) ;
        return bankAccountResponseDTO;
    }

}
