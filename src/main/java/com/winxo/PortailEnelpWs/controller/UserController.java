package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.dao.request.SignUpRequest;
import com.winxo.PortailEnelpWs.dao.response.JwtAuthenticationResponse;
import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.entities.Role;
import com.winxo.PortailEnelpWs.entities.User;
import com.winxo.PortailEnelpWs.repository.UserRepository;
import com.winxo.PortailEnelpWs.service.GasStationService;
import com.winxo.PortailEnelpWs.service.RoleService;
import com.winxo.PortailEnelpWs.service.UserService;
import com.winxo.PortailEnelpWs.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final GasStationService gasStationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> signup(@RequestBody User user) {
        Role role = roleService.findRoleById(user.getRole().getId());
        GasStation gasStation = gasStationService.findGasStationById(user.getGasStation().getId());
        user.setRole(role);
        user.setGasStation(gasStation);
        user.setIsDeleted(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user_added = userService.addUser(user);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        User user_found = userService.findUserById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Role role = roleService.findRoleById(user.getRole().getId());
        GasStation gasStation = gasStationService.findGasStationById(user.getGasStation().getId());
        user.setRole(role);
        user.setGasStation(gasStation);
        user.setIsDeleted(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        System.out.println(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
