package com.shadow.testtransaction.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shadow.testtransaction.entity.User;
import com.shadow.testtransaction.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author Austin
 * @since 2023-03-21
 */
@Service
public class UserRepository extends ServiceImpl<UserMapper, User> implements IUserRepository {

    @Override
    public void updateByIda(User user) {
        updateById(user);
    }
}
