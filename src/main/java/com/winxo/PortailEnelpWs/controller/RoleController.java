package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.entities.Role;
import com.winxo.PortailEnelpWs.entities.User;
import com.winxo.PortailEnelpWs.repository.RoleRepository;
import com.winxo.PortailEnelpWs.repository.UserRepository;
import com.winxo.PortailEnelpWs.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles () {
        List<Role> roles = roleService.findAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        role.setIsDeleted(false);
        Role user_added = roleService.addRole(role);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Role> getRoleById (@PathVariable("id") Integer id) {
        Optional<Role> userOptional = roleRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Role user_found = roleService.findRoleById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        if (roleRepository.findRoleById(role.getId()).isPresent()) {
            Role role1 = roleRepository.findRoleById(role.getId()).get();
            role1.setLibelle(role.getLibelle());
            role1.setAlias(role.getAlias());
            role1.setUpdatedAt(LocalDateTime.now());
            role1.setIsDeleted(false);
            role1.setIsActivated(role.getIsActivated());
            roleRepository.save(role1);
            System.out.println(role1);
            return new ResponseEntity<>(role1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Integer id) {
        Optional<Role> roleOptional = roleRepository.findRoleById(id);
        if (roleOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
