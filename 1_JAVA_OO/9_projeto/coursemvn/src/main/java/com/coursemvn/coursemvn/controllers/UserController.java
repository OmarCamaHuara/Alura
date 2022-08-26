package com.coursemvn.coursemvn.controllers;

import com.coursemvn.coursemvn.dao.UserDao;
import com.coursemvn.coursemvn.models.User;
import com.coursemvn.coursemvn.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Omar");
        user.setLastname("Cama");
        user.setEmail("omar.js2023@gmail.com");
        user.setPassword("topo-gigo");
        user.setPhone("(11)98080-8286");
        return user;
    }
    @RequestMapping(value = "api/users")
    public List<User> getUserList(@RequestHeader(value="Authorization") String token){
        if (!validatedToken(token)){
            return null;
        }
        return userDao.getUserList();
    }
    private boolean validatedToken(String token){
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value="Authorization") String token,
                           @PathVariable Long id){
        if (!validatedToken(token)){
            return;
        }
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public void registerUser(@RequestBody User newUser){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, newUser.getPassword());
        System.out.println(hash);
        newUser.setPassword(hash);
        userDao.registerUser(newUser);
    }
}
