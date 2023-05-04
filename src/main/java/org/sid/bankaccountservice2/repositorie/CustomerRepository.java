package org.sid.bankaccountservice2.repositorie;

import org.sid.bankaccountservice2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
