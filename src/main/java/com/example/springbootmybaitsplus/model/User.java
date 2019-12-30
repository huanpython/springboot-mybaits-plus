package com.example.springbootmybaitsplus.model;


import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:20
 */

@Data
public class User {

    private Long id;

    @TableField(condition = SqlCondition.LIKE)
    private String name;

    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;

    private String email;

    private Long managerId;

    private LocalDateTime createTime;




}
