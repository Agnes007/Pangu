package com.pangu.service;

import com.pangu.entity.User;
import com.pangu.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongHao on 2017/8/7.
 */

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    //定义添加对象/数据
    public void save(User user){
        userRepository.save(user);
    }

    //定义查询 根据ID
    public User findOne(int i){
        return userRepository.findOne(i);
    }

    //定义判断 根据ID
    public boolean exists(int i){
        return userRepository.exists(i);
    }

    //判断是否有该用户
    public boolean finduser(String userid,String password){
        boolean b = false;
        User user = userRepository.findByUseridAndPassword(userid,password);
        if(user != null) {
            b = true;
        }
        return b;
    }

    public List<User> findAllUser(){
        List<User> userList = new ArrayList<User>();
        Iterable<User> userIterable = userRepository.findAll();
        userIterable.forEach(user -> {userList.add(user);});
        return userList;
    }
}
