package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.Role;
import com.winxo.PortailEnelpWs.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles () {
        List<Role> roles = roleService.findAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Role> getRoleById (@PathVariable("id") Integer id) {
        Role role = roleService.findRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        Role updateRole = roleService.updateRole(role);
        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
