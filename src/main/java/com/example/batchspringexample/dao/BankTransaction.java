package com.example.batchspringexample.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {

    @Id
    private Long id;
    private long accountID;
    private Date transactionDate;

    @Transient //not persist this field in db
    private String strTransactionDate;

    private double amount;
}
