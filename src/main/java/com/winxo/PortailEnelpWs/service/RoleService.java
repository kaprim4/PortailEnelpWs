package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.Role;
import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    Role findRoleById(Integer id);

    Role addRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Integer id);
}
