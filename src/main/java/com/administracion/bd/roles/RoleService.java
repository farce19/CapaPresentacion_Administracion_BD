package com.administracion.bd.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));
    }

    public Role createRole(Role role) {
    role.setRoleId(null);
    return roleRepository.save(role);
}


    public Role updateRole(Long id, Role roleDetails) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));

        existingRole.setRoleName(roleDetails.getRoleName());
        return roleRepository.save(existingRole);
    }

    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role with ID " + id + " does not exist.");
        }
        roleRepository.deleteById(id);
    }
}
