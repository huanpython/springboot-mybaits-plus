package com.example.springbootmybaitsplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huanfuan
 * @Date 2019/12/31 15:43
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void deleteById(){
        int rows=userMapper.deleteById(1094592041087729666L);
        System.out.println("删除条数："+rows);
    }

    @Test
    public void deleteByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","huanfuan");
        map.put("age",32);
        int rows=userMapper.deleteByMap(map);
        System.out.println("删除条数："+rows);
    }


    @Test
    public void deleteBatchIds(){
        int rows=userMapper.deleteBatchIds(Arrays.asList(1094592041087729666L,1094590409767661570L));
        System.out.println("删除条数："+rows);
    }


    @Test
    public void deleteByWrapper(){
        LambdaQueryWrapper<User> lambdaQuery=Wrappers.<User>lambdaQuery();
        lambdaQuery.eq(User::getAge,28).or().gt(User::getAge,41);
        int rows=userMapper.delete(lambdaQuery);
        System.out.println("删除条数："+rows);

    }



}
