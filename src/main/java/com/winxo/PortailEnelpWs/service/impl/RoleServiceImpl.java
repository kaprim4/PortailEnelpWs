package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.Role;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.RoleRepository;
import com.winxo.PortailEnelpWs.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService
{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    public Role findRoleById(Integer id) {
        return roleRepository
                .findRoleById(id)
                .orElseThrow(() -> new NotFoundException("Role by id " + id + " was not found"));
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
