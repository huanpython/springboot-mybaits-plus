package com.example.springbootmybaitsplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.springbootmybaitsplus.mapper.UserMapper;
import com.example.springbootmybaitsplus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/26 0026 上午 11:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrieveTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void  selectById(){
        User user=userMapper.selectById(1211686143070806018L);
        System.out.println(user);
    }
    @Test
    public void  selectIds(){
        List<Long> ids= Arrays.asList(1211686143070806018L,1L,2L);
        List<User> userList= userMapper.selectBatchIds(ids);
        userList.forEach(System.out::println);
    }

    @Test
    public void  selectByMap(){
        Map<String,Object> columnMap=new HashMap<>();
        columnMap.put("name","Jone");
        columnMap.put("age",18);
       List<User> userList= userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","雨").lt("age",40);
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapper2(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","T").between("age",20,40).isNotNull("email");
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper3(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("name","王").or().ge("age",25).orderByDesc("age")
                .orderByAsc("id");
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper4(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}","2019-02-14")
                .inSql("manager_id","select id from user where name like '王%'");
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper5(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
       queryWrapper.likeRight("name","王").and(wq ->wq.lt("age",40).or().isNotNull("email"));
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper6(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("name","王")
                .or(wq ->wq.lt("age",40).gt("age",20).isNotNull("email"));
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper7(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.nested(wq ->wq.lt("age",40).or().isNotNull("email"))
                .likeRight("name","王");
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapper8(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
       queryWrapper.in("age",Arrays.asList(30,31,34,35));
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapper9(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(30,31,34,35)).last("limit 1");
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapperSupper(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","name").like("name","雨").lt("age",40);
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapperSupper2(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","雨").lt("age",40)
                .select(User.class,info ->!info.getColumn().equals("create_time")&&
                        !info.getColumn().equals("manager_id"));
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapperEntity(){
        User whereuser=new User();
        whereuser.setName("huanfuan");
        whereuser.setAge(12);

        QueryWrapper<User> queryWrapper=new QueryWrapper<>(whereuser);
        //queryWrapper.like("name","雨").lt("age",40);
        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapperAllEq(){
        User whereuser=new User();


        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        Map<String,Object> params=new HashMap<>();
        params.put("name","huanfuan");
        params.put("age",null);
        queryWrapper.allEq((k,v)->!k.equals("name"),params);

        List<User> userList=userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapperMaps(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","name").like("name","huanfuan").lt("age",40);
        List<Map<String,Object>> userList=userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapperMaps2(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age")
                .groupBy("manager_id").having("sum(age)<{0}",500);


        List<Map<String,Object>> userList=userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void selectByWrapperObjs(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","name").like("name","huanfuan").lt("age",40);
        List<Object> userList=userMapper.selectObjs(queryWrapper);
        userList.forEach(System.out::println);

    }


    @Test
    public void selectByWrapperCount(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","huanfuan").lt("age",40);
        Integer integer=userMapper.selectCount(queryWrapper);
        System.out.println("总记录数"+integer);

    }


    @Test
    public void selectByWrapperOne(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","huanfuan").lt("age",40);
        User user=userMapper.selectOne(queryWrapper);
        System.out.println(user);

    }

    @Test
    public void selectLamda() {

        LambdaQueryWrapper<User> lambdaQuery= Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName,"huanfuan").lt(User::getAge,40);
        List<User> userList=userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectLamda2() {

        LambdaQueryWrapper<User> lambdaQuery= Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName,"huan")
                .and(lqw->lqw.lt(User::getAge,40).or().isNotNull(User::getEmail));
        List<User> userList=userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectLamda3() {
        List<User> userList= new LambdaQueryChainWrapper<User>(userMapper)
                .like(User::getName,"huan").ge(User::getAge,20).list();
        userList.forEach(System.out::println);
    }


    @Test
    public void selectMy() {

        LambdaQueryWrapper<User> lambdaQuery= Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName,"huan")
                .and(lqw->lqw.lt(User::getAge,40).or().isNotNull(User::getEmail));
        List<User> userList=userMapper.selectAll(lambdaQuery);
        userList.forEach(System.out::println);
    }
}
