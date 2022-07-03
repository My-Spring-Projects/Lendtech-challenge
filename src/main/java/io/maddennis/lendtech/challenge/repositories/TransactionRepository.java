package io.maddennis.lendtech.challenge.repositories;

import io.maddennis.lendtech.challenge.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query(value = "select * from transactions t")
    List<Transaction> principalTransactions(String name);
    @Query(value = "select a.account_balance from users where a.username= :name", nativeQuery = true)
    List<Transaction> filteredPrincipalTransactions(String name);
}
