package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.User;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.UserRepository;
import com.winxo.PortailEnelpWs.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository
                .findUserById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
