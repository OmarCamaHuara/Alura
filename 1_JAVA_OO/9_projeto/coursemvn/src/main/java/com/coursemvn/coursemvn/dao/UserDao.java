package com.coursemvn.coursemvn.dao;

import com.coursemvn.coursemvn.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    void deleteUser(Long id);

    void registerUser(User user);

    User getUserByCredencial(User user);
}
