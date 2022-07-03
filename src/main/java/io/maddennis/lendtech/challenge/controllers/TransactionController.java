package io.maddennis.lendtech.challenge.controllers;

import io.maddennis.lendtech.challenge.entities.RoleEnum;
import io.maddennis.lendtech.challenge.entities.Transaction;
import io.maddennis.lendtech.challenge.entities.User;
import io.maddennis.lendtech.challenge.repositories.TransactionRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;


    @ApiOperation(value = "Transactions", notes = "All transactions for the currently logged in user")
    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> fetchAllTransactions(@PathVariable String name){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        name = userDetails.getUsername();
        List<Transaction> allTransactions = transactionRepository.principalTransactions(name);
        return new ResponseEntity<>(allTransactions,HttpStatus.FOUND);
    }

    @ApiOperation(value = "Transactions", notes = "Currently logged in user transactions filtered by date")
    @GetMapping("/filteredtransactions/{id}")
    public ResponseEntity<List<Transaction>> fetchTransactionsByDate(@PathVariable String name){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        name = userDetails.getUsername();
        List<Transaction> filteredTransactions = transactionRepository.filteredPrincipalTransactions(name);
        return new ResponseEntity<>(filteredTransactions,HttpStatus.ACCEPTED);
    }
}
