package com.example.springbootmybaitsplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import com.example.springbootmybaitsplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author huanfuan
 * @Date 2019/12/30 23:02
 * @Version 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
}
