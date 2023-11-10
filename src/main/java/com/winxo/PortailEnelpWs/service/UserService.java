package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> findAllUsers();

    User findUserById(Integer id);

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Integer id);
}
