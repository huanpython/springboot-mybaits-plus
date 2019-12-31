package com.example.springbootmybaitsplus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springbootmybaitsplus.model.User;
import com.example.springbootmybaitsplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author huanfuan
 * @Date 2019/12/31 17:25
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void getOne(){
        User one=userService.getOne(Wrappers.<User>lambdaQuery().gt(User::getAge,25),false);
        System.out.println(one);
    }


    @Test
    public void Batch(){
        User user1=new User();
        user1.setName("dqwdwq");
        user1.setAge(22);

        User user2=new User();
        user2.setName("dad");
        user2.setAge(22);

        List<User> userList=Arrays.asList(user1,user2);

        boolean saveBatch= userService.saveBatch(userList);
        System.out.println(saveBatch);
    }

    @Test
    public void chain(){
        List<User>userList= userService.lambdaQuery().gt(User::getAge,25).like(User::getName,"huan").list();
        userList.forEach(System.out::println);
    }

    @Test
    public void chain1(){
       boolean update= userService.lambdaUpdate().eq(User::getAge,22).set(User::getAge,26).update();
        System.out.println(update);
    }

    @Test
    public void chain2(){
        boolean remove= userService.lambdaUpdate().eq(User::getAge,24).remove();
        System.out.println(remove);
    }
}
