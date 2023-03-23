package com.shadow.testtransaction.repository;

import com.shadow.testtransaction.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Resource
    private IUserRepository userRepository;

    @Test
    void saveTest() {
        Assertions.assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) {
                List<User> userList = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    User entity = new User();
                    entity.setAge(i * j);
                    entity.setName("my name is " + i * j);
                    userList.add(entity);
                }
                userRepository.saveBatch(userList);
            }
        });
    }

}