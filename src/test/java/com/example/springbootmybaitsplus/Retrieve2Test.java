package com.example.springbootmybaitsplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Map;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Retrieve2Test {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void selectPage(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();

        queryWrapper.ge("age",26);

        Page<User> page= new Page<User>(1,2);

        IPage<User> iPage= userMapper.selectPage(page,queryWrapper);

        System.out.println("总页数"+iPage.getPages());
        System.out.println("总记录数数"+iPage.getTotal());
        List<User> userList=iPage.getRecords();
        userList.forEach(System.out::println);
    }

//    @Test
//    public void selectPage2(){
//        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
//
//        queryWrapper.ge("age",26);
//
//        Page<User> page= new Page<User>(1,2);
//
//        IPage<Map<String,Object>>iPage= userMapper.selectMapsPage(page,queryWrapper);
//        System.out.println("总页数"+iPage.getPages());
//        System.out.println("总记录数数"+iPage.getTotal());
//        List<Map<String,Object>> userList=iPage.getRecords();
//        userList.forEach(System.out::println);
//
//    }

    @Test
    public void selectMyPage() {

        QueryWrapper<User> queryWrapper=new QueryWrapper<>();

        queryWrapper.ge("age",26);

        Page<User> page= new Page<User>(1,2);

        IPage<User> iPage=userMapper.selectUserPage(page,queryWrapper);
        System.out.println("总页数"+iPage.getPages());
        System.out.println("总记录数数"+iPage.getTotal());
        List<User> userList=iPage.getRecords();
        userList.forEach(System.out::println);

    }

}
