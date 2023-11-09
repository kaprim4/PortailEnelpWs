package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.Role;
import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    Role findRoleById(Integer id);

    Role updateRole(Role user);

    void deleteRole(Integer id);
}
