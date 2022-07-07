package io.maddennis.lendtech.challenge.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_transactions",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<>();

    public Transaction(String sender, String recipient, String source, double amount, double balance, Date transactionTime) {
        this.sender = sender;
        this.recipient = recipient;
        this.source = source;
        this.amount = amount;
        this.balance = balance;
        this.transactionTime = transactionTime;
    }
}
