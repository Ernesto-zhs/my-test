package com.shadow.testtransaction.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author Austin
 * @since 2023-03-21
 */
@Getter
@Setter
@TableName("t_class")
public class MyClass {


    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String className;

    private LocalDateTime createTime;


}
