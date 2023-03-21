package com.shadow.testtransaction.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shadow.testtransaction.mapper.MyClassMapper;
import org.springframework.stereotype.Service;
import com.shadow.testtransaction.entity.MyClass;

/**
 * 服务实现类
 *
 * @author Austin
 * @since 2023-03-21
 */
@Service
public class MyClassRepository extends ServiceImpl<MyClassMapper, MyClass> implements IMyClassRepository {

}
