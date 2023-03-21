package com.shadow.testtransaction.service;

import com.shadow.testtransaction.entity.MyClass;
import com.shadow.testtransaction.entity.User;
import com.shadow.testtransaction.repository.IMyClassRepository;
import com.shadow.testtransaction.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author austin
 * @since 2023-03-21
 */
@Service
public class MyTransactionService {

    @Resource
    private IMyClassRepository myClassRepository;
    @Resource
    private IUserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void submitTransaction() {
        MyClass entity = new MyClass();
        entity.setCreateTime(LocalDateTime.now());
        entity.setId(1638071315261804546L);
        entity.setClassName("English");
        myClassRepository.updateById(entity);

        update();
    }

    private void update() {
        User entity = new User();
        entity.setId(1L);
        entity.setName("austiaa11");
        entity.setAge(111);
        userRepository.updateByIda(entity);
        update1();
        MyClass myClass = new MyClass();
        myClass.setCreateTime(LocalDateTime.now());
        myClass.setId(1638069368156811266L);
        myClass.setClassName("mathematics");
        myClassRepository.updateById(myClass);

    }

    public void update1() {
        update2();

    }
    public void update2() {
        System.out.println(1 % 0);
    }
}
