package com.example.springbootmybaitsplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import com.example.springbootmybaitsplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Queue;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:51
 */
@RestController
public class UserController {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }

    @PostMapping("/insertUser")
    public Integer insertUser(@RequestBody User user){
        return userMapper.insert(user);
    }

    @PostMapping("updateUser")
    public Integer updateUser(@RequestBody User user){
        return userMapper.updateById(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Integer deleteUser(@PathVariable("id") String id){
        return userMapper.deleteById(id);
    }

    @GetMapping("/getUser")
    public List<User> getUser(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();

        queryWrapper.isNotNull("nick_name")
                    .ge("age",18);
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/findPage")
    public IPage<User> findPage(){
        Page<User> page=new Page<>(1,5);
        return userMapper.selectPage(page,null);
    }

    @GetMapping("/getAllByService")
    public List<User> getAllByService(){
        return  userService.list();
    }

    @PostMapping("/insertUserByService")
    public Boolean insertUserByService(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/updateByService")
    public Boolean updateByService(@RequestBody User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();

        queryWrapper.eq("id",user.getId());

        return userService.update(user,queryWrapper);
    }

    @DeleteMapping("/deleteByService/{id}")
    public Boolean deleteByService(@PathVariable("id")String id){
        return userService.removeById(id);
    }







}
