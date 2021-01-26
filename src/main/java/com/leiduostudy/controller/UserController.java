package com.leiduostudy.controller;


import com.leiduostudy.common.lang.Result;
import com.leiduostudy.entity.User;
import com.leiduostudy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 学习用leiduo
 * @since 2020-12-29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequiresAuthentication
    @GetMapping("/index")
    public Object index(){
        User user= userService.getById(1L);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Object save(@Validated @RequestBody User user){

        return Result.success(user);
    }

}
