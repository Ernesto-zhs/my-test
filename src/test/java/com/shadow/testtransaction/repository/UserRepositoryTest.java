package com.shadow.testtransaction.repository;

import com.shadow.testtransaction.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserRepositoryTest {

    @Resource
    private IUserRepository userRepository;

    @Test
    void saveTest() {
        for (int i = 0; i < 100; i++) {
            User entity = new User();
            entity.setAge(i);
            entity.setName("my name is " + i);
            userRepository.save(entity);
        }
    }

}