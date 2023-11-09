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
public class roleServiceImpl implements RoleService
{

    private final RoleRepository gasStationRepository;

    @Autowired
    public roleServiceImpl(RoleRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public Role addRole(Role employee) {
        return gasStationRepository.save(employee);
    }

    public List<Role> findAllRoles() {
        return gasStationRepository.findAll();
    }

    public Role updateRole(Role role) {
        return gasStationRepository.save(role);
    }

    public Role findRoleById(Integer id) {
        return gasStationRepository.findRoleById(id)
                .orElseThrow(() -> new NotFoundException("Role by id " + id + " was not found"));
    }

    public void deleteRole(Integer id){
        gasStationRepository.deleteRoleById(id);
    }
}
