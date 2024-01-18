package com.blogesporte.esportes.Controllers;
import com.blogesporte.esportes.DTO.RoleDTO;
import com.blogesporte.esportes.Service.RoleService;
import com.blogesporte.esportes.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRole(@PathVariable Long id) {
        Role role = roleService.findById(id);
        RoleDTO roleDTO = new RoleDTO();
        return ResponseEntity.ok(roleDTO);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
        Role role = new Role();
                Role savedRole = roleService.saveRole(role);
        RoleDTO savedRoleDTO = new RoleDTO();
        return new ResponseEntity<>(savedRoleDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        Role role = new Role();
                role.setId(id);
        Role updatedRole = roleService.saveRole(role);
        RoleDTO updatedRoleDTO = new RoleDTO();
        return ResponseEntity.ok(updatedRoleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}
