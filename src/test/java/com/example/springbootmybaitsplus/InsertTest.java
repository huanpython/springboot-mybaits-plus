package com.example.springbootmybaitsplus;

import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void  insert(){
        User user=new User();
        user.setName("啾咪");
        user.setAge(12);
        user.setEmail("huanfuan@163.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        int rows=userMapper.insert(user);
        System.out.println("影响记录数："+rows);
    }

}
