package com.pangu.controller;

import com.pangu.entity.User;
import com.pangu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by DongHao on 2017/8/7.
 */

@Controller
//@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("index")
    public String indexView(){
        return "index";
    }

    @RequestMapping("userLogin")
    public String userLoginView(){
        return "user/userLogin";
    }

    //用户登录action
    @RequestMapping("SignIn")
    public String signIn(HttpServletRequest request){
        String userId = request.getParameter("userid");
        String passWord = request.getParameter("password");

        if(userService.finduser(userId,passWord) == true){
            return "redirect:/list?userId=" + userId ;
        }else {
            return "index";
        }
    }

    @RequestMapping("list")
    public String index(Model model, @RequestParam(value = "userId") String userId){

        //获取所有列表，并赋值model
        List<User> userList = userService.findAllUser();
        model.addAttribute("userList",userList);

        //获取当前id的用户信息，并赋值model
        //User user = userService.findOne(i);
        model.addAttribute(("userid"),userId);

        return "user/userList";
    }

//    @RequestMapping("/save")
//    public String save(){
//        User user = new User();
//
//        user.setUserid("donghao");
//        user.setPassword("donghao");
//        user.setName("nihao");
//        user.setAge(28);
//        userService.save(user);
//        return user.getName();
//
//    }

}
