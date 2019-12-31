package com.example.springbootmybaitsplus;

import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @Author huanfuan
 * @Date 2019/12/31 16:34
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void  insert(){
        User user=new User();
        user.setName("haha1");
        user.setAge(12);
        user.setEmail("huanfuan@163.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        boolean insert=user.insert();
        System.out.println(insert);
    }

    @Test
    public void selectById(){
        User user=new User();
        User user1= user.selectById(1211929805264506882L);
        System.out.println(user==user1);
        System.out.println(user1);
    }

    @Test
    public void selectById2(){
        User user=new User();
        user.setId(1211929805264506882L);
        User user1= user.selectById();
        System.out.println(user==user1);
        System.out.println(user1);
    }
    @Test
    public void updateById(){
        User user=new User();
        user.setId(1211929805264506882L);
        user.setName("jiumi");
        boolean updateById=user.updateById();
        System.out.println(updateById);

    }

    @Test
    public void deleteById(){
        User user=new User();
        user.setId(1211929805264506882L);
        boolean deleteById=user.deleteById();
        System.out.println(deleteById);

    }

    @Test
    public void insertOrUpdate(){
        User user=new User();
        user.setAge(24);
        user.setId(1211932528898691073L);
        boolean insertOrUpdate=user.insertOrUpdate();
        System.out.println(insertOrUpdate);

    }

}
