package com.example.batchspringexample;

import com.example.batchspringexample.dao.BankTransaction;
import com.example.batchspringexample.dao.BankTransactionRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {

    @Autowired
    private BankTransactionRepo bankTransactionRepo;

    @Override
    public void write(List<? extends BankTransaction> items) throws Exception {
        bankTransactionRepo.saveAll(items);
    }
}
