package com.example.springbootmybaitsplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybaitsplus.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author huanfuan
 * @Date 2019/12/30 23:01
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {



    List<User> selectAll(@Param(Constants.WRAPPER)Wrapper<User>wrapper);

    IPage<User>selectUserPage(Page<User>page,@Param(Constants.WRAPPER)Wrapper<User>wrapper);
}
