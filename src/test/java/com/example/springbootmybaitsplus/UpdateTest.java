package com.example.springbootmybaitsplus;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author huanfuan
 * @Date 2019/12/31 15:43
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void updateById(){
        User user=new User();
        user.setId(1088248166370832385L);
        user.setAge(26);
        user.setEmail("huanfuan@163,com");
        int rows=userMapper.updateById(user);
        System.out.println("影响记录数："+rows);
    }

    @Test
    public void updateByWrapper() {
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("name","huanfuan").eq("age",12);
        User user=new User();
        user.setEmail("1111111@163.com");
        int rows=userMapper.update(user,updateWrapper);
        System.out.println("影响记录数："+rows);

    }


    @Test
    public void updateByWrapper1() {

        User whereuser=new User();
        whereuser.setName("huanfuan");

        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("name","huanfuan").eq("age",12);
        User user=new User();
        user.setEmail("1111111@163.com");
        int rows=userMapper.update(user,updateWrapper);
        System.out.println("影响记录数："+rows);

    }


    @Test
    public void updateByWrapper2() {

        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("name","huanfuan").eq("age",12)
                .set("age",30);


        int rows=userMapper.update(null,updateWrapper);
        System.out.println("影响记录数："+rows);

    }

    @Test
    public void updateByWrapperLambda() {


        LambdaUpdateWrapper<User> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getName,"huanfuan").eq(User::getAge,30)
                .set(User::getAge,31);

        int rows=userMapper.update(null,lambdaUpdateWrapper);
        System.out.println("影响记录数："+rows);

    }

    @Test
    public void updateByWrapperLambdaChain() {
        Boolean update= new LambdaUpdateChainWrapper<User>(userMapper)
        .eq(User::getName,"huanfuan").eq(User::getAge,31)
                .set(User::getAge,32).update();
        System.out.println(update);



    }

}
