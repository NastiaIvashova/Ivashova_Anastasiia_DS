package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.Role;
import edu.kpi.iasa.mmsa.pizzadelivery.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoleController
{
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService)
    {
        this.roleService = roleService;
    }

    @GetMapping(value = "/role")
    public ResponseEntity<List<Role>> getRoles()
    {
        return ResponseEntity.ok(roleService.getRoles());
    }

    @PostMapping(value = "/role")
    public ResponseEntity<Role> postRoles(@Valid @RequestBody Role newRole)
    {
        return ResponseEntity.ok(roleService.saveRole(newRole));
    }

    @GetMapping(value = "/role/{id_role}")
    public ResponseEntity<Role> getRole(@PathVariable Long id_role)
    {
        return ResponseEntity.ok(roleService.getRoleById(id_role));
    }

    @PutMapping(value = "/role/{id_role}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id_role, @Valid @RequestBody Role updatedRole)
    {
        return ResponseEntity.ok(roleService.updateRoleById(id_role, updatedRole));
    }

    @DeleteMapping(value = "/role/{id_role}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id_role)
    {
        return ResponseEntity.ok(roleService.deleteRoleById(id_role));
    }
}
