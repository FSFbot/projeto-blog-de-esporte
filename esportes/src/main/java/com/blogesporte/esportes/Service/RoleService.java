package com.blogesporte.esportes.Service;

import com.blogesporte.esportes.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.beans.Transient;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    @Transactional
    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
    @Transactional
    public void deleteRole(Long id){
        Role role = findById(id);
        roleRepository.delete(role);
    }
    class RoleNotFoundException extends RuntimeException{
        RoleNotFoundException (Long id){
            super("Coud not find role " +id);
        }
    }
}
