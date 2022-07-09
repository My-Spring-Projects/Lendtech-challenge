package io.maddennis.lendtech.challenge.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    private String sender;
    private String recipient;
    private String source;
    @Column(precision = 2)
    private double amount;
    @Column(precision = 2)
    private double balance;
    private Date transactionTime;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_transactions"

    )
    private User user;

    public Transaction(String sender, String recipient, String source, double amount, double balance, Date transactionTime) {
        this.sender = sender;
        this.recipient = recipient;
        this.source = source;
        this.amount = amount;
        this.balance = balance;
        this.transactionTime = transactionTime;
    }
}
