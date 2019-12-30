package com.example.springbootmybaitsplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:20
 */

@Data
@TableName("user")
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;




}
