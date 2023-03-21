package com.shadow.testtransaction.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyTransactionServiceTest {

    @Resource
    private MyTransactionService myTransactionService;

    @Test
    void submitTransaction() {
        myTransactionService.submitTransaction();
    }
}