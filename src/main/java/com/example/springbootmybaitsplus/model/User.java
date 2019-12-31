package com.example.springbootmybaitsplus.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:20
 */

@Data
public class User extends Model<User> {

    @TableId(type = IdType.NONE)
    private static final long serialVersionUID = -4134683448378290805L;

    private Long id;

    @TableField(condition = SqlCondition.LIKE)
    private String name;

    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;

    private String email;

    private Long managerId;

    private LocalDateTime createTime;




}
