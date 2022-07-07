package io.maddennis.lendtech.challenge.repositories;

import io.maddennis.lendtech.challenge.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    //Optional<String> fetchPrincipal(long id);
   // Optional<List<Transaction>> principalTransactions(long id);
    //double principalBalance(long id);
    //Optional<List<Transaction>> filteredPrincipalTransactions(long id);
}
