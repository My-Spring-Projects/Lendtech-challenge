package io.maddennis.lendtech.challenge.controllers;

import io.maddennis.lendtech.challenge.entities.RoleEnum;
import io.maddennis.lendtech.challenge.entities.Transaction;
import io.maddennis.lendtech.challenge.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @GetMapping("/balance/{id}")
    public ResponseEntity<Double> loanBalance(@PathVariable long id){
        return new ResponseEntity<>(1200.00, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> fetchAllTransactions(@PathVariable long id){
        List<Transaction> transactions;
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/filteredtransactions/{id}")
    public ResponseEntity<List<Transaction>> fetchTransactionsByDate(@PathVariable long id){
        List<Transaction> transactions;
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
