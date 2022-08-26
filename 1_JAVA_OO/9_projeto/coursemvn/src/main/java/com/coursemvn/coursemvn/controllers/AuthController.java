package com.coursemvn.coursemvn.controllers;

import com.coursemvn.coursemvn.dao.UserDao;
import com.coursemvn.coursemvn.models.User;
import com.coursemvn.coursemvn.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user){
        User loggedUser = userDao.getUserByCredencial(user);

        if(loggedUser != null){
            return jwtUtil.create(loggedUser.getId().toString(), loggedUser.getEmail());
        }
        return "FAIL";
    }
}
