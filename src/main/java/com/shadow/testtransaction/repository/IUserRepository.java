package com.shadow.testtransaction.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shadow.testtransaction.entity.User;

/**
 *  服务类
 *
 * @author Austin
 * @since 2023-03-21
 */
public interface IUserRepository extends IService<User> {

    void updateByIda(User user);

}
