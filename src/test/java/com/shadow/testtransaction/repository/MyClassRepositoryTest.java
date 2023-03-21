package com.shadow.testtransaction.repository;

import com.shadow.testtransaction.entity.MyClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class MyClassRepositoryTest {


    @Resource
    private IMyClassRepository myClassRepository;

    @Test
    void saveTest() {
        for (int i = 0; i < 100; i++) {
            MyClass entity = new MyClass();
            entity.setClassName("Chinese " + i);
            entity.setCreateTime(LocalDateTime.now());
            myClassRepository.save(entity);
        }
    }


}